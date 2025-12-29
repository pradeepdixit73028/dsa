class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s:allowed){
            String key=s.substring(0, 2);
            char top=s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }
        return buildPyramid(bottom);
    }
    private boolean buildPyramid(String bottom){
        if(bottom.length()==1){
            return true;
        }
        List<String> nextLevels = new ArrayList<>();
        generateNextLevels(bottom,0,new StringBuilder(),nextLevels);
        for(String next:nextLevels){
            if(buildPyramid(next)){
                return true;
            }
        }
        return false;
    }

    private void generateNextLevels(String bottom, int index,
                                    StringBuilder current,
                                    List<String> result) {

        // If one full level is built
        if (index == bottom.length() - 1) {
            result.add(current.toString());
            return;
        }

        String key = bottom.substring(index, index + 2);

        // If no allowed transition → stop
        if (!map.containsKey(key)) {
            return;
        }

        // Try all possible top blocks
        for (char c : map.get(key)) {
            current.append(c);
            generateNextLevels(bottom, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}