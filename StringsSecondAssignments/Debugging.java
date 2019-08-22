
/**
 * Write a description of Debugging here.
 * 
 * @author (MyoungEun Koh) 
 * @version (2019-07-17)
 */
public class Debugging {
public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || (index+4) > input.length()) {
            break;
        }
        System.out.println("index " + index);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+3);
        System.out.println("index after updating " + index);
    }
}
public void test() {
    System.out.println("hey");
    findAbc("abcabcabcabca");
}
}
