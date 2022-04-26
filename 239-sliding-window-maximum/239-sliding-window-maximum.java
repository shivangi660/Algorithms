class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // This implementation will give TLE for bigger size inputs
//         Deque<Integer> q = new LinkedList<Integer>();
//         //PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
//         int[] ans = new int[nums.length - k + 1];
//         int count = 0;
//         for(int i = 1; i < k ; i++){
//             pq.add(nums[i]);
//             q.add(nums[i]);
//         }
        
//         for(int i = k; i < nums.length; i++){
//             ans[count++] = pq.peek();
//             int element = q.removeFirst();
//             if(pq.contains(element))
//                 pq.remove(element);
//             q.add(nums[i]);
//             pq.add(nums[i]);
//         }
//         ans[count] = pq.remove();
//         return ans;
        
        
        // Queue top will contain the biggest element
        Deque<Integer> q = new LinkedList<Integer>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int count = 0;
        for(int i = 0; i < n ;i++){
            // invalidating the queue to contain element only from the current window
            if(!q.isEmpty() && q.peek() < i - k + 1){
                q.removeFirst();
            }
            // Invalidating the queue to only contain element bigger than the current element.
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            if(i - k + 1 >= 0){
                ans[count++] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}