import java.util.ArrayList;

public class dataklynge {
    private ArrayList<rack> racks = new ArrayList<rack>();

    // check last element in list
    public void leggInnNode(node nodeObj){
        for(rack rackObj: racks){
            if(rackObj.noder.length < 12){
                rackObj.leggInnNode(nodeObj);
                return;
            }
        }
        rack nyRackObj = new rack();
        racks.add(nyRackObj);
        racks.get(racks.size()-1).leggInnNode(nodeObj);
    }

    public antProsessorer(){
        int antProsessorer = 0; 
        
        for(rack rackObj: racks){
            int rackAntProsessor = rackObj.antProsessorer();
            antProsessorer += rackAntProsessor;
        }
        return antProsessorer;
    }

    public noderMedNokMinner(int paakrevdMinne){
        int noderMedMinne = 0;

        for(rack rackObj: racks){
            int nodeObjMinne = rackObj.nokMinne(paakrevdMinne);
            noderMedMinne += nodeObjMinne;
        }
        return noderMedMinne;
    }

}

class hovedprogram{
    public static void main(String[] args) {
        dataklynge saga = new dataklynge();
        for (i=0; i<450; i++){
            node nyNode = new node();
            saga.leggInnNode(nyNode);

        }


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