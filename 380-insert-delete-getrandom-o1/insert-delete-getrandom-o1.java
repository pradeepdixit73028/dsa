class RandomizedSet {
    private List<Integer> v;
    private Map<Integer, Integer> vI;
    public RandomizedSet() {
        this.v = new ArrayList<>();
        this.vI = new HashMap<>();
    }
    public boolean insert(int val){
        if (vI.containsKey(val)) return false;
        vI.put(val,v.size());
        v.add(val);
        return true;
    }
    public boolean remove(int val){
        if(!vI.containsKey(val)) return false;
        int idx=vI.get(val);
        vI.put(v.get(v.size()-1),idx);
        vI.remove(val);
        v.set(idx,v.get(v.size() - 1));
        v.remove(v.size()-1);
        return true;
    }
    public int getRandom(){
        int idx=(int)(Math.random()*v.size());
        return v.get(idx);
    }
}