class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int sum=0;
        int tank=0;
        int start=0;
        for(int i=0;i<n;i++){
            int diff=gas[i]-cost[i];
            sum=sum+diff;
            tank=tank+diff;
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        if(sum>=0) return start;
        return -1;
    }
}