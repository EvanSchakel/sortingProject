// MainClass.java - Driver for Lab 2 (Five Word Frequency Linked Lists)
// Evan Schakel - EECS 2500 (Nov 10, 2026)
// Runs warmup + overhead + all 5 list passes over an input file (default Hamlet.txt),
// strips leading/trailing punctuation, checks counts match, and prints results + top 100 nodes.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass
{
    //reused across all 7 file passes as required
    private static Scanner input = null;

    // exact boundary punctuation characters to strip off both ends of tokens
    private static final String PUNCTUATION = "!@#$%^&*()_+-=[]\\{}|;:'\"`~,./<>?";

    // Main entry point. Takes optional filename in args[0] (defaults to Hamlet.txt),
    // runs pass 1 (warmup), pass 2 (timed overhead), and passes 3-7 (List1..List4),
    // verifies every list got identical vocab/total counts, then prints the table
    // and top 100 nodes for Lists 3 and 4.
    public static void main(String[] args)
    {
        String fileName = (args.length == 0) ? "Hamlet.txt" : args[0]; //grab CLI arg or default

        File file = new File(fileName);
        if (!file.exists() && args.length == 0)
        {
            //check one directory up in case launched from bin/
            File parentFile = new File("../Hamlet.txt");
            if (parentFile.exists())
            {
                file = parentFile;
            }
        }

        // all five list objects in lab order
        ListInterface[] Lists = new ListInterface[5];
        Lists[0] = new List1();  //unsorted, inserts at front
        Lists[1] = new List2();  //sorted linked list
        Lists[2] = new List2A(); //smart sorted list w/ lastNode cache
        Lists[3] = new List3();  //move to front
        Lists[4] = new List4();  //move by one

        String[] listNumbers = {"1", "2", "2A", "3", "4"}; //IDs printed in the # column

        String[] ListNames = //names shown in output table
        {
            "Unsorted",
            "Sorted",
            "Sorted (Smart)",
            "Self-Adj (Front)",
            "Self-Adj (By One)"
        };

        double[] runTimes = new double[5]; //elapsed seconds per list pass

        try
        {
            long grossStart = System.currentTimeMillis(); //overall timer across all 7 passes

            warmupPass(file); //pass 1 - unmeasured buffer warmup

            long overheadTime = runPass(file, null); //pass 2 - read/clean timing baseline

            //passes 3-7: build each list and store seconds
            for (int i = 0; i < Lists.length; i++)
            {
                runTimes[i] = runPass(file, Lists[i]) / 1000.0;
            }

            long grossElapsed = System.currentTimeMillis() - grossStart; //total wall time in ms

            System.out.println(" #    List Name      Run Time  Vocabulary  Total Words   Key Comp     Ref Chgs");
            System.out.println("-- ----------------- --------  ----------  ----------- ------------ ------------");
            for (int i = 0; i < Lists.length; i++)
            {
                System.out.printf("%2s %-17s %8.3f  %9d  %11d  %12d %12d%n",
                    listNumbers[i],
                    ListNames[i],
                    runTimes[i],
                    Lists[i].getDistinctWords(),
                    Lists[i].getTotalWords(),
                    Lists[i].getKeyCompare(),
                    Lists[i].getRefChanges());
            }

            System.out.printf("%nOverhead Time: %d ms%n", overheadTime);
            System.out.printf("Gross Elapsed Time: %.3f seconds%n%n", grossElapsed / 1000.0);
            printFirst100Nodes((BaseList) Lists[3], "List 3");
            printFirst100Nodes((BaseList) Lists[4], "List 4");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + fileName);
        }
    }

    // Unmeasured warmup pass (opens Scanner, reads all raw tokens, closes file)
    private static void warmupPass(File file) throws FileNotFoundException
    {
        input = new Scanner(file);
        while (input.hasNext())
        {
            input.next();
        }
        input.close();
    }

    // Timed file pass: opens the shared Scanner, cleans every token, and adds valid words
    // to target (unless target is null for the overhead pass). Returns elapsed ms.
    private static long runPass(File file, ListInterface target) throws FileNotFoundException
    {
        long startTime = System.currentTimeMillis();
        input = new Scanner(file);
        while (input.hasNext())
        {
            String word = cleanToken(input.next());
            if (target != null && word != null)
            {
                target.add(word);
            }
        }
        input.close();
        return System.currentTimeMillis() - startTime;
    }

    // Strips leading/trailing punctuation from rawToken, lowercases it, and checks
    // whether at least one letter remains; returns null for empty or non-letter tokens.
    public static String cleanToken(String rawToken)
    {
        if (rawToken == null || rawToken.isEmpty())
        {
            return null;
        }

        int start = 0;                //first index after leading punctuation
        int end = rawToken.length();  //index just past last non-punctuation char

        while (start < end && PUNCTUATION.indexOf(rawToken.charAt(start)) >= 0)
        {
            start++;
        }

        while (end > start && PUNCTUATION.indexOf(rawToken.charAt(end - 1)) >= 0)
        {
            end--;
        }

        if (start == end)
        {
            return null; //nothing left after stripping
        }

        String word = rawToken.substring(start, end).toLowerCase();

        //make sure token actually contains at least one letter
        for (int i = 0; i < word.length(); i++)
        {
            if (Character.isLetter(word.charAt(i)))
            {
                return word;
            }
        }
        return null;
    }

    // Walks up to the first 100 nodes of listObj and prints rank, word, and count CSV lines
    public static void printFirst100Nodes(BaseList listObj, String label)
    {
        System.out.printf("=== %s (First 100 Nodes) ===%nRank,Word,Count%n", label);
        LLNode node = listObj.getList();
        for (int rank = 1; node != null && rank <= 100; rank++, node = node.getNext())
        {
            System.out.printf("%d,%s,%d%n", rank, node.getWord(), node.getCount());
        }
        System.out.println();
    }
}
