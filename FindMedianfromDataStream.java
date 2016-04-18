class MedianFinder {

    PriorityQueue<Integer> high = new PriorityQueue<Integer>();
    PriorityQueue<Integer> low = new PriorityQueue<Integer>();  //low 是maxHeap
    public void addNum(int num) {
        //往哪个priorityqueue里面加，要看情况！
        if (high.size() != 0 && num > high.peek()) {
            low.offer(-1 * high.poll());
            high.offer(num);
        } else {
            low.offer(-num);
        }
        if (low.size() > high.size() + 1)
            high.offer(-1 * low.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (low.size() > high.size())
            return -1 * low.peek();
        else 
            return (-1 *low.peek() + high.peek()) / 2.0;
    }
};

