public class Test {
    public static void main(String[] args) {
        Test test = new Test();

    }

    static class InClass {
        private String name;
        private int age;

        public void print() {
            System.out.println("我是内部类");
        }
    }
}
