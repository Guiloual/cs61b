import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int s = 0;
        for (Integer i : L) {
            s = s + i;
        }
        return s;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> even = new ArrayList<>();
        for (Integer i : L) {
            if (i % 2 == 0){
                even.add(i);
            }
        }
        return even;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commom = new ArrayList<>();
        for (Integer i : L1) {
            for (Integer j : L2) {
                if (L1.get(i) == L2.get(j)) {
                    commom.add(L1.get(i));
                }
            }
        }
        return commom;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int counnt = 0;
        for (String i : words) {
            if (i == Character.toString(c)) {
                counnt++;
            }
        }
        return counnt;
    }
}
