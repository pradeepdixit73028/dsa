class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        int space=0;
        for(char ch:moves.toCharArray()){
            if(ch=='L') left++;
            else if(ch=='R') right++;
            else space++;

        }
        if(left==right){
            return space;
        }else{
            return Math.abs(left-right)+space;
        }
    }
}