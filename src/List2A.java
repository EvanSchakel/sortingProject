public class List2A extends BaseList {
    private LLNode lastNode;

    public List2A() {
        super();
    }

    @Override
    public void add(String word) {
LLNode current;
LLNode previous;

if (lastNode == null){
    current = list;
    previous = null;
}
else if(word.compareTo(lastNode.getWord()) < 0){
current = list;
    previous = null;

}
else{

    current = lastNode;
    previous = lastNode;
}


    }
}
