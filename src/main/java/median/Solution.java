package median;

import java.util.*;

/*
*  Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
*
*
 */

class Solution {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.add(num);
        } else if (minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
            swapHeadsIfNeeded();
        } else {
            minHeap.add(num);
            swapHeadsIfNeeded();
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0) {
            throw new IllegalStateException("No elements were added");
        }

        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2D;
        }

        return maxHeap.peek().doubleValue();
    }

    private void swapHeadsIfNeeded() {
        if (maxHeap.peek() > minHeap.peek()) {
            int t = minHeap.poll();
            minHeap.add(maxHeap.poll());
            maxHeap.add(t);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.addNum(5);
//        solution.addNum(2);
//        solution.addNum(0);
//        solution.addNum(3);
//        solution.addNum(4);
//        solution.addNum(0);

        solution.addNum(0);
        solution.addNum(3);
        //solution.addNum(4);
        solution.addNum(2);



        System.out.println(solution.findMedian());
    }

}
