package Practicheskay_14;


public class Main {
    public static void main(String[] args) {
        IWaitList<Integer> waitList = new BoundedWaitList<>(5);
        waitList.add(1);
        waitList.add(2);
        waitList.add(3);

        // Эти элементы не будут добавлены из-за ограничения в 5
        waitList.add(4);
        waitList.add(5);
        waitList.add(6);

        System.out.println(waitList.remove()); // Выведет "1"

        IWaitList<String> unfairWaitList = new UnfairWaitList<>();
        unfairWaitList.add("A");
        unfairWaitList.add("B");
        unfairWaitList.add("C");

        ((UnfairWaitList<String>) unfairWaitList).moveToBack("A"); // Переместит "A" в конец
        System.out.println(unfairWaitList.remove()); // Выведет "B"
    }
}
