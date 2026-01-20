import java.util.*;

public class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int v = nums.get(i);
            int found = -1;
            for (int x = 0; x <= v; x++) {
                if ((x | (x + 1)) == v) {
                    found = x;
                    break;
                }
            }
            ans[i] = found;
        }
        return ans;
    }
}