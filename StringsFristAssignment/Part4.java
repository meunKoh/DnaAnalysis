import edu.duke.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-14)
 */
public class Part4 {
    
    URLResource file = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");    
    
    for (String item : file.words()){
        String itemLower = item.toLowerCase();
        int pos = itemLower.indexOf("youtube.com");
        if(pos != -1){
            int beg = itemLower.lastIndexOf("\"",pos);
            int end = itemLower.indexOf("\"",pos+1);
        }
    }
    
}
