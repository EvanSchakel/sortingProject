/*
 * List2.java
 * Alphabetically sorted linked list implementation.
 * Traverses from head until finding the word or the spot where it belongs.
 * Author: Evan Schakel  Date: Nov 10, 2026
 */

public class List2 extends BaseList
{
    //Calls BaseList constructor to start with an empty sorted list
    public List2()
    {
        super();
    }

    // Inserts word in sorted order or increments count if already in list.
    // Walks with current and previous pointers using compareTo(), breaks early once
    // current goes past word alphabetically, then handles empty/head/tail/middle insert.
    @Override
    public void add(String word)
    {
        LLNode current = list;    //node we're inspecting right now
        LLNode previous = null;   //trailing pointer one behind current

        while (current != null)
        {
            keyCompare++;
            int comparison = word.compareTo(current.getWord()); //alphabetical check

            if (comparison == 0)
            {
                current.incrementCount();
                return;
            }
            else if (comparison < 0)
            {
                break; //passed where it should go
            }
            else
            {
                previous = current;
                current = current.getNext();
            }
        }

        //figure out which of the 4 insertion spots applies
        if (list == null)
        {
            //empty list case
            list = new LLNode(word);
            refChanges++; //ref change
        }
        else if (previous == null)
        {
            //goes right at the very front ahead of old head
            LLNode newNode = new LLNode(word, list);
            refChanges++; //newNode.next = list
            list = newNode;
            refChanges++; //list = newNode
        }
        else if (current == null)
        {
            //reached the end, tack onto tail
            LLNode newNode = new LLNode(word);
            previous.setNext(newNode);
            refChanges++; //previous.next = newNode
        }
        else
        {
            //splice in between previous and current
            LLNode newNode = new LLNode(word, current);
            refChanges++; //newNode.next = current
            previous.setNext(newNode);
            refChanges++; //previous.next = newNode
        }
    }
}
