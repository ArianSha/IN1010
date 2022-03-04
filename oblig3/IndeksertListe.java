public class IndeksertListe<T> extends Lenkeliste<T> {
    
    public IndeksertListe(){
        super();
    }
    
    public void leggTil (int pos, T x) {
        if(pos > stoerrelse() || pos < 0) throw new UgyldigListeindeks(pos);
        
        if (pos == 0){
            if (head == null){
                head = new Node(x);
                entries++;
                return;
            }
            Node prevHead = head;
            head = new Node(x);
            head.next = prevHead;
            entries++;
            return;
        }
        
        Node peker = head;
        // peker er node bak
        for (int i = 0; i<pos-1; i++){
            peker = peker.next;
        }
        Node cur = peker.next;
        
        peker.next = new Node(x);
        peker.next.next = cur;
        entries++;
    }

    public void sett (int pos, T x) {
        if(pos >= stoerrelse() || pos < 0) throw new UgyldigListeindeks(pos);
        
        Node peker = head;
        // peker er node bak
        for (int i = 0; i<pos-1; i++){
            peker = peker.next;
        }
        Node cur = peker.next;

        if(cur.next == null){
            peker.next = new Node(x);
            return; 
        }
        
        peker.next = new Node(x);
        peker.next.next = cur.next;
    }

    public T hent (int pos) {
        if(pos >= stoerrelse() || pos < 0) throw new UgyldigListeindeks(pos);
        
        Node peker = head;
        for (int i = 0; i<pos; i++){
            peker = peker.next;
        }
        return peker.data;
    }
    
    public T fjern (int pos) {
        if (stoerrelse() == 0) throw new UgyldigListeindeks(-1);
        if(pos >= stoerrelse() || pos < 0) throw new UgyldigListeindeks(pos);
        
        Node peker = head;
        // peker er node bak
        for(int i = 0; i<pos-1; i++){
            peker = peker.next;
        }
        Node fjernetElement = peker.next;
        
        if(fjernetElement.next == null){
            peker.next = null;
            entries--;
            return fjernetElement.data;
        }
        peker.next = fjernetElement.next;
        entries--;
        return fjernetElement.data;
    }
}
