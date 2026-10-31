public class LLNode {
    private String word;
    private int count;
    private LLNode next;

    public LLNode(String word) {
        this.word = word;
        this.count = 1;
        this.next = null;
    }

    public LLNode(String word, LLNode next) {
        this.word = word;
        this.count = 1;
        this.next = next;
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