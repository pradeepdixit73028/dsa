class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> a;
        int i=0,j=0;
        int ans=0;
        while(j<s.size()){
            if(a.find(s[j])!=a.end()){
                ans=max(ans,j-i);
                while(s[i]!=s[j]){
                    a.erase(s[i]);
                    i++;
                }
                i++;
            }
            a.insert(s[j]);
            j++;
        }
        ans=max(ans,j-i);
        return ans;
    }
};