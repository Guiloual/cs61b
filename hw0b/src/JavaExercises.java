import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        int[] arr = new int[6];
        for (int i=0; i<6; i++) {
            arr[i] = i+1;
        }
        return arr;
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        if (customer == "Ergun") {
            String[] arr1 = {"beyti", "pizza", "hamburger", "tea"};
            return arr1;
        }else if (customer == "Erik") {
            String[] arr2 = {"sushi", "pasta", "avocado", "coffee"};
            return arr2;
        }else {
            String[] arr3 = new String[3];
            return arr3;
        }
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int M = array[0];
        int m = array[0];
        for (int i=0; i < array.length; i++ ) {
            if ( array[i] > M) {
                M = array[i];
            }
            if (array[i] < m) {
                m = array[i];
            }
        }
        return M-m;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        list.add(x);
        if (x == 1) {
            return list;
        }
        if (x % 2 ==0) {
            return hailstoneHelper(x/2, list);
        } else if (x % 2 == 1) {
            return hailstoneHelper(x*3+1, list);
        }
        return null;
    }

}
