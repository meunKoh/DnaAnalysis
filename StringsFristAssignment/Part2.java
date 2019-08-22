
/**
 * Write a description of Part2 here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-13)
 */
public class Part2 {
    public static String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result = "";
        int startIndex = -1;
        int stopIndex = -1;
        startIndex = dna.indexOf(startCodon);     
        //Find the start codon "ATG"
        if(startIndex != -1){
            //Find the stop codon "TAA"
            stopIndex = dna.indexOf(stopCodon,startIndex+3);
            if(stopIndex != -1){               
                 //If the length of the substring is a multiple of 3, return the substring
                 int lengthBetween = stopIndex - startIndex;
                 if(lengthBetween %3 == 0){
                        result = dna.substring(startIndex, stopIndex + 3);
                 }
            }
        }
        return result;
    }
    public void testSimpleGene() {
        String dna1 = "AGCGCGCGCGCGC";
        String dna2 = "ATGCGCGCGCGCGCG";
        String dna3 = "ATGTAA";
        String dna4 = "ATGAGAGAGAGTAA";
        String dna5 = "CCCCATGCACACADSSTAADDD";
            
        System.out.println("dna1 is " + findSimpleGene(dna1,"ATG","TAA"));
        System.out.println("dna2 is " + findSimpleGene(dna2,"ATG","TAA"));
        System.out.println("dna3 is " + findSimpleGene(dna3,"ATG","TAA"));
        System.out.println("dna4 is " + findSimpleGene(dna4,"ATG","TAA"));
        System.out.println("dna5 is " + findSimpleGene(dna5,"ATG","TAA"));
    }
}
