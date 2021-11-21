import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable_future {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(
                ()->{return 1;}//实现callable接口
        );
        new Thread(futureTask).start();
        if(!futureTask.isDone()){
            System.out.println("wait");
        }
        System.out.println(futureTask.get());
        System.out.println(futureTask.get());
    }
}
