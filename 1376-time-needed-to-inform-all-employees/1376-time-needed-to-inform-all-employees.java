class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
       // create Graph with HashMap as mananger and list as all the employees
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // Iterate through the array and put the corresponding relationship
        for(int i = 0; i < n; i++){
            int m = manager[i];
            ArrayList<Integer> directs = map.getOrDefault(m, new ArrayList<>());
            directs.add(i);
            map.put(m, directs);
        }
        
        
        System.out.println(map.toString());
        class ManagerTime{
            int manager;
            int informTime;
            public ManagerTime(int manager, int informTime){
                this.manager = manager;
                this.informTime = informTime;
            }
        }
        
        int result = Integer.MIN_VALUE;
        Queue<ManagerTime> queue = new LinkedList<>();
        // put in queue the headId and corresponding inform time
        queue.add(new ManagerTime(headID, 0));
        
        while(!queue.isEmpty()){
            ManagerTime m = queue.poll();
            result = Math.max(result, m.informTime);
            if(map.containsKey(m.manager)){
                ArrayList<Integer> directs = map.get(m.manager);
                for(int emp : directs){
                    queue.offer
                        (new ManagerTime(emp, informTime[m.manager] + m.informTime));
                }
            }
        }
        return result;
    }
}