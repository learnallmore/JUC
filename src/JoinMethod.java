public class JoinMethod {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();//主线程调用interrupt,请求线程t中断,会抛出异常
        System.out.println("my turn --- main thread");
    }
}
