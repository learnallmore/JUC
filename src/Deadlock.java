

class deadlockThread extends Thread{
    private static final Object obj1 = new Object();//类字段,初始化,实例可以直接使用
    private static final Object obj2 = new Object();
    private Boolean f = true;

    public deadlockThread(Boolean f){//构造方法必须是public权限
        this.f = f;
    }

    @Override
    public void run() {
        if(f){
            synchronized (obj1) {
                System.out.println(Thread.currentThread()+"线程获取到obj1的对象锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(Thread.currentThread()+"当前线程获取到obj2的对象锁");
                }
            }
        }else{
            synchronized (obj2) {
                System.out.println(Thread.currentThread()+"线程获取到obj2的对象锁");
                try {
                    Thread.sleep(100);//让系统进行线程调度,使得线程2能获取obj2的对象锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println(Thread.currentThread()+"当前线程获取到obj1的对象锁");
                }
            }
        }
    }
}


public class Deadlock {



    public static void main(String[] args){
        Thread d1 = new deadlockThread(true);
        Thread d2 = new deadlockThread(false);
        d1.start();
        d2.start();
    }


}
