package reflection;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 通过配置文件，获取Cat对象，并调用方法miao
 */
public class reflection_question {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();//创建properties
        properties.load(new FileInputStream("src/re.properties"));//加载配置文件
        String classPath = properties.getProperty("class_full_path");//拿到了类的路径
        String methodName = properties.getProperty("method");//拿到方法的名称
        System.out.println(classPath+","+methodName);
        //走到这步发现无法创建对象，需要借助反射机制根据类路径名创建对象；
        //加载类，返回Class类型的对象
        Class c = Class.forName(classPath);
        //创建对象实例,Cat类必须要保留无参构造器，不然会报错
        Object o = c.newInstance();//运行时类型是cat
        //根据方法名称获取方法对象
        Method method = c.getMethod(methodName);
        method.invoke(o);//一般调用方法是 对象.方法 但是反射机制是方法.invoke(对象)
        //获取对象的属性,getField不能获取私有属性
        Field name = c.getField("age");
        System.out.println(name.get(o));//调用对象的属性
        //获取对象的构造方法（有参和无参）
        Constructor con = c.getConstructor();//获取无参构造器
        System.out.println(con);
        Constructor con2 = c.getConstructor(String.class,int.class);
        System.out.println(con2);//获取有参构造器
    }
}
