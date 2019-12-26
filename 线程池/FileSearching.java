package threadPool;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘建雯
 */

public class FileSearching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[ Please input path ]");
        String path = scanner.nextLine();
        System.out.println("[ Please input end words ]");
        String endWords = scanner.nextLine();
        System.out.println("[ Please input the special words you wanna find ]");
        String specialWords = scanner.nextLine();
        FileSearching fileSearching = new FileSearching();
        fileSearching.fileSearch(path,endWords,specialWords);
    }

    private static int count = 0;
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public void fileSearch(String path, String endStr, String specialStr){
        File filePath = new File(path);
        if(!filePath.exists()){
            System.out.println("[warning] file not exist");
            return;
        }
        if(!filePath.isDirectory()){
            if(filePath.getName().endsWith(endStr)){
                threadPool.execute(() -> {
                    try {
                        char[] content = new char[(int)filePath.length()];
                        FileReader fileReader = new FileReader(filePath);
                        fileReader.read(content);
                        if(String.valueOf(content).contains(specialStr)){
                            System.out.println("[file found] "+filePath.getAbsolutePath());
                            FileSearching.countUp();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }else{
            File[] files = filePath.listFiles();
            assert files != null;
            for(File file:files){
                fileSearch(file.getAbsolutePath(),endStr,specialStr);
            }
        }
        System.out.println("find "+count+" files end with "+endStr+" and contain \""+specialStr+"\"");
    }

    private static void countUp(){
        count++;
    }

}
