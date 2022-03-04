package thread;

public class ProtectThread {
    public static void main(String[] args) throws InterruptedException {
        PT pt = new PT();
        pt.setDaemon(true);//将子线程设置为守护线程，main线程结束子线程也结束。
        pt.start();
        for(int i=1;i<=5;i++){
            System.out.println("C在辛苦工作..."+i);
            Thread.sleep(1000);
        }
    }
}

class PT extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("A和B开心聊天...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
