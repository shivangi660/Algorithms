class Solution {
    public void reverseString(char[] s) {
        if(s.length == 0)
            return;
        int length = s.length;
        int start = 0,end = length-1;
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}