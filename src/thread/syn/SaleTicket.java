package thread.syn;

/*
    模拟售票，多线程同时操作，票多卖出的情况
 */
public class SaleTicket {
    public static void main(String[] args) {
        new TicketHas().start();
        new TicketHas().start();
        new TicketHas().start();
    }
}

class TicketHas extends Thread {
    private static int ticketNums = 10;//初始10张票,多线程共享
    private boolean loop = true;

    //此处synchronized是锁不住的，默认锁加在this对象上，而多个线程都是new的新的对象
    public synchronized void sale() {
        if (ticketNums <= 0) {
            System.out.println(Thread.currentThread().getName() + "票已卖完..");
            loop = false;
            return;
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + "已售票，剩余票" + --ticketNums);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (loop) {
            sale();
        }
    }
}
