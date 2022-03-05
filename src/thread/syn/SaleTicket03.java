package thread.syn;

public class SaleTicket03 {
    public static void main(String[] args) {
        Ticket03 ticket03 = new Ticket03();
        new Thread(ticket03).start();
        new Thread(ticket03).start();
        new Thread(ticket03).start();
    }
}

class Ticket03 implements Runnable {

    private int ticketNums = 10;//初始100张票,多线程共享
    private boolean loop = true;
    Object object = new Object();

    public static void m() {
        synchronized (Ticket03.class) {
            System.out.println("静态方法同步");
        }
    }

    public void sale() {
        synchronized (object) {
            if (ticketNums <= 0) {
                System.out.println(Thread.currentThread().getName() + "票已卖完..");
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + ",剩余票" + --ticketNums);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        public synchronized void sale() {
            if (ticketNums <= 0) {
                System.out.println(Thread.currentThread().getName() + "票已卖完..");
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + ",剩余票" + --ticketNums);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    */
    @Override
    public void run() {
        while (loop) {
            sale();
        }
    }
}
