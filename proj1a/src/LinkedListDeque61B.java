import java.util.List;

public class LinkedListDeque61B <T> implements Deque61B<T>{

    private class Node {

        public Node first;
        public T item;
        public Node rest;

        public Node(Node f, T i, Node r) {
            first = f;
            item = i;
            rest = r;
        }
    }

    public Node sentinel;

    public LinkedListDeque61B() {
        sentinel = new Node(sentinel, null, sentinel);
    }


    @Override
    public void addFirst(T x) {

    }

    @Override
    public void addLast(T x) {

    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
