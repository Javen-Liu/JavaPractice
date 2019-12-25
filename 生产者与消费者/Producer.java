package ConsumersAndProducer;

import java.util.Random;
import java.util.Stack;

/**
 * @author 刘建雯
 */

public class Producer {
    private int count;

    public Producer(int count){
        this.count = count;
    }

    public void produceRandomChar(Stack<Character> stack) throws InterruptedException {
        Random random = new Random();
        char randomChar = (char)(random.nextInt(25)+65);
        synchronized (stack){
            int MAX_SIZE = 10;
            if(stack.size() == MAX_SIZE){
                stack.wait();
            }else{
                stack.push(randomChar);
                System.out.println("[ producer"+count+" ] : produce "+randomChar+"\n  stack : "+stack.size()+"\n right now content : "+stack.toString());
                stack.notify();
            }
        }
    }
}
