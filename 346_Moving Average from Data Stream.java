class MovingAverage {
    Queue<Integer> q;
    int size;
    double sum = 0;
    
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        if(q.size() >= size) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}
