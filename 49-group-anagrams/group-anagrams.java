class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        for(String s:strs){
            char[] ch= s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            hm.putIfAbsent(key,new ArrayList());
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}