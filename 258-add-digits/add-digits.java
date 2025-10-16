class Solution {
    public int addDigits(int num) {
        int s=0;
        while(num>=10){
            s=0;
            while(num>0){
                int temp= num%10;
                s+=temp;
                num/=10;
            }
            num=s;
        }
        return num;
    }
}