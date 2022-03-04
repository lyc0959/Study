package thread;

/*
    模拟线程代理模式
 */
public class ProxyTest {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ProxyThread proxyThread = new ProxyThread(tiger);
        proxyThread.start();
    }
}

class Animals{}
class Tiger extends Animals implements Runnable {

    @Override
    public void run() {
        System.out.println("Tiger!");
    }
}

/*
    定义一个代理人
 */
class ProxyThread implements Runnable {
    private Runnable target = null;

    public ProxyThread(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if(target != null) {
            target.run();//动态绑定（实际运行的是传进来的target：Tiger对象）
        }
    }

    public void start() {
        start0();
    }

    public void start0() {
        run();
    }

}
