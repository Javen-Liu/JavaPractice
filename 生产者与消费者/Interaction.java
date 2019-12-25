package ConsumersAndProducer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 刘建雯
 */

public class Interaction {
    public static void main(String[] args) throws InterruptedException {
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.println("[ Please input the number of thread ]");
        count = scanner.nextInt();
        Stack<Character> stack = new Stack<>();
        Consumer[] consumers = new Consumer[count];
        Producer[] producers = new Producer[count];
        for (int i = 0; i < count; i++) {
            consumers[i] = new Consumer(i+1);
            producers[i] = new Producer(i+1);
        }
        Thread[] consumersThread = new Thread[count];
        Thread[] producersThread = new Thread[count];
        final boolean[] flag = {true,true};
        for (int i = 0; i < count; i++) {
            int finalI = i;
            Thread produce = new Thread(() -> {
                try {
                    while(flag[0]){
                        producers[finalI].produceRandomChar(stack);
                        Thread.sleep(500);
                        if(stack.size() == 10){
                            flag[0] = false;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            produce.start();
            producersThread[i] = produce;

            Thread consume = new Thread(() -> {
                try {
                    while(flag[1]){
                        consumers[finalI].consume(stack);
                        Thread.sleep(500);
                        if(stack.size() == 0 && !flag[1]){
                            flag[0] = false;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            consume.start();
            consumersThread[i] = consume;
        }

        for(Thread thread : consumersThread){
            thread.join();
        }
        for (Thread thread: producersThread) {
            thread.join();
        }
    }
}
