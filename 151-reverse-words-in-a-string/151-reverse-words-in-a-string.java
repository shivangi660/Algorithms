class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();
        String[] input = s.split("\\s+");
        Stack<String> st = new Stack<String>();
        for(String s1 : input){
            if(!s1.equals(" ")){
                st.push(s1);
            }
        }
        
        System.out.println(st.toString());
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            System.out.println(st.peek());
            sb.append(st.pop());
            sb.append(" ");
        }
        
        String ans = sb.toString();
        return ans.substring(0,ans.length() - 1);
        
        // Follow up
        // inplace
        // 1. Reverse the entire string after removing leading and trailing spaces
        // 2. Remove the extra spaces in between, 
        // https://leetcode.com/problems/reverse-words-in-a-string/discuss/47720/Clean-Java-two-pointers-solution-(no-trim(-)-no-split(-)-no-StringBuilder)
    }
}