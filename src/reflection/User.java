package reflection;

public class User {
    private int age = 18;
    private String name = "睿智";
    public int tall = 180;
    private static String college = "哈哈";

    //public 无参构造器
    public User() {
    }

    //public有参构造器
    public User(String name) {
        this.name = name;
    }

    //非public有参构造器
    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //私有的方法
    private static void run() {
        System.out.println("跑起来了");
    }

    //私有 有参方法
    private boolean check(int age,String name) {
        if(age == this.age && name == this.name) {
            return true;
        }
        return false;
    }


    public User(int age, String name, int tall) {
        this.age = age;
        this.name = name;
        this.tall = tall;
    }
}
