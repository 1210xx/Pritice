package basicds.stackheapline;

import java.util.LinkedList;

public class JosephusProblem {
    public static void main(String[] args) {
        ring(41,3,1);
    }

    public static void ring (int n, int m, int k){
        //创建链式队列
        LinkedList<Integer> q = new LinkedList<Integer>();
        //全部成员入队
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        //临时的元素
        int element = -1;
        //下标 -- 标记位置
        int i;
        //由于输入的n个数据已经有了下标，所以将前k-1个加入队尾 -- 对输入的元素进行了重新排列
        for (i = 1; i < k; i++) {
            element = q.poll();
            q.add(element);
        }
        //从重新排好的队列中的第一个开始，即第k个开始
        i = 1;
        while (q.size() > 0) {
            //取出队首元素，如果是目标元素，则输出。如果不是，则插入队尾继续。
            element = q.poll();
            //开始报数
            if (i < m) {
                //没到m，放入队尾
                q.add(element);
                i++;
                //如果是目标元素
            } else {
                //重新开始报数
                i = 1;
                System.out.println(element);
            }
        }
    }
}
