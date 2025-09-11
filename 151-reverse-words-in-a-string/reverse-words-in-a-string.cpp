class Solution {
public:
    string reverseWords(string s) {
        int i=0;
        string ans="";
        while(i<s.size()){
            while(i<s.size() && s[i]==' ') i++;
            string a="";
            if(i==s.size()) break;
            while(i<s.size() && s[i]!=' '){
                a+=s[i];
                i++;
            }
            if(ans.size()==0){
                ans=a;
            }
            else ans=a+' '+ans;
        }
        return ans;
    }
};