/*
 * List4.java - Move-by-One (transpose) self-adjusting linked list
 * Author: Evan Schakel (Nov 10, 2026)
 * Searches from front; on a match not already at the head, swaps that node one slot
 * forward with its predecessor. Brand new words get pushed onto the front.
 */

public class List4 extends BaseList
{
    //Default constructor initializing empty list via BaseList
    public List4()
    {
        super();
    }

    // Adds word or bumps its count, nudging repeated words one position closer to head.
    // Keeps three pointers (current, previous, twoBack) during traversal so when a match
    // is found past index 0, we can swap current and previous cleanly (3 ref changes).
    @Override
    public void add(String word)
    {
        LLNode current = list;   //node currently under inspection
        LLNode previous = null;  //one node behind current (swap target)
        LLNode twoBack = null;   //two nodes behind current so we can relink after swap

        while (current != null)
        {
            keyCompare++;

            if (word.equals(current.getWord()))
            {
                current.incrementCount();

                if (previous != null) //if it's already head there's nowhere to swap
                {
                    previous.setNext(current.getNext());
                    refChanges++; //previous skips over current

                    current.setNext(previous);
                    refChanges++; //current now points back at previous

                    if (twoBack == null)
                    {
                        list = current; //previous was head so current becomes new head
                    }
                    else
                    {
                        twoBack.setNext(current);
                    }
                    refChanges++; //third ref change (either head or twoBack.next)
                }
                return;
            }

            twoBack = previous;
            previous = current;
            current = current.getNext();
        }

        //word wasn't found anywhere, prepend new node at head
        LLNode newNode = new LLNode(word, list);
        refChanges++; //newNode.next = list
        list = newNode;
        refChanges++; //list = newNode
    }
}
