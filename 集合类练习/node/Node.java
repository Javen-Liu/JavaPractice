package node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘建雯
 */

public class Node {
    public Node leftNode;
    public Node rightNode;
    public Object value;

    public void add(Object ob){
        if(null == value){
            value = ob;
        }else{
            if((int)ob <= (int)value){
                if(null == leftNode){
                    leftNode = new Node();
                }
                leftNode.add(ob);
            }else{
                if(null == rightNode){
                    rightNode = new Node();
                }
                rightNode.add(ob);
            }
        }
    }

    public List<Object> values(){
        List<Object> list = new ArrayList<>();
        if(null != leftNode){
            list.addAll(leftNode.values());
        }
        list.add(value);
        if(null != rightNode){
            list.addAll(rightNode.values());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {14,23,51,34,23,13,42,52};
        Node node = new Node();
        for(int value:nums){
            node.add(value);
        }
        List<Object> list = node.values();
        for(Object value:list){
            System.out.println(value);
        }
    }
}
