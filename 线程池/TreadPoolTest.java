package threadPool;

/**
 * @author 刘建雯
 */

public class TreadPoolTest {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(10);
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            Runnable runnable = () -> System.out.println(" task "+ finalI+" running");
            threadPool.add(runnable);
            try{
                Thread.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
