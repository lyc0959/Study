package reflection;

import java.lang.reflect.Constructor;

public class ReflectBoom {
    public static void main(String[] args) throws  Exception{
        //获取Class对象
        Class cls = Class.forName("reflection.User");
        //通过public无参构造器获取对象
        Object o = cls.newInstance();
        //通过public有参构造器获取对象
        Constructor constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("哈哈");
        //通过非public有参构造器获取对象
        Constructor declaredConstructor = cls.getDeclaredConstructor(int.class,String.class);
        declaredConstructor.setAccessible(true);//反射暴力破解，能够访问private构造器
        Object o2 = declaredConstructor.newInstance(100, "嘿嘿");
        System.out.println(o2);
    }
}
