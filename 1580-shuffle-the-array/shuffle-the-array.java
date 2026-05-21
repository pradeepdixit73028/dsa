class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] newn=new int[2*n];
        int i=0;
        int j=0;
        int k=n;
        while(i<2*n){
            newn[i]=nums[j];
            j++;
            newn[i+1]=nums[k];
            k++;
            i=i+2;
        }
        return newn;
    }
}