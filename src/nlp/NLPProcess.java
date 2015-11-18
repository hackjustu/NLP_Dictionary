package nlp;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class NLPProcess {

    public static void main(String[] args) {

        TreeSet<String> dict = new TreeSet<>();

        // Read the raw data from the resource folder
        try (BufferedReader br = new BufferedReader(new FileReader("resource/OANC_written_all"))) {
            // Read the raw data line by line
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {

                // Split the current line by the space
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!dict.contains(word)) {
                        // If the word doesn't occur before, store it to the dictionary
                        dict.add(word);
                    }
                }
                // read the next line
                line = br.readLine();
            }

            PrintWriter writer = new PrintWriter("dictionary.txt", "UTF-8");
            // Navigate through the dictionary in a descending order
            for (Iterator<String> iter = dict.descendingIterator(); iter.hasNext(); ) {
                String word = iter.next();
                // write the word to the dictionary.txt
                writer.println(word);
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }
}
