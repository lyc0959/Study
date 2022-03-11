package reflection;

import java.lang.reflect.Field;

public class ReflectBoom02 {
    public static void main(String[] args) throws Exception{
        //拿到Class对象
        Class cls = Class.forName("reflection.User");
        //创建User类对象
        Object o = cls.newInstance();
        //获取全部属性（私有、公有）
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);//属性暴破
            Object o1 = declaredField.get(o);//获取属性的值
            System.out.println(o1);
        }
        Field college = cls.getDeclaredField("college");//获取私有静态变量 college
        college.setAccessible(true);
        college.set(null,"牢记历史家乐福家");//静态变量 设置属性值时，对象o可以为null
        Object o1 = college.get(o);//获取属性值
        System.out.println(o1);
    }
}
