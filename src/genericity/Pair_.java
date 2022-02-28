package genericity;

/*
    自定义一个泛型类Pair  可以先全部定义为String，最后替换为T，并且在类名后面声明T
 */
public class Pair_ {
    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<String>("a","b");
        System.out.println(stringPair);
        Pair<Integer> integerPair = new Pair<Integer>(1,2);
        System.out.println(integerPair);
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
