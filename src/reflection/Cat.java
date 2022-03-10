package reflection;

public class Cat {
    private String name = "jack";
    public int age = 10;
    public String color = "红色";
    public int type = 0;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void miao() {
        //System.out.println("miao~");
    }

    public void cry(){
        System.out.println("猫哭了");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
