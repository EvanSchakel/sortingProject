public class List3 extends BaseList {

    public List3() {
        super();
    }

    @Override
    public void add(String word) {
        LLNode current = list;
        LLNode previous = null;

//look for it and keep the last node too
        while (current != null) {
            keyCompare++;

            if (current.getWord().equals(word)) {
                current.incrementCount();

//move it up if it wasnt first
                if (previous != null) {
                    previous.setNext(current.getNext());
                    refChanges++;

                    current.setNext(list);
                    refChanges++;

                    list = current;
                    refChanges++;
                }

                return;
            }

            previous = current;
            current = current.getNext();
        }

//new stuff goes in front
        LLNode newNode = new LLNode(word);
        newNode.setNext(list);
        refChanges++;

        list = newNode;
        refChanges++;
    }
}
