class Solution {
public:
    vector<int> findAnagrams(string txt, string pat) {
        if(pat.size()>txt.size()) return {};
        vector<int> v1(26,0);
        for(int i=0;i<pat.size();i++){
            v1[pat[i]-'a']++;
        }
        vector<int> ans;
        vector<int> v2(26,0);
        for(int i=0;i<pat.size();i++){
            v2[txt[i]-'a']++;
        }
        if(v1==v2) ans.push_back(0);
        for(int i=pat.size();i<txt.size();i++){
            v2[txt[i]-'a']++;
            v2[txt[i-pat.size()]-'a']--;
            if(v1==v2) ans.push_back(i-pat.size()+1);
        }
        return ans;
    }
};