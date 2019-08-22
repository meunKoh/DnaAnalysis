import java.lang.Math;
/**
 * Write a description of Part1 here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-17)
 */
public class Part1 {   
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        startIndex = dna.indexOf("ATG",startIndex);
        int result = dna.length();
        int stopIndex = dna.indexOf(stopCodon,startIndex+1);
        if(stopIndex != -1){
            int lengthBetween = stopIndex - startIndex;
            if(lengthBetween %3 == 0){
                result = stopIndex;
            }
        }
        return result;
    }
    public String findGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex!=-1){
            int taaIndex = findStopCodon(dna,startIndex,"TAA");
            int tagIndex = findStopCodon(dna,startIndex,"TAG");
            int tgaIndex = findStopCodon(dna,startIndex,"TGA");
            int minIdx1 = Math.min(taaIndex,tagIndex);
            int minIdx2 = Math.min(minIdx1,tgaIndex);
            if(minIdx2 != dna.length()){
                int firstStopIdx = minIdx2;
                result = dna.substring(startIndex,firstStopIdx+3);
            }
        }
        return result;
    }
    public void testFindStopCodon(){
        int test1 = findStopCodon("ATGGGGCCCTAA",0,"TAA");
        int test2 = findStopCodon("ATGGGGCCCTAA",1,"TAA");
        System.out.println("test1 : " + test1);
        System.out.println("test2 : " + test2);
    }
    public void testFindGene(){
        String dna1 = "GGGGGGGGGTAA";
        String dna2 = "GGATGCCCTAAGG";
        String dna3 = "GATGCCCTAATAGGGTGA";
        String dna4 = "GAATGCC";
        String dna5 = "AATGCTAACTAGCTGACTAAT";
        System.out.println("dna1 : " + findGene(dna1));
        System.out.println("dna2 : " + findGene(dna2));
        System.out.println("dna3 : " + findGene(dna3));
        System.out.println("dna4 : " + findGene(dna4)); 
        System.out.println("dna5 : " + findGene(dna5));
    }
    public void printAllGenes(String dna){
        String restDna = dna;
        while(true){
            String gene = findGene(restDna);
            if(gene == ""){
                break;
            }
            int index = restDna.indexOf(gene);
            restDna = restDna.substring(index + gene.length());
            System.out.println(gene);
        }
    }
}
