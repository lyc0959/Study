package thread;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + ",状态=" + t.getState());//开始状态NEW
        t.start();
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + "状态=" + t.getState());
            Thread.sleep(1000);
        }
        System.out.println(t.getName() + "状态=" + t.getState());//结束状态
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("hello" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
