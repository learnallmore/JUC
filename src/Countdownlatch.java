import java.util.concurrent.CountDownLatch;

public class Countdownlatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countdownlatch = new CountDownLatch(6);
        for(int i=0;i<6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countdownlatch.countDown();//计数减一
            }, String.valueOf(i)).start();
        }
        //当计数值>0时，当前线程即主线程调用这个方法会休止，不参与线程调用，
        // 当计数值为0值时，此方法return,主线程参与调度
        countdownlatch.await();
        System.out.println(Thread.currentThread().getName()+" current thread execute");
    }
}
