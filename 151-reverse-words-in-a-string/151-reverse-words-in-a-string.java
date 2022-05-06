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
    }
}