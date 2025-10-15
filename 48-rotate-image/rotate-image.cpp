class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int p = 0;
        int n = matrix.size() - 1;
        int q = n;
        for(int i = 0; i <= n; i++){
            for(int j = i; j<= n; j++){
                swap(matrix[i][j], matrix[j][i]);
            }
        }
        for(int i = 0; i <= n; i++){
            for(int j = 0; j<= n/2; j++){
                swap(matrix[i][p], matrix[i][q]);
                p++;
                q--; 
            }
            p = 0;
            q = n;
        }
    }
};