package thread;

/*
    1.主线程每隔1s输出hi，共10次
    2.当输出到hi5的时候，启动子线程（要求实现Runnable），每隔1s输出hello，
    等该线程输出10次hello后退出，主线程继续输出hi，直到结束
 */
public class ThreadPractice {
    public static void main(String[] args) throws InterruptedException {
        XiaoDi xiaoDi = new XiaoDi();
        Thread thread = new Thread(xiaoDi);
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi"+i);
            Thread.sleep(1000);
            if(i == 5) {
                System.out.println("启动子线程并直接让其插队");
                thread.start();
                thread.join();
            }
        }
        System.out.println("主线程结束...");
    }
}

class XiaoDi implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束");
    }
}