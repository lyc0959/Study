package BasicType;

public class IntegerTest {
    public static void main(String[] args) {
        Integer c1 = 126;
        Integer c2 = 126;
        System.out.println(c1==c2);//true;因为Integer.cache缓存，-128~127之间的数，都会从缓存中取出来，所以c2和c1指向的是一个对象
        Integer key = 456;
        Integer p = 456;
        int i = Integer.valueOf(456);
        System.out.println(key.equals(p));//true;比较内容
        System.out.println(key.hashCode()+","+p.hashCode());
        System.out.println("key等于p吗:"+(key==p));//false;key和p自动装箱为2个对象，==比较的是对象在内存中的地址,因为是2个对象，所以地址不同
        System.out.println("key等于i吗:"+(key==i));//true
        System.out.println("p等于i吗:"+(i==p));//true
        int a = 123;
        int b = 123;
        System.out.println(a==b);//基本数据类型，变量a和b存放在栈内存中
    }
}
