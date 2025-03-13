import java.util.ArrayList;
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
        sentinel = new Node(null, null, null);
        sentinel.first = sentinel;
        sentinel.rest = sentinel;
        //sentinel = new Node(sentinel, null, sentinel);
    }


    @Override
    public void addFirst(T x) {
        sentinel.rest = new Node(sentinel, x, sentinel.rest);
        sentinel.rest.rest.first = sentinel.rest;
        //if (sentinel.rest == sentinel) {
            //sentinel.rest = new Node(sentinel, x, sentinel.rest);
            //sentinel.rest.rest = sentinel;
        //    sentinel.first = sentinel.rest;
        //}
        //else {
        //   sentinel.rest = new Node(sentinel, x, sentinel.rest);
        //}
//        if (sentinel.rest == null) {
//            sentinel.rest = new Node(sentinel, x, sentinel);
//        } else {
//            sentinel.rest = new Node(sentinel, x, sentinel.rest);
//        }
    }

    @Override
    public void addLast(T x) {
        sentinel.first.rest = new Node(sentinel.first, x, sentinel);
        sentinel.first = sentinel.first.rest;
        //sentinel.first = new Node(sentinel.first, x, sentinel);

        //if (sentinel.first == sentinel) {
            //sentinel.first = new Node(sentinel.first, x, sentinel);
            //sentinel.first.first = sentinel;
        //    sentinel.rest = sentinel.first;
        //}
        //else {
        //    sentinel.first = new Node(sentinel.first, x, sentinel);
        //}
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel.rest;
        if (p == null) {return returnList;}
        while (p != sentinel) {
            returnList.add(p.item);
            p = p.rest;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return true;
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
