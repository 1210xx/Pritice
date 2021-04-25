package basicds.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * stack
 * up stack
 */
public class SimpleStack {
    public SimpleStack(){

    }
    private static List<Integer> simpleStack = new LinkedList<>();

    public int push(int item){
        simpleStack.add(item);
        return item;
    }

    public int  pop(){
        int len = simpleStack.size();
        int temp = simpleStack.get(len - 1);
        simpleStack.remove(len - 1);
        return temp;
    }

    public int size(){
        return simpleStack.size();
    }

    public int get(int index){
        return simpleStack.get(index);
    }

    public List popAll(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < simpleStack.size(); i++) {
            list.add(simpleStack.get(i));
        }
        simpleStack.clear();
        return list;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < simpleStack.size(); i++) {
            stringBuilder.append(" | ").append(simpleStack.get(i));
        }
        stringBuilder.append(" |");
        return stringBuilder.toString();
    }
}
