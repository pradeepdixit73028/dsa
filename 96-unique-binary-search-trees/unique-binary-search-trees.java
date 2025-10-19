class Solution {
    public int numTrees(int n) {
        int[] ut = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ut[i] = 1;
        }

        for (int no=2; no<=n; no++) {
            int total= 0;
            for (int r=1; r<= no; r++) {
                total += ut[r - 1] * ut[no - r];
            }
            ut[no] = total;
        }

        return ut[n];        
    }
}