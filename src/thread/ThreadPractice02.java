package thread;

/*
    2个用户从同一张卡上取钱，每次都取1000，余额不足时不能取款
    不能出现超取现象
 */
public class ThreadPractice02 {
    public static void main(String[] args) {
        TP tp = new TP();
        Thread t1 = new Thread(tp);
        Thread t2 = new Thread(tp);
        t1.start();
        t2.start();
    }
}

class TP implements Runnable {
    private int bankCard = 10000;
    private boolean loop = true;

    @Override
    public void run() {
        while(loop) {
            takeMoney();
        }
    }

    public synchronized void takeMoney() {
        if(bankCard <=0 ) {
            System.out.println(Thread.currentThread().getName()+"银行卡余额不足"+bankCard);
            loop = false;
            return;
        }
        bankCard -= 1000;
        System.out.println(Thread.currentThread().getName()+","+bankCard);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
