package reflection;

import java.lang.reflect.Method;

/**
 * 对比传统调用和反射调用的性能，并进行反射优化
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception{
        new Reflection02().m1();
        new Reflection02().m2();
    }

    //传统方法调用Cat类的miao方法
    public void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();//开始时间 毫秒
        for (int i = 0; i < 90000000; i++) {
            cat.miao();//空方法
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("传统方法耗时："+(end-start));
    }

    //反射机制调用Cat类的miao方法
    public void m2() throws Exception{
        long start = System.currentTimeMillis();//开始时间
        Class cls = Class.forName("reflection.Cat");//反射机制加载类 拿到Cat类的Class对象
        Object o = cls.newInstance();//反射机制创建对象
        Method method = cls.getMethod("miao");//获取cat对象的方法miao
        method.setAccessible(true);//反射方法调用的时候取消安全检查，提高效率（有提升但提升不大）
        for (int i = 0; i < 90000000; i++) {
            method.invoke(o);//调用cat对象的miao方法
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("反射机制耗时："+(end-start));
    }
}


