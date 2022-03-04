package thread;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        TE te = new TE();
        te.start();
        Thread.sleep(5000);
        te.setLoop(false);//通知线程终止
    }
}

class TE extends Thread {
    private int count;
    private boolean loop = true;//用来通知线程终止

    @Override
    public void run() {
        while (loop) {
            System.out.println("运行中..." + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
