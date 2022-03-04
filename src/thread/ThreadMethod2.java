package thread;
/*
    主线程和子线程同时运行，主线程运行5秒后让子线程插队，子线程执行完毕后再执行主线程，最后主线程执行完毕进程结束。
 */
public class ThreadMethod2 {
    public static void main(String[] args) throws InterruptedException {
        T02 t02 = new T02();
        t02.start();
        for (int i = 1; i <= 20; i++) {
            System.out.println("hi" + i);
            Thread.sleep(1000);
            if (i == 5) {
                System.out.println("让子线程插队");
                t02.join();
            }
        }
    }
}

class T02 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
