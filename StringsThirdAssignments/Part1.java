import java.lang.Math;
import edu.duke.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-17)
 */
public class Part1 { 
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        //Let's assume that startIndex is the index of 'ATG'
        int result = dna.length();
        int stopIndex = dna.indexOf(stopCodon,startIndex);
        while(true){
            if(stopIndex == -1){
                break;
            }
            int length = stopIndex - startIndex;
            if(length %3 == 0){
                return stopIndex;
            }else{
                int nextSearchIdx = stopIndex + 1;
                stopIndex = dna.indexOf(stopCodon,nextSearchIdx);
            }
        }
        return result;
    }
    public String findGene(String dna, int startIndex){
        //This method returns the first gene of the input dna in the String type.
        String result = "NONE";
        int firstAtg = dna.indexOf("ATG",startIndex);
        if(firstAtg != -1){
            int taaIndex = findStopCodon(dna,firstAtg,"TAA");
            int tagIndex = findStopCodon(dna,firstAtg,"TAG");
            int tgaIndex = findStopCodon(dna,firstAtg,"TGA");
            int minIdx1 = Math.min(taaIndex,tagIndex);
            int minIdx2 = Math.min(minIdx1,tgaIndex);
            if((minIdx2+3) <= (dna.length()-1)){
                int firstStopIdx = minIdx2;
                result = dna.substring(firstAtg,firstStopIdx+3);
            }else if((minIdx2+2) == (dna.length()-1)){
                //if the dna ends with the last stopCodon :
                result = dna.substring(firstAtg);
            }
        }
        return result;
    }
    public StorageResource getAllGenes(String dna){
        //Instead of printing the genes found, this method should create and return a StorageResource containing the genes found.
        StorageResource geneList = new StorageResource();
        dna = dna.toUpperCase();
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.equals("NONE")){
                break;
            }
            geneList.add(currGene);
            int newStartIndex = dna.indexOf(currGene, startIndex) + currGene.length();            
            startIndex = newStartIndex;
        }
        return geneList;
    }
    public void testGetAllGenes(String dna){
        StorageResource geneList = getAllGenes(dna.toUpperCase());
        for(String gene : geneList.data()){
            System.out.println(gene);
        }
    }
    public double cgRatio(String dna){
        double ratio = 0.0;
        int count = 0;
        int countAllGenes = 0;
        StorageResource geneList = getAllGenes(dna);
        for(String gene : geneList.data()){
            for(int i=0;i<gene.length();i++){
                if(gene.charAt(i) == 'C' || gene.charAt(i) == 'G'){
                    count++;
                }
            }
            countAllGenes += gene.length();
        }
        ratio = ((double)count)/countAllGenes;
        return ratio;
    }
    public int countCTG(String dna){
        int count = 0;
        StorageResource geneList = getAllGenes(dna);
        for(String gene :  geneList.data()){
            for(int i=0;i<gene.length();i++){
                if(gene.charAt(i) == 'C' || gene.charAt(i) == 'G' || gene.charAt(i) == 'T'){
                    count++;
                }
            }
        }
        return count;
    }
    public void processGenes(StorageResource sr){        
        //print all the Strings in sr that are longer than 9 characters
        //print the number of Strings in sr that are longer than 9 characters
        StorageResource lt9 = new StorageResource();
        for(String s : sr.data()){
            if(s.length()>60){
                lt9.add(s);
            }
        }
        System.out.println("Strings in sr that are longer than 60 characters : (total = " + lt9.size() + ")");
        //print the Strings in sr whose C-G-ratio is higher than 0.35
        //print the number of strings in sr whose C-G-ratio is higher than 0.35
        StorageResource cg35 = new StorageResource();
        for(String s : sr.data()){
            if(cgRatio(s)>0.35){
                cg35.add(s);
            }
        }
        System.out.println("Strings in sr whose C-G-ratio is higher than 0.35 : (total = " + cg35.size() + ")");
        //print the length of the longest gene in sr
        int longest = 0;
        for(String s : sr.data()){
            if(s.length()>=longest){
                longest = s.length();
            }
        }
        System.out.println("The length of the longest gene in sr is : " + longest);
    }
    public void testProcessGenes(){
        //FileResource fr = new FileResource("brca1line.fa");
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        String newDna = dna.toUpperCase();
        StorageResource sr = getAllGenes(newDna);
        System.out.println("# of genes : " + sr.size());
        System.out.println("codon CTG appears " + countCTG(newDna) + " times.");
        processGenes(sr);
    }
}
