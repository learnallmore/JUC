import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.function.BinaryOperator;

class BoundedResource{
    private final Semaphore semaphore;//信号量
    private final int permits;//信号量个数
    private final Random random = new Random(111111);

    public BoundedResource(int permits){//这里semaphore算隐式参数
        this.semaphore = new Semaphore(permits);// blank final
        this.permits = permits;// blank final
    }

    //线程调用的方法，抛出异常
    public void use()throws InterruptedException {
        semaphore.acquire();
        try{
            doUse();//使用资源
            StringBuffer SB = new StringBuffer();
            SB.append("AAAA");

        }finally {
            semaphore.release();//在finally中释放资源，确保执行
        }
    }

    //实际使用资源，抛出异常
    protected void doUse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" "
                +Thread.currentThread().getPriority()
                +" :" + "Begin used "+(this.permits-semaphore.availablePermits()));
        //当前线程sleep
        Thread.sleep(random.nextInt(500));
        System.out.println(Thread.currentThread().getName()+" "
                +Thread.currentThread().getPriority()
                +" :" + "End used "+(this.permits-semaphore.availablePermits()));
    }
}

class UserThread extends Thread{
    private final static Random random = new Random(222222);
    private final BoundedResource resource ;//这里关键字换成static也可以，因为是引用变量

    UserThread(BoundedResource resource) {
        this.resource = resource;
    }
    //在run()调用use()方法，同时捕获抛出的异常
    public void run(){
        try {
            //final资源的使用
            this.resource.use();
            //当前线程sleep
            Thread.sleep(random.nextInt(3000));
           // Thread.yield();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



public class Semaphore1 {
    public static void main(String[] args){
        //创建资源，资源个数为3
        BoundedResource resource = new BoundedResource(3);
        //十个线程使用资源
        for(int i=0;i<10;i++){
            new UserThread(resource).start();
        }
    }
}
