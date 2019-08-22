import java.util.HashMap;
import edu.duke.*;
/**
 * Write a description of CodonCountMap here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-22)
 */
public class CodonCountMap {
    private static HashMap<String, Integer> codonCount
             = new HashMap<String, Integer>();
    
    public CodonCountMap(){
        HashMap<String, Integer> codonCount = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        //build a new map of codons mapped to their counts from the string dna 
        //with the reading frame with the position start (a value of 0, 1, or 2).
        for(int i=start;i+3<=dna.length();i=i+3){
            String currDna = dna.substring(i,i+3);
            if(codonCount.containsKey(currDna)){
                int currCount = codonCount.get(currDna);
                codonCount.replace(currDna,currCount+1);
            }else{
                codonCount.put(currDna,1);
            }
        }
    }
    
    public String getMostCommonCodon(){
        //returns the codon in a reading frame that has the largest count. 
        //If there are several such codons, return any one of them.
        int maxCount = 0;
        String commonCodon = "";
        for(String codon : codonCount.keySet()){
            int currCount = codonCount.get(codon);
            if(currCount > maxCount){
                maxCount = currCount;
                commonCodon = codon;
            }
        }
        return commonCodon;
    }
    
    public void printCodonCounts(int start, int end){
        //prints all the codons in the HashMap along with their counts 
        //if their count is between start and end, inclusive.
        for(String codon : codonCount.keySet()){
            int currCount = codonCount.get(codon);
            if(currCount>=start && currCount<=end){
                System.out.println(codon + "\t" + currCount);
            }
        }
    }
    public void quiz(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.trim();
        dna = dna.toUpperCase();
        //quiz2
        //buildCodonMap(2,dna);
        //System.out.println(codonCount.size());
        //System.out.println("the most common codon is for frame 2 is " + getMostCommonCodon());
        //System.out.println("count is " + codonCount.get(getMostCommonCodon()));
        //quiz3
        //buildCodonMap(1,dna);
        //printCodonCounts(4,6);
        //System.out.println("reading frame 1" + codonCount.size());
        buildCodonMap(0,dna);
        System.out.println(codonCount.size());
        printCodonCounts(6,8);
    }
    public void test(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.trim();
        dna = dna.toUpperCase();
        for(int i=0;i<3;i++){
            buildCodonMap(i,dna);
            System.out.println("Reading frame starting with " + i + " results in " + codonCount.size() +" unique codons");
            String maxCodon = getMostCommonCodon();
            System.out.println("the most common codon is " + maxCodon + " with count ");
            
            int start = 1;
            int end = 5;
            //System.out.println("Counts of codons between " + start + " and " + end + " inclusive are: ");
            //printCodonCounts(start,end);
        }
    }
}
