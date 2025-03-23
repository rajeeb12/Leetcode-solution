class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a,b) -> b - a);
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()){
            leftMaxHeap.add(num);
        }else{
            rightMinHeap.add(num);
        }
        if(leftMaxHeap.size() - rightMinHeap.size() > 1){
            rightMinHeap.add(leftMaxHeap.poll());
        }

        if(rightMinHeap.size() > leftMaxHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        int size = leftMaxHeap.size() + rightMinHeap.size();
        if(size % 2 == 0){
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        }else{
            return leftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */