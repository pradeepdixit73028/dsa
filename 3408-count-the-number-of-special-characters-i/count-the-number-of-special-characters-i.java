class Solution {
    public int numberOfSpecialChars(String word) {
        ArrayList<Character> small=new ArrayList<>();
        Set<Character> hs=new HashSet<>();
        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                small.add(ch);
            }else{
                hs.add(ch);
            }
        }
        int count=0;
        for(char ch:small){
            char cap=Character.toUpperCase(ch);
            if(hs.contains(cap)){
                count++;
                hs.remove(cap);
            }
        }
        return count;
    }
}