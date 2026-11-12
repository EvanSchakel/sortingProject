public class LLNode {
    private String word;
    //stores the word in this node
    private int count;
//how many time the word appears
    private LLNode next;
    //points to the next node in list

    public LLNode(String word) {
        //constructor that recives in a word when creating a node
        this.word = word;
        //passses in the word we use
        this.count = 1;
        //starts with a count of 1/because its the first occurence of that word
        this.next = null;
        //there is no next node, list later connects it to newNode.setNext(list)
    }

    public LLNode(String word, LLNode next) {
        //using LLNode contsurctor again, passes in a string and then we call next(next as in the next data)
        this.word = word;
        //we say that word we pass in is this word
        this.count = 1;
        //count is now 1 sicne the word got sucesfully passed in
        this.next = next;
        //calling for the next node to be ready for the next string
    }

    public String getWord() {
        return word;


    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;    
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;    
}
}