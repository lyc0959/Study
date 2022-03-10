package reflection.classIntro;

import reflection.Cat;

import java.lang.reflect.Field;

/**
 * Class类常用方法
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //加载类，生成Class对象
        Class cls = Class.forName("reflection.Cat");
        //输出的是哪个类的Class对象  reflection.Cat
        System.out.println(cls);
        //输出的是运行时对象类型：java.lang.Class类型
        System.out.println(cls.getClass());
        //得到Class对象对应的类的包名
        System.out.println(cls.getPackage().getName());
        //得到类名
        System.out.println(cls.getName());
        //获取对象
        Cat cat = (Cat)cls.newInstance();
        System.out.println(cat);
        //获取对象的属性,private私有属性无法获取
        Field field = cls.getField("age");
        System.out.println(field.get(cat));
        //给对象属性赋值
        field.set(cat,200);
        System.out.println(field.get(cat));
        //获取对象的所有属性的名称(private私有属性无法获取)
        System.out.println("------------------");
        Field[] fields = cls.getFields();
        for(Field f : fields) {
            System.out.println(f.getName());
        }
    }
}
