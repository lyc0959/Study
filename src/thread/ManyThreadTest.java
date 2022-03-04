package thread;

public class ManyThreadTest {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
        for(int i=0;i<100;i++) {
            Thread.sleep(1000);
            System.out.println("主线程main="+Thread.currentThread().getName());
        }
    }
}

class T1 extends Thread {
    private int count;

    @Override
    public void run() {
        while (true) {
            count++;
            System.out.println("线程1="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 50) {
                break;
            }
        }
    }
}

class T2 extends Thread {
    private int count;
    @Override
    public void run() {
        while (true) {
            count++;
            System.out.println("线程2="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 60){
                break;
            }
        }
    }
}
