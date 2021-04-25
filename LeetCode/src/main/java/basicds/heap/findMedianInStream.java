package basicds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author rjjerry
 */
public class findMedianInStream {
    int count = 0;
    //返回一种按照自然序列的队列，一般是从小到大
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
        }
    });

    public void insert(Integer num){
        if (count % 2 == 0){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        count++;
        System.out.println(findMedianInStream.getMedian());
    }

    public static int getMedian(){
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        findMedianInStream famish = new findMedianInStream();
        famish.insert(1);
        famish.insert(2);
        famish.insert(0);
        famish.insert(20);
        famish.insert(10);
        famish.insert(26);
        famish.insert(33);
    }

}
