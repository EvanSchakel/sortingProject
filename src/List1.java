// List1.java - Unsorted linked list (adds new words right at the front)
// Evan Schakel, 11/10/2026
// Searches straight from the head to look for duplicates; if none, prepends a new node.

public class List1 extends BaseList
{
    // constructor - calls BaseList to initialize head and counters
    public List1()
    {
        super();
    }

    // Adds word to the unsorted list:
    // scans from list head counting 1 comparison per node visited. If matched,
    // bumps count and returns; otherwise inserts a new node at front (2 ref changes).
    @Override
    public void add(String word)
    {
        LLNode curr = list; //walks through the list from head

        while (curr != null)
        {
            keyCompare++;
            if (word.equals(curr.getWord()))
            {
                curr.incrementCount();
                return; //found it so bump count and leave
            }
            curr = curr.getNext();
        }

        //not in list yet, tack a new node onto the front
        LLNode newNode = new LLNode(word, list);
        refChanges++; //ref change (newNode.next = list)
        list = newNode;
        refChanges++; //ref change (list = newNode)
    }
}
