
/**
 * Write a description of Part1 here.
 * 
 * @autor (MyoungEun Koh) 
 * @version (13/07/2019)
 */
public class Part1 {
   public String findSimpleGene(String dna){
       String result = "";
       int startIndex = -1;
       int stopIndex = -1;
       startIndex = dna.indexOf("ATG");     
       //Find the start codon "ATG"
       if(startIndex != -1){
           //Find the stop codon "TAA"
           stopIndex = dna.indexOf("TAA",startIndex+3);
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
   public void testSimpleGene(){
           String dna1 = "AGCGCGCGCGCGC";
           String dna2 = "ATGCGCGCGCGCGCG";
           String dna3 = "ATGCGCCGCTAA";
           String dna4 = "ATGAGAGAGAGTAA";
           String dna5 = "CCCCATGCACACADSSTAADDD";
           
           
	   System.out.println("dna1 is " + findSimpleGene(dna1));
	   System.out.println("dna2 is " + findSimpleGene(dna2));
	   System.out.println("dna3 is " + findSimpleGene(dna3));
	   System.out.println("dna4 is " + findSimpleGene(dna4));
	   System.out.println("dna5 is " + findSimpleGene(dna5));
    
           }           
       }
    
