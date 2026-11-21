// ListInterface.java - common interface for all five linked list types
// Evan Schakel, Nov 2026
// Every list (List1, List2, List2A, List3, List4) implements these methods so
// MainClass can run all five through the same benchmarking loop.

public interface ListInterface
{
    // adds a word to the list, or bumps its count if it's already in there
    // searches however this specific list type handles lookup/inserting
    public void add(String word);

    //returns total key comparisons counted so far (reads counter)
    public long getKeyCompare();

    // returns total reference changes recorded while adding words
    public long getRefChanges();

    // walks the list to count how many unique words (nodes) are stored
    public int getDistinctWords();

    //adds up the frequency counts across every node for total words
    public int getTotalWords();
}
