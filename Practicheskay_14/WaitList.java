package Practicheskay_14;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class WaitList<E> implements IWaitList<E> {
    protected Queue<E> content;

    public WaitList() {
        content = new LinkedList<>();
    }

    public WaitList(Collection<E> elements) {
        content = new LinkedList<>(elements);
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.poll();
    }

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> elements) {
        return content.containsAll(elements);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
