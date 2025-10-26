class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while (!visit.contains(n)) {
            visit.add(n);
            n = nextnum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int nextnum(int n) {
        int a = 0;
        while (n>0) {
            int d = n%10;
            a += d*d;
            n = n/10;
        }
        return a;
    }
}