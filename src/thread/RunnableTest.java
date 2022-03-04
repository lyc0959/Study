package thread;

public class RunnableTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("Runnable"+(++count)+"线程名称="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10) {
                break;
            }
        }
    }
}
