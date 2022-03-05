package thread;

import java.util.Scanner;
/*
    启动2个子线程
    线程1一直输出1-100的随机整数，直到线程2输入Q退出，结束进程
 */
public class ThreadPractice01 {
    public static void main(String[] args) {
        P1 p1 = new P1();
        P2 p2 = new P2(p1);
        p1.start();
        p2.start();
    }
}

class P1 extends Thread {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println(Thread.currentThread().getName() + "," + (int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class P2 extends Thread {
    private P1 p1;
    private Scanner sc = new Scanner(System.in);

    public P2(P1 p1) {
        this.p1 = p1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令(Q)并且回车表示退出");
            char key = sc.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                //通知线程P1结束
                p1.setLoop(false);
                break;
            }
        }
    }
}
