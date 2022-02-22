public class Lenkeliste <T> implements Liste<T>{
    Node head;
    int entries;

    class Node{
        T data = null;
        Node next = null;
        int indeks = 0;
        
        Node(T data){
            this.data = data;
            indeks = entries + 1;
        }
    }

    public int stoerrelse() {return entries;}
    public T hent() {return head.data;}

    public T fjern() {
        T slettetElement = head.data;
        Node peker = head;

        while(peker != null){
            peker.indeks --;
            peker = peker.next;
        }
        
        head = head.next;
        entries --;
        return slettetElement;
    }
    
    public String toString(){
        StringBuilder svarStreng = new StringBuilder(); 
        Node peker = head;
        
        while (peker != null){
            svarStreng.append("Element " + peker.indeks + ": " + peker.data + "\n");
            peker = peker.next;
        }
        return svarStreng.toString();
    }

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

class Kjor{
    public static void main(String[] args) {
        Lenkeliste<String> liste1 = new Lenkeliste<>();

        liste1.leggTil("hei");
        liste1.leggTil("hei du");
        liste1.leggTil("hei verden");

        System.out.println(liste1.toString());
        System.err.println(liste1.stoerrelse());
        System.out.println(liste1.fjern());
        System.err.println(liste1.stoerrelse());
        System.out.println(liste1.toString());
    }
}
