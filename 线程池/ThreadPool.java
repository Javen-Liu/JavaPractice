package threadPool;

import java.util.LinkedList;

/**
 * @author 刘建雯
 */

public class ThreadPool {
    private int threadPoolSize;
    LinkedList<Runnable> tasks = new LinkedList<>();

    public ThreadPool(int size){
        this.threadPoolSize = size;
        for (int i = 0; i < threadPoolSize; i++) {
            synchronized (tasks){
                new TaskConsumeThread("[ consumer "+i+" ]").start();
            }
        }
    }

    public void add(Runnable runnable){
        synchronized (tasks){
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread{
        private Runnable task;

        public TaskConsumeThread(String str){
            super(str);
        }

        @Override
        public void run() {
            while(true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    System.out.print(this.getName()+" :");
                    tasks.notifyAll();
                    task.run();
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
