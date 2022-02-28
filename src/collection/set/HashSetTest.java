package collection.set;

import java.util.HashSet;

@SuppressWarnings({"all"})
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        for(int i=1;i<16;i++){
            hashSet.add(new A(i));
        }
    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "A{" +
                "n=" + n +
                '}';
    }
}
