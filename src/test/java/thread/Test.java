package thread;

/**
 * Created by lincg on 2017/6/28.
 */
public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestThread tt = new TestThread();
        tt.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Printed by main thread");
    }
}

class TestThread extends Thread {
    static int i = 0;
    final static int MAX_I = 10;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName());
        while (i < MAX_I) {
            System.out.println(i++);
        }
    }
}
