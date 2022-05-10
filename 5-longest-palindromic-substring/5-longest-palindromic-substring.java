class Solution {
    int lo = 0, maxLen = 0;
    String s;
    public String longestPalindrome(String s) {
        
        
        this.s = s;
       if (s.length() < 2)
		return s;
        
         
        // EXPAND AROUND CENTRE
        for(int i = 0; i < s.length() - 1; i++){
            expandAroundCentre(i,i);
            expandAroundCentre(i, i+1);
        }        
        return s.substring(lo, lo + maxLen);   
    }
    
    public void expandAroundCentre(int j, int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
        }
    }
}