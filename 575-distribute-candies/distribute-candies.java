class Solution {
    public int distributeCandies(int[] arr) {
        int n=arr.length;
        Set<Integer> hs=new HashSet<>();
        for(int num:arr) hs.add(num);
        int type=hs.size();
        int avl=n/2;
        return (avl<type) ? avl:type;
    }
}