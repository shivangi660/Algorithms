class Solution {
    public int minKnightMoves(int x, int y) {
        // mark visited after pushing the node in the queue.
        int maxLength = 601;
        Deque<int[]> queue = new LinkedList<>();
        
        int[][] directions = {{1,2}, {1,-2}, {2,1}, {2,-1}, {-1,2}, {-2,1}, {-1,-2},{-2,-1}};
        int base = 300;
        int[][] visited = new int[maxLength][maxLength];
        
        
        queue.add(new int[]{0,0});
        int count = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] point = queue.poll();
                int r = point[0], c = point[1];
                if(visited[r + base][c + base] == 1){
                    continue;
                }
                visited[r + base][c + base] = 1;
                for(int[] dir : directions){
                    queue.offer(new int[]{r + dir[0], c + dir[1]});
                } 
                if(visited[x + base][y + base] == 1)
                    return count;
           }
            count++; 
        }
        return -1; 
        
    }
}