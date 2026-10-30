public abstract class BaseList implements ListInterface {
    LLNode list;
    long refChanges;
    long keyCompare;

    public BaseList() {

    }

    @Override
    public long getRefChanges() {
        return 0;
    }

    @Override
    public long getKeyCompare() {
        return 0;
    }

    @Override
    public int getDistinctWords() {
        return 0;
    }

    @Override
    public int getTotalWords() {
        return 0;
    }
}
