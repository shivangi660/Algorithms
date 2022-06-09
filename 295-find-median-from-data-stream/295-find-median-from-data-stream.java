class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMinHeap=new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        leftMaxHeap.add(num);
        
        if(!leftMaxHeap.isEmpty() && !rightMinHeap.isEmpty() && leftMaxHeap.peek()>rightMinHeap.peek())
        {
            int data=leftMaxHeap.poll();
            rightMinHeap.add(data);
        }
        if(leftMaxHeap.size()>rightMinHeap.size()+1)
        {
            int data=leftMaxHeap.poll();
            rightMinHeap.add(data);
        }
        else if(rightMinHeap.size()>leftMaxHeap.size()+1)
        {
            int data=rightMinHeap.poll();
            leftMaxHeap.add(data);
        }
    }
    
    public double findMedian() {
        //System.out.println(leftMaxHeap+" "+rightMinHeap);
        if(leftMaxHeap.size()==rightMinHeap.size())   // even length
        {
            return (leftMaxHeap.peek()+rightMinHeap.peek())/2.0;
        }
        else                                    // odd length
        {
            return leftMaxHeap.size()>rightMinHeap.size()?leftMaxHeap.peek():rightMinHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */