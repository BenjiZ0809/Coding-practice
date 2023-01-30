class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
//     public void addNum(int num) {
//         if(minHeap.isEmpty() || num > minHeap.peek()) minHeap.add(num);
//         else maxHeap.add(num);
//         if(minHeap.size() > maxHeap.size() + 1) {
//             maxHeap.add(minHeap.poll());
//         }
//         if(maxHeap.size() > minHeap.size()) {
//             minHeap.add(maxHeap.poll());
//         } 
//     }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        }
        else return minHeap.peek();
    }
}
