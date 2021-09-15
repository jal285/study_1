package JavaThinking;

public class LabeledFor  {
    public static void main(String[] args) {
        int i =0;
        outer:for(;true;){ //outer 为标签 也可用其他词语
            //infinte loop
            inner:
            for(;i<10;i++){
                prt("i="+i);
                if(i == 2){
                    prt("continue");
                    continue;
                }
                if(i == 3){
                    prt("break");
                    i++; // Otherwise i never gets incremeted
                    break;
                }
                if(i == 7){
                    prt("continue outer");
                    i++; //Otherwise i never gets incremeted
                    continue outer;
                }
                if(i == 8){
                    prt("break outer");
                    break outer;
                }
                for(int k = 0;k<5;k++){
                    prt("continue inner");
                    continue  inner;
                }
            }
        }
    }

    private static void prt(String aContinue) {
        System.out.println(aContinue);
    }

}
