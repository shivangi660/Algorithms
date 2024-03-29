class MovingAverage {
    
    int size, count = 0, windowSum = 0;
    Deque queue = new ArrayDeque<Integer>();
    
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        ++count;
        
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;
        
        windowSum = windowSum - tail + val;
        
        return windowSum * 1.0 / Math.min(size, count);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */