import sun.security.util.Length;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {


    // google.com/getemp/1/? emp=1
    public static void main(String[] args) {
        String text=" This is text, issss, tasasf";

         OptionalInt len = Arrays.stream(text.split(" "))
                .filter((x) -> x.startsWith("t")).mapToInt(String::length).max();

        System.out.println(len.getAsInt());

    }
    public static void main1(String[] args) {
        String text = "alabama library";

        //
        LinkedHashMap<Character, Integer> charToOccr = new LinkedHashMap();

        char curr;
        Integer currOccr;
        for (int start = 0; start < text.length(); start++) {
            curr = text.charAt(start);
            currOccr = charToOccr.get(curr);
            if (currOccr == null) {
                charToOccr.put(curr, 1);
            } else {
                charToOccr.put(curr, ++currOccr);
            }
        }

        char nonRptChar =' ';
        for (Map.Entry<Character, Integer> keyVal : charToOccr.entrySet()) {
            if (keyVal.getValue() == 1) {
                nonRptChar = keyVal.getKey();
                break;
            }
        }
        System.out.println(nonRptChar);
    }

}
