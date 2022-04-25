class Solution {
     public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            pq.offer(e);
        }
        while(k > 0){
            Map.Entry<Integer, Integer> curr = pq.peek();
            int value = curr.getValue();
            if(k >= value){
                k -= value;
                pq.poll();                
            }else{
                break;
            }            
        }
        return pq.size();
    }
}