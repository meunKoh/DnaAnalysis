
/**
 * Write a description of Part3 here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-13)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        boolean result = false;
        int firstIndex = stringb.indexOf(stringa);
        int lastIndex = stringb.lastIndexOf(stringa);
        if(firstIndex < lastIndex){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
    public void testing(){
        String string1 = "a";
        String string2 = "banana";
        String string3 = "I love you";
        
        System.out.println("String1 and String2 test : " + twoOccurrences(string1,string2));
        System.out.println("String1 and String3 test : " + twoOccurrences(string1,string3));
        System.out.println("String2 and String3 test : " + twoOccurrences(string2,string3));
        
        System.out.println("The part of the string after " + string1 + " in " + string2 + " is " + lastPart(string1,string2));       
        System.out.println("The part of the string after " + string1 + " in " + string3 + " is " + lastPart(string1,string3));       
        System.out.println("The part of the string after " + string2 + " in " + string3 + " is " + lastPart(string2,string3));
    }
    public String lastPart(String stringa, String stringb){
        boolean isContain = twoOccurrences(stringa, stringb);
        String result = "";
        if(isContain = true){
            int indexOfStringa = stringb.indexOf(stringa);
            int lengthOfStringa = stringa.length();
            int substringLength = 2;
            result = stringb.substring(indexOfStringa,indexOfStringa + lengthOfStringa + substringLength);
        }else{
            result = stringb;
        }
        return result;
    }
}
