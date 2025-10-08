/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* f(vector<int>& in, vector<int>& post,int a,int b,int c,int d){
        if(b<a || d<c) return NULL;
        TreeNode* temp=new TreeNode(post[d]);
        if(b==a) return temp;
        int i=a,x=0;
        while(in[i]!=post[d]){
            x++;
            i++;
        }
        temp->left=f(in,post,a,i-1,c,c+x-1);
        temp->right=f(in,post,i+1,b,c+x,d-1);
        return temp;
    }
    TreeNode* buildTree(vector<int>& in, vector<int>& post) {
        return f(in,post,0,in.size()-1,0,post.size()-1);
    }
};