public class Stabel<T> extends Lenkeliste<T>{
    public Stabel(){
        super();
    }

    @Override
    public void leggTil(T x){
        if (head == null){
            head = new Node(x);
            entries++;
            return;
        }
        Node prevHead = head;
        head = new Node(x);
        head.next = prevHead;
        entries++;
    }
}