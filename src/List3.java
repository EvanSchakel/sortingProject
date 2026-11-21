// List3.java - Move-to-Front self-adjusting list
// Evan Schakel - 11/10/2026
// Searches sequentially from head; repeats get yanked to the very front, and new words
// also go onto the front. Keeps hot words close to list head.

public class List3 extends BaseList
{
    // Constructor: calls BaseList() to clear counters and set head null
    public List3()
    {
        super();
    }

    // Adds a word (or increments an existing one) and pulls matched interior nodes
    // straight to the front of the chain. Scans with current/previous; if matched and
    // not already at head, splices around current and relinks it to list (3 ref changes).
    @Override
    public void add(String word)
    {
        LLNode current = list;   //current node being checked
        LLNode previous = null;  //needed so we can unlink current on a match

        while (current != null)
        {
            keyCompare++;

            if (word.equals(current.getWord()))
            {
                current.incrementCount();

                //only need to move it if it isn't already at the head
                if (previous != null)
                {
                    previous.setNext(current.getNext());
                    refChanges++; //bypass current

                    current.setNext(list);
                    refChanges++; //point current at old head

                    list = current;
                    refChanges++; //move head to current
                }
                return;
            }

            previous = current;
            current = current.getNext();
        }

        //brand new word goes right on the front
        LLNode newNode = new LLNode(word, list);
        refChanges++; //ref change
        list = newNode;
        refChanges++; //ref change
    }
}
