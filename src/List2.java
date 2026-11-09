public class List2 extends BaseList {

    public List2() {
        super();
    }

    @Override
    public void add(String word) {
        LLNode current = list;
        LLNode previous = null;

        while (current != null) {
            int comparison = word.compareTo(current.getWord());
            keyCompare++;

            if (comparison == 0) {
                current.incrementCount();
                return;
            }

            if (comparison < 0) {
                break;
            }

            previous = current;
            current = current.getNext();
        }

        LLNode newNode = new LLNode(word);

        if (previous == null) {
            newNode.setNext(list);
            refChanges++;

            list = newNode;
            refChanges++;
        } else {
            newNode.setNext(current);
            refChanges++;

            previous.setNext(newNode);
            refChanges++;
        }
    }
}
