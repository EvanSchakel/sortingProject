public class TestList3 {
    public static void main(String[] args) {
        List3 list = new List3();

        list.add("cat");
        list.add("dog");
        list.add("cat");
        list.add("qwerty");
        list.add("Squivvle");
        list.add("I't");
        list.add("cat");

        System.out.println("First word: " + list.list.getWord());
        System.out.println("Distinct words: " + list.getDistinctWords());
        System.out.println("Total words: " + list.getTotalWords());
        System.out.println("Key Comparisions: " + list.getKeyCompare());
        System.out.println("reference Changes: " + list.getRefChanges());
    }
}
