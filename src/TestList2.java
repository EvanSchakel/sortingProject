public class TestList2{
public static void main(String [] args){

List2 list = new List2();

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