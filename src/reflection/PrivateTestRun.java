package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateTestRun {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("reflection.PrivateTest");
        Object o = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"jojo");
        Method getName = cls.getDeclaredMethod("getName");
        System.out.println(getName.invoke(o));
    }
}
