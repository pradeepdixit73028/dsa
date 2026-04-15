class Solution {
    public int largestRectangleArea(int[] h) {
        int area=0;
        int n=h.length;
        Stack<Integer> st=new Stack();
        for(int i=0;i<=n;i++){
            int curr=(i==n) ? 0:h[i];
            while(!st.isEmpty() && curr<h[st.peek()]){
                int height=h[st.pop()];
                int width=st.isEmpty() ? i:i-st.peek()-1;
                area=Math.max(area,height*width);
            }
            st.push(i);
        }
        return area;
    }
}