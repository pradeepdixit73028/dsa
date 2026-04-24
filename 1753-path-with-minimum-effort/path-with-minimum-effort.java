class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dirn={{0,1},{0,-1},{-1,0},{1,0}};
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        int[][] dist=new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0]=0;
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];
            int s=curr[2];
            if(i==n-1 && j==m-1) return s;
            for(int[] d:dirn){
                int r=i+d[0],c=j+d[1];
                if(r>=0 && c>=0 && r<n && c<m){
                    int news=Math.max(s,Math.abs(heights[r][c]-heights[i][j]));
                    if(news<dist[r][c]){
                        dist[r][c]=news;
                        q.offer(new int[]{r, c, news});
                    }
                }
            }
        }
        return 0;
    }
}