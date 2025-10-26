class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int ans = 0;
        for(char c:s.toCharArray()) {
            if(c == '+') {
                ans += sign*num;
                num = 0;
                sign = 1;
            } else if(c == '-') {
                ans += sign*num;
                num= 0;
                sign= -1;
            } else if(c == '(') {
                stack.add(ans);
                stack.add(sign);
                ans = 0;
                sign = 1;
            } else if(c == ')') {
                ans += sign*num;
                num = 0;
                ans *= stack.pop();
                ans += stack.pop();
            } else if(c != ' ') {
                num = num*10+(c-'0');
            }
        }
        if(num!=0) ans+= sign*num;
        return ans;
    }
}