package StringBuffer;

import java.util.LinkedList;

/**
 * @author 刘建雯
 */
public class MyStringBuffer implements IStringBuffer{
    private int length;
    private int capacity;
    private char[] chars;

    public MyStringBuffer(){
        capacity = 19;
        chars = new char[capacity];
        length = 0;
    }

    public MyStringBuffer(int c){
        capacity = c;
        chars= new char[capacity];
        length = 0;
    }

    @Override
    public void append(String str){
        char[] c = str.toCharArray();
        while(c.length+length>capacity){
            capacity += 19;
        }
        char[] newChars = new char[capacity];
        System.arraycopy(chars,0,newChars,0,length);
        System.arraycopy(c,0,newChars,length,c.length);
        chars = newChars;
        length += c.length;
    }

    @Override
    public void append(char c) {
        if(capacity == length){
            capacity += 19;
        }
        chars[length] = c;
        length++;
    }

    @Override
    public void append(char[] cs) {
        while(cs.length+length>capacity){
            capacity += 19;
        }
        char[] newChars = new char[capacity];
        System.arraycopy(chars,0,newChars,0,length);
        System.arraycopy(cs,0,newChars,length, cs.length);
        chars = newChars;
        length += cs.length;
    }


    @Override
    public void insert(int pos, String str) throws Exception{
        if(pos<0){
            throw new IndexIsNagetiveException("输入操作序号未负\n");
        }
        if(pos>length){
            throw new NullPointerException("指针不存在或超出范围\n");
        }
        char[] c = str.toCharArray();
        while(c.length+length>capacity){
            capacity += 19;
        }
        char[] newChars = new char[capacity];
        System.arraycopy(chars,0,newChars,0,pos);
        System.arraycopy(c,0,newChars,pos,c.length);
        System.arraycopy(chars,pos,newChars,pos+c.length,length-pos);
        chars = newChars;
        length += c.length;
    }

    @Override
    public void insert(int pos, char c) throws Exception{
        if(pos<0){
            throw new IndexIsNagetiveException("输入操作序号未负\n");
        }
        if(pos>length){
            throw new NullPointerException("指针不存在或超出范围\n");
        }
        if(capacity == length){
            capacity += 19;
        }
        char[] newChars = new char[capacity];
        System.arraycopy(chars,0,newChars,0,pos);
        newChars[pos] = c;
        System.arraycopy(chars,pos,newChars,pos+1,length-pos);
        chars = newChars;
        length++;
    }

    @Override
    public void delete(int start) throws Exception{
        if(start<0){
            throw new IndexIsNagetiveException("输入操作序号未负\n");
        }
        if(start>length){
            throw new NullPointerException("指针不存在或超出范围\n");
        }
        int reducedNum = (int)Math.ceil((start-1)/19d);
        capacity = reducedNum*19;
        char[] newChars = new char[capacity];
        System.arraycopy(chars,0,newChars,0,start-1);
        chars = newChars;
        length = start-1;
    }

    @Override
    public void delete(int start, int end) throws Exception{
        if(start == end){
            throw new NullPointerException("所输入序号必须不同\n");
        }
        if(start>length||end>length){
            throw new NullPointerException("指针不存在或超过范围\n");
        }
        if(start > end){
            int a = start;
            end = start;
            start = a;
        }
        int reducedNum = (int)Math.ceil((length-end+start-1)/19d);
        capacity = reducedNum*19;
        char[] newChars = new char[capacity];
        System.arraycopy(chars,0,newChars,0,start-1);
        System.arraycopy(chars,end-1,newChars,start-1,length-end+1);
        chars = newChars;
        length = length-(end-start);
    }

    @Override
    public void reverse() {
        char[] newChars = new char[length];
        for(int i=0;i<length;i++){
            newChars[length-i-1] = chars[i];
        }
        System.arraycopy(newChars,0,chars,0,length);
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int getCapacity(){
        return capacity;
    }

    @Override
    public String toString(){
        char[] newChars = new char[length];
        System.arraycopy(chars,0,newChars,0,length);
        return new String(newChars);
    }

    static class IndexIsOutofRangeException extends Exception{
        public IndexIsOutofRangeException(String s){
            super(s);
        }
    }

    static class IndexIsNagetiveException extends Exception{
        public IndexIsNagetiveException(String s){
            super(s);
        }
    }

    static class NullPointerException extends Exception{
        public NullPointerException(String s){
            super(s);
        }
    }

    public static void main(String[] args) throws Exception{
        MyStringBuffer msb = new MyStringBuffer();
        msb.append("11111111111111111111122222");
        msb.append('0');
        char[] cs = {'7','4','3'};
        msb.append(cs);
        System.out.println(msb.toString());
        msb.insert(4,"235436");
        System.out.println(msb.toString());
        msb.delete(4,15);
        System.out.println(msb.toString());
        msb.reverse();
        System.out.println(msb.toString());
        System.out.println(msb.length);
        System.out.println(msb.getCapacity());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("2");
    }
}
