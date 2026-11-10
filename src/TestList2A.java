public class TestList2A {
    public static void main(String [] args){

List2A list = new List2A();

list.add("cat");
list.add("dog");
list.add("cat");
list.add("qwerty");
list.add("Squivvle");
list.add("I't");





System.out.println("Distinct words: " + list.getDistinctWords());
System.out.println("Total words: " + list.getTotalWords());
System.out.println("Key Comparisions: " + list.getKeyCompare());
System.out.println("reference Changes: " + list.getRefChanges());

}



}

