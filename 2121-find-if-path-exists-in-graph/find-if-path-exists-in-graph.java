class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited=new boolean[n];
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
		}
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
		    adj.get(v).add(u);
        }
		Queue<Integer> queue=new LinkedList<>();
		queue.add(source);
		visited[source]=true;
		
		while(!queue.isEmpty()){
            int curr=queue.poll();
    		for(int x:adj.get(curr)){
    		    if(!visited[x]){
            		visited[x]=true;                    			
            		queue.add(x);
            	}
        	}
        }
    	return visited[destination];
	}
}