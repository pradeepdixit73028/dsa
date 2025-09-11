class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int n=nums.size();
        vector<int> p(n,0);
        p[0]=(nums[0]%k+k)%k;
        for(int i=1;i<n;i++){
            p[i]=((p[i-1]+nums[i])%k+k)%k;
        }
        unordered_map<int,int> m;
        int count=0;
        for(int i=0;i<n;i++){
            if(p[i]==0){
                count++;
            }
            if(m.find(p[i])!=m.end()){
                count+=m[p[i]];
            }
            m[p[i]]++;
        }
        return count;
    }
};