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

        Node peker = head;

        while(peker.next != null){
            if (x.compareTo(peker.next.data) >= 0){
                Node cur = peker.next;
                peker.next = new Node(x);
                peker.next = cur;
                entries++;
                return; 
            }
            peker = peker.next;
        }
        peker.next = new Node(x);
        entries++;
    }

    @Override
    public T fjern(){
        if(entries == 0){throw new UgyldigListeindeks(0);}
        T retur = head.data;

        if (head.next != null){
            head = head.next;
            entries--;
            return retur;
        }
        head = null;
        entries--;
        return retur;
    }
}