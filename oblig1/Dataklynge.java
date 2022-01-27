import java.util.ArrayList;

public class Dataklynge {
    private ArrayList<Rack> racks = new ArrayList<Rack>();

    public void leggInnNode(Node nodeObj){
        for(Rack rackObj: racks){
            if(rackObj.rackErFull() == false){
                rackObj.leggInnNode(nodeObj);
                return;
            }
        }
        Rack nyRackObj = new Rack();
        racks.add(nyRackObj);
        racks.get(racks.size()-1).leggInnNode(nodeObj);
    }   

    public int antProsessorer(){
        int antProsessorer = 0; 
        
        for(Rack rackObj: racks){
            int rackAntProsessor = rackObj.antProsessorer();
            antProsessorer += rackAntProsessor;
        }
        return antProsessorer;
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int noderMedMinne = 0;

        for(Rack rackObj: racks){
            int nodeObjMinne = rackObj.noderMedNokMinne(paakrevdMinne);
            noderMedMinne += nodeObjMinne;
        }
        return noderMedMinne;
    }

    public int antallRacks(){
        return racks.size();
    }
}
