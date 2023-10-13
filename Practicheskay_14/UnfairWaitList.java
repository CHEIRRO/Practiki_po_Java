package Practicheskay_14;

import java.util.LinkedList;

public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {
        content = new LinkedList<>();
    }

    public void moveToBack(E element) {
        if (content.remove(element)) {
            content.add(element);
        }
    }
}
