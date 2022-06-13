
class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0)
            return 0;
        int ans = 0, sign = 1,index = 0;
        while(index < s.length() && s.charAt(index) == ' '){
            index++;
        }
        if(index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            if(s.charAt(index) == '-')
                sign = -1;
            index++;
            } 
        System.out.println(" sign = " +sign);
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)){
                return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            }
            index++;
            ans = ans * 10 + digit;
        }
        return ans*sign;
    }
}
// Check in if the first character isDigit
// if it is sign assign it to the sign variable
// else consider it as digit. add it into the list and before returning the value convert the string to digit by reading from the end
// Space complexity will be O(length of digit).
// this can be reduced by each time digit is read, multiply this value by 10 and add the digit which is read
// need to check if the value is in the bounds by checking Integer.MaxVAlue