// BaseList.java
// Abstract base class that the 5 linked list variants extend
// Keeps track of the head node, refChanges, and keyCompare plus the shared getters
// Evan Schakel - Nov 10, 2026

public abstract class BaseList implements ListInterface
{
    LLNode list;      //head reference for the linked list
    long refChanges;  //counter for link/head reassignments
    long keyCompare;  //counter for word comparisons

    // Sets up a fresh empty list with both performance counters zeroed out
    public BaseList()
    {
        list = null;
        refChanges = 0;
        keyCompare = 0;
    }

    // Returns total reference changes recorded while building this list
    @Override
    public long getRefChanges()
    {
        return refChanges;
    }

    //Returns total key comparisons made so far
    @Override
    public long getKeyCompare()
    {
        return keyCompare;
    }

    // Counts unique words in the list by walking from list to null and counting nodes
    @Override
    public int getDistinctWords()
    {
        int count = 0; //node counter
        LLNode curr = list; //start walking from front
        while (curr != null)
        {
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    // Walks every node in the chain and sums up all node frequency counts
    @Override
    public int getTotalWords()
    {
        int count = 0; //running total across all nodes
        LLNode curr = list;
        while (curr != null)
        {
            count += curr.getCount();
            curr = curr.getNext();
        }
        return count;
    }

    //Exposes head node so MainClass can print out the first 100 entries
    public LLNode getList()
    {
        return list;
    }
}
