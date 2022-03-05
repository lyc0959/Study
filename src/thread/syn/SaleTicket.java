package thread.ticket;

/*
    模拟售票，多线程同时操作，票多卖出的情况
 */
public class SaleTicket {
    public static void main(String[] args) {
        TicketHas t1 = new TicketHas();
        TicketHas t2 = new TicketHas();
        TicketHas t3 = new TicketHas();
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketHas extends Thread {
    private static int ticketNums = 100;//初始100张票,多线程共享
    @Override
    public void run() {
        while(true) {
            if(ticketNums <= 0) {
                System.out.println("票已卖完..");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("现有票"+ticketNums+",剩余票"+--ticketNums);
        }
    }
}
