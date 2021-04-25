package test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        testListMethod();
    }

    public static void testListMethod(){
        int[] a = {-4,-2,0};
        int[] b = {-2,-2,0};

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            l1.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            l2.add(b[i]);
        }
        System.out.println(l1.containsAll(l2));
    }
}
