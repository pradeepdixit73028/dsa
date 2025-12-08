class Solution {
    public int countTriples(int n) {
        int count =0;
        while(n!=0){
        for(int b=1;b<n;b++){
            int c2 = n*n - b*b;
            int c =(int)Math.sqrt(c2);
            if(c<=n && c*c+b*b == n*n ){
                count ++;
            }
        }
        n--;
        }
        return count; 
    }
}