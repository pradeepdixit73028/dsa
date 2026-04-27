class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int num:nums1) set1.add(num);
        for(int num:nums2) set2.add(num);
        int ans1=0;
        for(int i=0;i<nums1.length;i++){
            if(set2.contains(nums1[i])) ans1++;
        }
        int ans2=0;
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i])) ans2++;
        }
        return new int[]{ans1,ans2};
    }
}