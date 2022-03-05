package thread.syn;

/*
    模拟死锁现象
 */
public class DeadLock {
    public static void main(String[] args) {
        new DeadLockDemo(true).start();
        new DeadLockDemo(false).start();
    }
}

class DeadLockDemo extends Thread {
    private static Object o1 = new Object();//static 存入方法区 让多线程共享
    private static Object o2 = new Object();
    private boolean flag;

    DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {//当flag为true，当前线程拿到o1锁进行操作，继续拿o2锁，若拿不到o2锁，会阻塞进入BLOCKED状态
                System.out.println(Thread.currentThread().getName()+"拿到o1锁");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName()+"拿到o2锁");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+"拿到o2锁");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"拿到o1锁");
                }
            }
        }
    }
}
