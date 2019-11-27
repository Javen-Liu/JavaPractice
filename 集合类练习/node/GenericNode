package node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘建雯
 */

public class GenericNode<T extends Comparable<T>> {
    public GenericNode<T> leftNode;
    public GenericNode<T> rightNode;
    public T value;

    public void add(T o){
        if(null == value){
            this.value = o;
        }else{
            if(value.compareTo(o)>=0){
                if(null == leftNode){
                    leftNode = new GenericNode<>();
                }
                leftNode.add(o);
                    }else{
                if(null == rightNode){
                    rightNode = new GenericNode<>();
                }
                rightNode.add(o);
            }
        }
    }

    public List<T> values(){
        ArrayList<T> arrayList = new ArrayList<>();
        if(null != leftNode){
            arrayList.addAll(leftNode.values());
        }
        arrayList.add(value);
        if(null != rightNode){
            arrayList.addAll(rightNode.values());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        GenericNode<Integer> genericNode = new GenericNode<>();
        int[] nums = {23,34,25,64,73,24,53,34,62,42,34};
        for(int value: nums){
            genericNode.add(value);
        }
        List<Integer> list = genericNode.values();
        for(int value:list){
            System.out.print(value+"\t");
        }

        GenericNode<Character> genericNode1 = new GenericNode<>();
        char[] str = {'a','r','[','f','b'};
        for(char value: str){
            genericNode1.add(value);
        }
        List<Character> list1 = genericNode1.values();
        for(char value:list1){
            System.out.print(value+"\t");
        }
    }
}
