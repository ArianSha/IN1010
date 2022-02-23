public class Lenkeliste <T> implements Liste<T>{
    Node head;
    int entries;

    class Node{
        T data = null;
        Node next = null;
        
        Node(T data){
            this.data = data;
        }
    }

    public int stoerrelse() {return entries;}
    public T hent() {return head.data;}

    public T fjern() {
        if(entries == 0){throw new UgyldigListeindeks(0);}
        T slettetElement = head.data;
        Node peker = head;

        while(peker != null){
            peker = peker.next;
        }
        
        head = head.next;
        entries --;
        return slettetElement;
    }
    
    public String toString(){
        StringBuilder svarStreng = new StringBuilder(); 
        Node peker = head;
        
        for (int i = 0; i<entries; i++){
            svarStreng.append("Element " + (i+1) + ": " + peker.data + "\n");
            peker = peker.next;
        }

        return svarStreng.toString();
    }
// overrid
    public void leggTil(T x){
        if (head == null){
            head = new Node(x);
            entries++;
            return;
        }

        Node peker = head;
        while (peker.next != null){
            peker = peker.next;
        }

        peker.next = new Node(x);
        entries++;
        return;
    }
}

interface Liste <T> {
    int stoerrelse ();
    void leggTil (T x);
    T hent ();
    T fjern ();
}

