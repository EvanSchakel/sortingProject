public class List2A extends BaseList {
    private LLNode lastNode;

    public List2A() {
        super();
    }

    @Override
    public void add(String word) {
        LLNode current;
        LLNode previous;

        if (lastNode == null) {
            current = list;
            previous = null;
        } else if (word.compareTo(lastNode.getWord()) < 0) {
            current = list;
            previous = null;
        } else {
            current = lastNode;
            previous = lastNode;
        }

        while (current != null) {
            int comparison = word.compareTo(current.getWord());
            keyCompare++;

            if (comparison == 0) {
                current.incrementCount();
                lastNode = current;
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

        lastNode = newNode;
    }
}
