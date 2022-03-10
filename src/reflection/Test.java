package reflection;

import java.io.Serializable;

public class Test {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Class<Serializable> serializableClass = Serializable.class;
        Class<Integer[]> aClass = Integer[].class;
        Class<Integer[][]> aClass1 = Integer[][].class;
        Class<Deprecated> deprecatedClass = Deprecated.class;
    }
}
