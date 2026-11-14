import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java MainClass filename");
            return;
        }

        List1 list1 = new List1();
        List2 list2 = new List2();
        List2A list2A = new List2A();
        List3 list3 = new List3();
        List4 list4 = new List4();

        BufferedReader reader = null;
        long startTime = System.nanoTime();

//get the words in there somehow
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.toLowerCase().split("\\s+");
                int place = 0;

                while (place < words.length) {
                    String rawWord = words[place];

//ignore the double dash mess
                    if (!rawWord.isEmpty() && !rawWord.contains("--")) {
                        String word = rawWord.replaceAll("[^a-z']", "");

                        if (!word.isEmpty()) {
                            list1.add(word);
                            list2.add(word);
                            list2A.add(word);
                            list3.add(word);
                            list4.add(word);
                        }
                    }

                    place++;
                }

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException error) {
            System.out.println("could not open or read that file");
            System.out.println(error.getMessage());
            return;
        }

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println();
        System.out.println("List1");
        System.out.println("Distinct words: " + list1.getDistinctWords());
        System.out.println("Total words: " + list1.getTotalWords());
        System.out.println("Key Comparisions: " + list1.getKeyCompare());
        System.out.println("reference Changes: " + list1.getRefChanges());

        System.out.println();
        System.out.println("List2");
        System.out.println("Distinct words: " + list2.getDistinctWords());
        System.out.println("Total words: " + list2.getTotalWords());
        System.out.println("Key Comparisions: " + list2.getKeyCompare());
        System.out.println("reference Changes: " + list2.getRefChanges());

        System.out.println();
        System.out.println("List2A");
        System.out.println("Distinct words: " + list2A.getDistinctWords());
        System.out.println("Total words: " + list2A.getTotalWords());
        System.out.println("Key Comparisions: " + list2A.getKeyCompare());
        System.out.println("reference Changes: " + list2A.getRefChanges());

        System.out.println();
        System.out.println("List3");
        System.out.println("Distinct words: " + list3.getDistinctWords());
        System.out.println("Total words: " + list3.getTotalWords());
        System.out.println("Key Comparisions: " + list3.getKeyCompare());
        System.out.println("reference Changes: " + list3.getRefChanges());

        System.out.println();
        System.out.println("List4");
        System.out.println("Distinct words: " + list4.getDistinctWords());
        System.out.println("Total words: " + list4.getTotalWords());
        System.out.println("Key Comparisions: " + list4.getKeyCompare());
        System.out.println("reference Changes: " + list4.getRefChanges());

        System.out.println();
        System.out.println("Processing time (nanoseconds): " + elapsedTime);
    }
}
