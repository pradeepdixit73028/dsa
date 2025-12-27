class RandomizedCollection {
    List<Integer> l;
    Map<Integer, Set<Integer>> m;
    public RandomizedCollection(){
        l=new ArrayList<>();
        m=new HashMap<>();
    }
    public boolean insert(int val){
        if(!m.containsKey(val)){
            m.put(val,new HashSet<>());
        }
        m.get(val).add(l.size());
        l.add(val);
        return m.get(val).size()==1;
    }
    public boolean remove(int val){
        if(!m.containsKey(val)||m.get(val).isEmpty()) return false;
        int removeidx=m.get(val).iterator().next();
        m.get(val).remove(removeidx);
        int lastele=l.get(l.size()-1);
        l.set(removeidx,lastele);
        m.get(lastele).add(removeidx);
        m.get(lastele).remove(l.size()-1);
        l.remove(l.size()-1);
        return true;
    }
    public int getRandom(){
        int randomidx=(int)(Math.random()*l.size());
        return l.get(randomidx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */