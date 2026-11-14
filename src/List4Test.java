public class List4Test {
    public static void main(String[] args) {
        List4 list = new List4();

        list.add("cat");
        list.add("dog");
        list.add("qwerty");
        list.add("cat");
        list.add("cat");

        System.out.println("First word: " + list.list.getWord());
        System.out.println("Second word: " + list.list.getNext().getWord());
        System.out.println("Distinct words: " + list.getDistinctWords());
        System.out.println("Total words: " + list.getTotalWords());
        System.out.println("Key Comparisions: " + list.getKeyCompare());
        System.out.println("reference Changes: " + list.getRefChanges());
    }
}
