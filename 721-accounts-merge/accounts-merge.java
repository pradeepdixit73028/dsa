class Solution {
    static int component;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> emailtoid=new HashMap<>();
        HashMap<String,String> emailtoname=new HashMap<>();
        int id=0;
        for(List<String> acc:accounts){
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++){
                String email=acc.get(i);
                if(!emailtoid.containsKey(email)){
                    emailtoid.put(email,id++);
                }
                emailtoname.put(email,name);
            }
        }
        component=id;
        int par[] = new int[id];
        int rank[]= new int[id];
        for(int i =0;i<id;i++){
            par[i] =i;
            rank[i] =0;
        }
        for(List<String> acc:accounts){
            if(acc.size()<=2) continue;
            int firstAccid=emailtoid.get(acc.get(1));
            for(int k=2;k<acc.size();k++){
                Rankunion(firstAccid,emailtoid.get(acc.get(k)),par,rank);
            }
        }
        HashMap<Integer,List<String>> grouptoid=new HashMap<>();
        for(String email:emailtoid.keySet()){
            int emailid=emailtoid.get(email);
            int root=find(emailid,par);
            if(!grouptoid.containsKey(root)){
                grouptoid.put(root,new ArrayList<>());
            }
            grouptoid.get(root).add(email);
        }
        List<List<String>> result=new ArrayList<>();
        for(Integer node:grouptoid.keySet()){
            List<String>merge=grouptoid.get(node);
            Collections.sort(merge);
            List<String>ans=new ArrayList<>();
            ans.add(emailtoname.get(merge.get(0)));
            ans.addAll(merge);
            result.add(ans);
        }
        return result;
        
    }
    public boolean  Rankunion(int x, int y, int par[],int rank[]){
        int px = find(x,par);
        int py = find(y,par);
        if(px == py){
            return false;
        }
        if(rank[px] > rank[py]){
            par[py] = px;
        }
        else if(rank[px] < rank[py]){
            par[py] = px;
        }
        else {
            par[px] = py;

            rank[py]++;
        }
        component--;
        return true;
        
    }
    public int find(int x, int par[]){
        if(x==par[x]){
            return x;
        }
        par[x] = find(par[x],par);
        return par[x];
    }
        
    
}