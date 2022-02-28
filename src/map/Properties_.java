package map;

import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //添加元素
        properties.put("john", 123);
        properties.put("john", 234);
        properties.put("tom", 234);
        System.out.println(properties);
        //修改
        properties.put("tom",555);
        System.out.println(properties);
        //查询
        System.out.println(properties.get("john"));
        //删除元素
        properties.remove("tom");
        System.out.println(properties);

    }
}
