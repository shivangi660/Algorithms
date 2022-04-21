class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // HashMap with player as Key and number of matches won as entry
        // 2 HAshMap with player as key and number of matches lost as entry.
        
        HashMap<Integer, Integer> win = new HashMap<>();
        HashMap<Integer, Integer> lose = new HashMap<>();
        
        for(int[] match : matches){
            win.put(match[0], win.getOrDefault(match[0], 0) + 1);
            lose.put(match[1], lose.getOrDefault(match[1], 0) + 1);
        }
        
        List<Integer> lostexactlyOneMatch = new ArrayList<>();
        List<Integer> lostNoMatch = new ArrayList<>();
        for(int player : lose.keySet()){
            if(lose.get(player) == 1){
                lostexactlyOneMatch.add(player);
            }
        }
        for(int player : win.keySet()){
            if(!lose.containsKey(player)){
                lostNoMatch.add(player);
            }
        }
        Collections.sort(lostNoMatch);
        Collections.sort(lostexactlyOneMatch);
        
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(lostNoMatch);
        ans.add(lostexactlyOneMatch);
        return ans;
    }
}