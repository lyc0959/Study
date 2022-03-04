package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class callableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Pig pig = new Pig();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(pig);
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        Integer back = integerFutureTask.get();//get方法获取线程返回值是阻塞的
        System.out.println(back);
        for(int i=0;i<10;i++){
            System.out.println("当前线程="+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class Pig implements Callable<Integer> {
    private int count = 0;

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println("当前线程=" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
        return count;
    }
}
