package nlp;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class NLPProcess {

    public static void main(String[] args) {

        TreeSet<String> dict = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("resource/OANC_written_all"))) {

            String line = br.readLine();
            while (line != null && !line.isEmpty()) {

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!dict.contains(word)) {
                        dict.add(word);
                    }
                }
                line = br.readLine();
            }

            PrintWriter writer = new PrintWriter("dictionary.txt", "UTF-8");
            for (Iterator<String> iter = dict.descendingIterator(); iter.hasNext(); ) {
                String word = iter.next();
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
