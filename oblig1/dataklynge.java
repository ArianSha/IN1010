import java.util.ArrayList;

public class dataklynge {
    private ArrayList<rack> racks = new ArrayList<rack>();

    public void leggInnNode(node nodeObj){
        for(rack rackObj: racks){
            if(rackObj.rackErFull() == false){
                rackObj.leggInnNode(nodeObj);
                return;
            }
        }
        rack nyRackObj = new rack();
        racks.add(nyRackObj);
        racks.get(racks.size()-1).leggInnNode(nodeObj);
    }   

    public int antProsessorer(){
        int antProsessorer = 0; 
        
        for(rack rackObj: racks){
            int rackAntProsessor = rackObj.antProsessorer();
            antProsessorer += rackAntProsessor;
        }
        return antProsessorer;
    }

    public int noderMedNokMinner(int paakrevdMinne){
        int noderMedMinne = 0;

        for(rack rackObj: racks){
            if(rackObj != null){
                int nodeObjMinne = rackObj.nokMinne(paakrevdMinne);
                noderMedMinne += nodeObjMinne;
            }
        }
        return noderMedMinne;
    }

    public int antallRacks(){
        return racks.size();
    }
}




// for(int racksIndex = 0; i < racks.size(); i++){
//     if (racks.get(racksIndex).noder.length == 12){
//         racks.get(racksIndex).leggInnNode(nodeObj);
//     }
//     else{
//         rack nyRackObj = new rack();
//         racks.add(nyRackObj);
//         racks.get(racks.size()-1).leggInnNode(nodeObj);

//     }

// }