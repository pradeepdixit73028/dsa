class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<n && nums[i]<0){
            st.push(Math.abs(nums[i]));
            i++;
        }
        int[] ans=new int[n];
        int j=0;
        while(!st.isEmpty() && i<n){
            if(st.peek()<nums[i]){
                int ele=st.pop();
                ans[j++]=ele*ele;
            }else{
                ans[j++]=nums[i]*nums[i];
                i++;
            }
        }
        while(!st.isEmpty()){
            int ele=st.pop();
            ans[j++]=ele*ele;
        }while(i<n){
            ans[j++]=nums[i]*nums[i];
            i++;
        }
        return ans;


    }
}