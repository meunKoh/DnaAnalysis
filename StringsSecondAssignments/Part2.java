
/**
 * Write a description of Part2 here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-17)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int count = 0;
        int idx = stringb.indexOf(stringa);
        String restString = stringb;
        while(true){
            if(idx == -1){
                break;
            }
            count ++;
            restString = restString.substring(idx + stringa.length());
            idx = restString.indexOf(stringa);
        }        
        return count;
    }
    public void testHowMany(){
        String stringa = "a";
        String stringb = "do you have any plan?";
        System.out.println(howMany(stringa,stringb));
    }
}
