package reflection;

import java.lang.reflect.Method;

public class ReflectBoom03 {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<?> aClass = Class.forName("reflection.User");
        //创建对象
        Object o = aClass.newInstance();
        //获取方法
        Method user = aClass.getDeclaredMethod("run");
        user.setAccessible(true);//暴破
        user.invoke(null);//访问静态无参方法
        Method check = aClass.getDeclaredMethod("check", int.class, String.class);
        check.setAccessible(true);//暴破
        Object returnValue = check.invoke(o, 18, "睿智");//访问private 有参方法
        System.out.println(returnValue);
    }
}
