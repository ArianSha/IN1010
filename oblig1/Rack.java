
public class Rack{
    Node[] noder = new Node[12];
    private int nodeIRack = 0;

    public void leggInnNode(Node nodeObj){
        
        for(int i = 0; i < noder.length; i++) {
            if(noder[i] == null) {
                noder[i] = nodeObj;
                nodeIRack++;
                return;
            }
        }
    }

    public int antProsessorer(){
        int antProsessorer = 0;
        
        for (Node nodeObj: noder){
            if (nodeObj != null){
                int nodeAntProsessor = nodeObj.antProsessorer();
                antProsessorer += nodeAntProsessor;
            }
        }
        return antProsessorer;
     }

    public int noderMedNokMinne(int paakrevdMinne){
        int noderMedMinne = 0;

        for(Node nodeObj: noder){
            if (nodeObj != null){
                int nodeMinne = nodeObj.antMinne();
                if (paakrevdMinne <= nodeMinne){
                    noderMedMinne++;
                }
            }
        }
        return noderMedMinne;
    }

    public boolean rackErFull(){
        if (nodeIRack == 12){
            return true;
        }else{
            return false;
        }
    }
}   