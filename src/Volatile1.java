import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class Obj {
    public volatile int a = 0;
    public void increment() {
            a++;
    }
}
public class Volatile1{//volatile关键字不保证原子性
    public static void main(String[] args){
        final Obj obj = new Obj();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    obj.increment();
                }
            }).start();


//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            }).start();
        }
        System.out.println(obj.a);
    }
}



