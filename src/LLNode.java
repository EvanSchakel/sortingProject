/*
 * LLNode.java - Evan Schakel (11/10/2026)
 * Node class used by all 5 word frequency lists.
 * Holds a word string, its frequency counter, and the pointer to the next node.
 */

public class LLNode
{
    private String word;  //stores the word in this node
    private int count;    //how many times the word appears
    private LLNode next;  //points to the next node in list

    //constructor that takes in a word, starts count at 1 and next at null
    public LLNode(String word)
    {
        this.word = word;
        this.count = 1;
        this.next = null;
    }

    // 2-arg constructor when we already know what node comes right after it
    // sets word, starts count at 1, and links next to the passed-in node
    public LLNode(String word, LLNode next)
    {
        this.word = word;
        this.count = 1;
        this.next = next;
    }

    //returns the word saved in this node
    public String getWord()
    {
        return word;
    }

    // overwrites the node's stored word string
    public void setWord(String word)
    {
        this.word = word;
    }

    // returns how many times this node's word has been seen
    public int getCount()
    {
        return count;
    }

    //lets callers set the count directly
    public void setCount(int count)
    {
        this.count = count;
    }

    // bumps the frequency count by 1 whenever the same word shows up again
    public void incrementCount()
    {
        count++;
    }

    // grabs the next node reference in the chain
    public LLNode getNext()
    {
        return next;
    }

    //updates the link pointing to the next node
    public void setNext(LLNode next)
    {
        this.next = next;
    }
}
