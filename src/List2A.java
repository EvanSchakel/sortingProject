// List2A.java - Smarter sorted list (caches the last accessed node)
// Compares against lastNode first so words coming at or after it skip the whole prefix
// Evan Schakel, Nov 2026

public class List2A extends BaseList
{
    private LLNode lastNode; //saves wherever the previous search/insert ended up

    // sets up empty smart sorted list with cached node starting at null
    public List2A()
    {
        super();
        lastNode = null;
    }

    // Adds word in alphabetical order while remembering the last touched node.
    // First compares word against lastNode (if we have one): if word >= lastNode
    // we start scanning from lastNode instead of the head, otherwise start at list.
    // Finds match or sorted gap, inserts/increments, and saves that node in lastNode.
    @Override
    public void add(String word)
    {
        LLNode current;          //search cursor
        LLNode previous = null;  //tracks node right before current

        if (lastNode != null)
        {
            keyCompare++;
            int lastComparison = word.compareTo(lastNode.getWord());

            if (lastComparison >= 0)
            {
                current = lastNode; //can pick up from cached spot
            }
            else
            {
                current = list; //need to restart from the front
            }
        }
        else
        {
            current = list;
        }

        while (current != null)
        {
            keyCompare++;
            int comparison = word.compareTo(current.getWord());

            if (comparison == 0)
            {
                current.incrementCount();
                lastNode = current;
                return;
            }
            else if (comparison < 0)
            {
                break; //found insertion spot
            }
            else
            {
                previous = current;
                current = current.getNext();
            }
        }

        LLNode newNode; //holds the newly allocated node so we can cache it at the end
        if (list == null)
        {
            newNode = new LLNode(word);
            list = newNode;
            refChanges++; //list = newNode
        }
        else if (previous == null)
        {
            //inserting before whatever node current stopped at (head or lastNode)
            newNode = new LLNode(word, list);
            refChanges++; //newNode.next = list
            list = newNode;
            refChanges++; //list = newNode
        }
        else if (current == null)
        {
            //append onto the tail
            newNode = new LLNode(word);
            previous.setNext(newNode);
            refChanges++; //ref change
        }
        else
        {
            //insert between previous and current
            newNode = new LLNode(word, current);
            refChanges++; //newNode.next = current
            previous.setNext(newNode);
            refChanges++; //previous.next = newNode
        }

        lastNode = newNode; //remember for next call
    }
}
