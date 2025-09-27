class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int p1 = 0, p2 = 0,m = nums1.size(),n = nums2.size();
        vector<int> c(m+n);
        for(int i = 0; i < m+n; i++){
            if(p1==m) c[i] = nums2[p2++];
            else if(p2==n) c[i] = nums1[p1++];
            else if(nums1[p1]<nums2[p2]){
                c[i] = nums1[p1];
                p1++;
            }
            else{
                c[i] = nums2[p2];
                p2++;
            }
        }
        
        if (c.size()%2==1) return c[(m+n)/2];
        else return (c[(m+n-1)/2]+c[(m+n+1)/2])/2.0;
    }
};