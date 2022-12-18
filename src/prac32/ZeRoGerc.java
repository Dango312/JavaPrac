package prac32;

public class ZeRoGerc {
    int[] p,d;
    public ZeRoGerc(int n){
        this.p = new int[n];
        for(int i = 0; i < n; i++){
            this.p[i] = i+1;
        }
        this.d = new int[p.length];
        generateArrows();
    }
    private void generateArrows(){
        // 1: -> -1: <-
        for(int i = 0; i < p.length; i++){
            this.d[i] = -1;
        }
    }
    private int findMaxMobile(){
        int max = 0;
        int maxid = -1;
        for(int i = 0; i < this.p.length; i++){
            if(i == this.p.length-1 && d[i] == 1){
                return maxid;
            }
            if(d[i] == 1 && p[i]>p[i+1] && p[i] > max){
                max = p[i];
                maxid = i;
            } else if (i != 0) {
                if (d[i] == -1 && p[i] > p[i-1] && p[i] > max ) {
                    max = p[i];
                    maxid = i;
                }
            }

        }
        return maxid;
    }
    private void switchArrows(int el){
        for(int i = 0; i < p.length; i++){
            if(el<p[i]){
                d[i] = -d[i];
            }
        }
    }
    private void printRelocation(){
        for(int i = 0; i < p.length; i++){
            if(d[i] == 1){
                System.out.print("-> ");
            } else {
                System.out.print("<- ");
            }
        }
        System.out.println("");
        for(int i = 0; i < p.length; i++){
            System.out.print(p[i] + " ");
        }
        System.out.println("");
    }
    private void switchElements(int maxMobileId, int switchOperator){
        int container  = p[maxMobileId];
        p[maxMobileId] = p[maxMobileId+switchOperator];
        p[maxMobileId+switchOperator] = container;
        int containerd  = d[maxMobileId];
        d[maxMobileId] = d[maxMobileId+switchOperator];
        d[maxMobileId+switchOperator] = containerd;
    }
    public void stepAlgorithm(){
        int n = p.length;
        int maxMobileId = 0;
        int counter = 0;
        while(maxMobileId != -1){

            printRelocation();
            counter++;
            maxMobileId = findMaxMobile();
            if(maxMobileId == -1){
                break;
            }
            int max = p[maxMobileId];
            switchElements(maxMobileId, d[maxMobileId]);
            switchArrows(max);

        }
        System.out.println(counter);

    }
}
