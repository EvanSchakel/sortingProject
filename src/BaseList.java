public abstract class BaseList implements ListInterface {
    LLNode list;
    long refChanges;
    long keyCompare;

    public BaseList() {
this.list = null;
this.refChanges = 0;
this.keyCompare = 0;
    }

    @Override
    public long getRefChanges() {
        return refChanges;
    }

    @Override
    public long getKeyCompare() {
        return keyCompare;
    }

    @Override
    public int getDistinctWords() {
LLNode curr = list;
        int count = 0;

while(curr!= null){
    count++;
    curr = curr.getNext();
}
 return count;
    }

    @Override
    public int getTotalWords() {
        int total = 0;
LLNode curr = list;
while ( curr != null){

total = total + curr.getCount();
    curr = curr.getNext();
}

        return total;
    }
}
