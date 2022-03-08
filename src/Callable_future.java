import java.util.concurrent.*;

public class Callable_future {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(//Integer是returnType
                ()->{
                    Thread.sleep(1000);
                    return 1;
                }//实现callable接口
        );
        new Thread(futureTask).start();

        //可以使用isDone进行轮询
//        if(!futureTask.isDone()){
//            System.out.println("wait");
//        }

        //在调用get前可以实现异步，主线程执行其他代码
        System.out.println("main thread running");



        //主线程会等待get返回，主线程阻塞
        System.out.println(futureTask.get());
        System.out.println("main thread");
        System.out.println(futureTask.get());
    }
}
