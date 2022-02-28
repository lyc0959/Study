package String;

public class StringTest {
    public static void main(String[] args) {
        //创建2个String对象
        String a = new String("haha");
        String b = new String("haha");
        System.out.println(a == b);
        System.out.println(a.hashCode() + "," + b.hashCode());
        System.out.println(a.equals(b));
        //直接赋值，编译时会封装成String对象存入常量池（共享）
        String c = "ccc";
        String d = "ccc";
        System.out.println(c.hashCode() + "," + d.hashCode());
        System.out.println(c.equals(d));
        System.out.println(c == d);

    }
}
