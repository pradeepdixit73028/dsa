class Solution {
    public int maxRepeating(String s, String w) {
        int count = 0;
        String r= w;
        while (s.contains(r)){
            count++;
            r += w;
        }

        return count;
    }
}