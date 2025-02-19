import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> map= new HashMap<>();
        char c= 'a';
        for (int i=1; i<=26; i++) {
            map.put(c, i);
            c++;
        }
        return map;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, i*i);
        }
        return map;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String i : words) {
            if (map.containsKey(i) == false) {
                map.put(i, 1);
            }else if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
        }
        return map;
    }
}
