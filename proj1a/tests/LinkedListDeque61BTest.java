import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

     @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

    // Below, you'll write your own tests for LinkedListDeque61B.

    @Test
    public void testIsEmptyWithoutElement() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    public void testIsEmptyWithOneElement() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("one elements");

         assertThat(lld1.isEmpty()).isFalse();
    }

    @Test
    public void testIsEmptyWithTwoElements() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst(-1);
         lld1.addFirst(1);

         assertThat(lld1.isEmpty()).isFalse();
    }

    @Test
    public void testSizeZero() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         assertThat(lld1.size()).isEqualTo(0);
    }

    @Test
    public void testSizeWithSomeElements() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("Neko");
         lld1.addLast("Inu");
         lld1.addLast("Tatami");

         assertThat(lld1.size()).isEqualTo(3);
    }

    @Test
    public void testGetWithSomeElements() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("a");
         lld1.addLast("b");
         lld1.addLast("c");
         lld1.addLast("d");
         lld1.addLast("e");

         assertThat(lld1.get(2)).isEqualTo("c");
    }

    @Test
    public void testGetWithEmpty() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         assertThat(lld1.get(0)).isNull();
    }

    @Test
    public void testGetOutOfBounded() {
        Deque61B<Integer> lld1= new LinkedListDeque61B<>();

        lld1.addLast(100);

        assertThat(lld1.get(122)).isNull();
    }

    @Test
    public void testGetNegativeIndex() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         lld1.addLast(32);

         assertThat(lld1.get(-1)).isNull();
    }

    @Test
    public void testRecursiveWithSomeElements() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("a");
        lld1.addLast("b");
        lld1.addLast("c");
        lld1.addLast("d");
        lld1.addLast("e");

        assertThat(lld1.getRecursive(2)).isEqualTo("c");
    }

    @Test
    public void testRecursiveWithEmpty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.getRecursive(0)).isNull();
    }

    @Test
    public void testRecursiveOutOfBounded() {
        Deque61B<Integer> lld1= new LinkedListDeque61B<>();

        lld1.addLast(100);

        assertThat(lld1.getRecursive(122)).isNull();
    }

    @Test
    public void testRecursiveNegativeIndex() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(32);

        assertThat(lld1.getRecursive(-1)).isNull();
    }

    @Test
    public void testRemoveFirstWithNoElement() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         assertThat(lld1.removeFirst()).isNull();
    }

    @Test
    public void testRemoveLastWithNoElement() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.removeLast()).isNull();
    }

    @Test
    public void testRemoveFirstWithElements() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("a");
         lld1.addLast("b");
         lld1.addLast("c");
         lld1.addLast("d");
         lld1.addLast("e");

         assertThat(lld1.removeFirst()).isEqualTo("a");
         assertThat(lld1.toList()).containsExactly("b","c","d","e");
    }

    @Test
    public void testRemoveLastWithElements() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("a");
        lld1.addFirst("b");
        lld1.addFirst("c");
        lld1.addFirst("d");
        lld1.addFirst("e");

        assertThat(lld1.removeLast()).isEqualTo("a");
        assertThat(lld1.toList()).containsExactly("e","d","c","b");
    }

}