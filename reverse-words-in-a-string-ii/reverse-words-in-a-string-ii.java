class Solution {
    public void reverseWords(char[] s) {
        // 2 Steps
        // 1. Reverse the input string s.
        // 2. Reverse individual words
        
        reverseString(s,0, s.length - 1);
        reverseWord(s);
    }
    
    public void reverseWord(char[] s){
        int start = 0, end = 0;
        // this condition will ensure that we reverse the string till the end of the char array.
        while(start < s.length){
            while(end < s.length && s[end] != ' '){
                end++;
            }
            reverseString(s, start, end - 1);
            start = end+1;
            ++end;
        }
    }
    
    public void reverseString(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
}