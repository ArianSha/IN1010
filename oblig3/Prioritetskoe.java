public class Prioritetskoe<T extends Comparable <T>> extends Lenkeliste<T>{
    public Prioritetskoe(){
        super();
    }

    @Override
    public void leggTil(T x){

        if (head == null){
            head = new Node(x);
            entries++;
            return;
        }

        if (x.compareTo(head.data) < 0){
            Node prevHead = head;
            head = new Node (x);
            head.next = prevHead;
            entries++;
            return;
        }

        // liste har minst 2 elementer, bruker next node for sammenligne
        Node peker = head;
        for(int i = 0; i<stoerrelse()-1; i++){
            if (x.compareTo(peker.next.data) < 0){
                Node nodeEtter = peker.next;
                peker.next = new Node(x);
                peker.next.next = nodeEtter;
                entries++;
                return; 
            }
            peker = peker.next;
        }
        peker.next = new Node(x);
        entries++;
    }
}