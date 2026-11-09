public class TestList1{
public static void main(String [] args){
List1 list = new List1();

list.add("cat");
list.add("dog");
list.add("cat");




System.out.println("Distinct words: " + list.getDistinctWords());
System.out.println("Total words: " + list.getTotalWords());
System.out.println("Key Comparisions: " + list.getKeyCompare());
System.out.println("reference Changes: " + list.getRefChanges());

}



}