class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        Queue<Integer> queue=new LinkedList<>();
        int src=0;
		queue.add(src);
		visited[src]=true;
		while(!queue.isEmpty()){
            int curr=queue.poll();
    		for(int x:rooms.get(curr)){
    		    if(!visited[x]){
            		visited[x]=true;                    			
            		queue.add(x);
            	}
        	}
        }
        for(int i=0;i<rooms.size();i++){
            if(visited[i]!=true) return false;
        }
        return true;
    }
}