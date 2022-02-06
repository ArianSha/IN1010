import java.util.ArrayList;

public class Dataklynge {
    private ArrayList<Dataklynge.Rack> racks = new ArrayList<Dataklynge.Rack>();

    public void leggInnNode(Node nodeObj){
        for(Dataklynge.Rack rackObj: racks){
            if(rackObj.rackErFull() == false){
                rackObj.leggInnNode(nodeObj);
                return;
            }
        }
        Dataklynge.Rack nyRackObj = new Rack();
        racks.add(nyRackObj);
        racks.get(racks.size()-1).leggInnNode(nodeObj);
    }   

    public int antProsessorer(){
        int antProsessorer = 0; 
        
        for(Dataklynge.Rack rackObj: racks){
            int rackAntProsessor = rackObj.antProsessorer();
            antProsessorer += rackAntProsessor;
        }
        return antProsessorer;
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int noderMedMinne = 0;

        for(Dataklynge.Rack rackObj: racks){
            int nodeObjMinne = rackObj.noderMedNokMinne(paakrevdMinne);
            noderMedMinne += nodeObjMinne;
        }
        return noderMedMinne;
    }

    public int antallRacks(){
        return racks.size();
    }

    private class Rack{
        private Node[] noder = new Node[12];
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
}
