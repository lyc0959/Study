package thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();//启动线程，运行run方法
//        myThread.run();//普通run方法，没有启动线程
        System.out.println("主线程main()名称="+Thread.currentThread().getName());
        for(int i=0;i<60;i++){
            System.out.println("主线程i="+i);
            Thread.sleep(1000);
        }
    }
}

class MyThread extends Thread {
    private int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("老司机ad空方块几零几苏打粉"+(++times));
            try {
                Thread.sleep(1000);//1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 80) {
                break;
            }
        }
    }
}
