public class List1 extends BaseList {

    public List1() {
        super();
    }

    @Override
    public void add(String word) {
LLNode current = list;

while (current != null){
keyCompare++;
if(current.getWord().equals(word)){
current.incrementCount();
return;
}
else(){
current = current.getNext();
}



}
        
    }
}
}