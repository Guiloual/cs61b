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
    public int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.first = sentinel;
        sentinel.rest = sentinel;
        q = sentinel;
        size = 0;
        //sentinel = new Node(sentinel, null, sentinel);
    }


    @Override
    public void addFirst(T x) {
        sentinel.rest = new Node(sentinel, x, sentinel.rest);
        sentinel.rest.rest.first = sentinel.rest;
        size += 1;
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
        size += 1;
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
        if (sentinel.rest == sentinel) {return true;}
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {return null;}

        T a = sentinel.rest.item;
        sentinel.rest.rest.first = sentinel;
        sentinel.rest = sentinel.rest.rest;
        return a;
    }

    @Override
    public T removeLast() {
        if (sentinel.rest == sentinel) {return null;}

        T a = sentinel.first.item;
        sentinel.first.first.rest = sentinel;
        sentinel.first = sentinel.first.first;
        return a;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size && size > 0) {
            Node p = sentinel.rest;
            for (int i = 0; i < index; i++) {
                p = p.rest;
            }
            return p.item;

        } else {return null;}
    }

    private Node q;
    @Override
    public T getRecursive(int index) {

        if (index == 0) {
            return q.rest.item;
        } else if (index < 0 || index > size || size == 0) {
            return null;
        }
        q = q.rest;
        return getRecursive(index -1);
    }
}
