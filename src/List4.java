public class List4 extends BaseList {

    public List4() {
        super();
    }

    @Override
    public void add(String word) {
        LLNode current = list;
        LLNode previous = null;
        LLNode previousPrevious = null;

//walk through the list looking for the word
        while (current != null) {
            keyCompare++;

            if (current.getWord().equals(word)) {
                current.incrementCount();

//bump repeats up one spot...not all the way
                if (previous != null) {
                    if (previousPrevious != null) {
                        previousPrevious.setNext(current);
                        refChanges++;
                    } else {
                        list = current;
                        refChanges++;
                    }

                    previous.setNext(current.getNext());
                    refChanges++;

                    current.setNext(previous);
                    refChanges++;
                }

                return;
            }

            previousPrevious = previous;
            previous = current;
            current = current.getNext();
        }

//didnt find it so put the new one up front
        LLNode newNode = new LLNode(word);
        newNode.setNext(list);
        refChanges++;

        list = newNode;
        refChanges++;
    }
}
