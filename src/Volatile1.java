
import java.io.IOException;


class Obj {
    public volatile int a = 0;
    public void increment() {
            a++;
    }
}
public class Volatile1{//volatile关键字不保证原子性
    public static void main(String[] args) throws IOException {
        final Obj obj = new Obj();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++){
                    obj.increment();
                }
            }).start();

        }
        System.out.println(obj.a);
    }
}



