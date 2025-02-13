package exam;

public class Main {

    public static void main(String[] args) {
        IntegerMultiSet multiset = new IntegerMultiSet(5);
        System.out.println(multiset.toString()); // [Empty multiset]

        multiset.insert(10);
        multiset.insert(20);
        multiset.insert(10);
        multiset.insert(30);
        System.out.println(multiset.toString()); // [30  10  20  10]

        System.out.println(multiset.search(20)); // true
        System.out.println(multiset.search(40)); // false

        multiset.delete(10);
        System.out.println(multiset.toString()); // [30  20  10]

        System.out.println(multiset.size()); // 3

        multiset.empty();
        System.out.println(multiset.toString()); // [Empty multiset]
    }
}
