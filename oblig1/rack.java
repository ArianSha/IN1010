public class rack{
    node[] noder = new node[12];

    public void leggInnNode(node nodeObj){
        for(int i = 0; i < noder.length; i++) {
            if(noder[i] == null) {
                noder[i] = nodeObj;
                return;
            }
        }
    }
    public antProsessorer(){
        int antProsessorer = 0;
        
        for (node nodeObj: noder){
            int nodeAntProsessor = odeObj.antProsessorer();
            antProsessorer += nodeAntProsessor;
        }
        return antProsessorer;
    }
    public nokMinne(int paakrevdMinne){
        node noderMedMinne = 0;
        
        for(node nodeObj: noder){
            int nodeMinne = nodeObj.antMinne();
            if (paakrevdMinne <= nodeMinne){
                noderMedMinne++;
            }
        }
        return noderMedMinne;
    }

}   