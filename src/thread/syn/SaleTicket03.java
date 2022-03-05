package thread.syn;

public class SaleTicket02 {
    public static void main(String[] args) {
        Ticket02 ticket02 = new Ticket02();
        Thread thread1 = new Thread(ticket02);
        Thread thread2 = new Thread(ticket02);
        Thread thread3 = new Thread(ticket02);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Ticket02 implements Runnable {

    private int ticketNums = 10;//初始100张票,多线程共享

    @Override
    public synchronized void run() {
        while (true) {
            if (ticketNums <= 0) {
                System.out.println("票已卖完..");
                break;
            }
            System.out.println("剩余票" + --ticketNums);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
