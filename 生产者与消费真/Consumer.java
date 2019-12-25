package ConsumersAndProducer;

import java.util.Stack;

/**
 * @author 刘建雯
 */

public class Consumer {
    private int count;

    public Consumer(int count){
        this.count = count;
    }

    public void consume(Stack<Character> stack) throws InterruptedException{
        String consumeChar;
        synchronized (stack){
            if(stack.size() == 0){
                stack.wait();
            }else{
                consumeChar = String.valueOf(stack.pop());
                assert consumeChar != null;
                System.out.println("[ consumer"+count+" ] : consume "+consumeChar+"\n stack : "+stack.size()+"\n right now content : "+stack.toString());
                stack.notify();
            }
        }
    }
}
