class Solution {
    static int n,m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n=image.length;
        m=image[0].length;
        int temp=image[sr][sc];
        if (temp!=color) dfs(image,sr,sc,color,temp);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int color,int temp){
    	if(sr<0||sr>=n||sc<0||sc>=m||image[sr][sc]!=temp){
			return;
        }
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,temp);
        dfs(image,sr,sc+1,color,temp);
        dfs(image,sr-1,sc,color,temp);
        dfs(image,sr,sc-1,color,temp);
    }
}
