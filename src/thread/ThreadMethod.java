package thread;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        tt.setPriority(1);
        tt.start();
        tt.interrupt();
    }
}
class TT extends Thread {
    @Override
    public void run() {
        while(true){
            for(int i=0;i<5;i++){
                System.out.println("线程名="+Thread.currentThread().getName()+",吃包子~~"+i);
            }
            try {
                Thread.sleep(10*1000);//休眠10s
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"被唤醒了");
            }
        }
    }
}
