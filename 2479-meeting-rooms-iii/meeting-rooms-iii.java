class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> aRooms=new PriorityQueue<>();
        for(int i=0;i<n;i++) aRooms.offer(i);
        PriorityQueue<long[]> oRooms=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Long.compare(a[1],b[1]);
            return Long.compare(a[0],b[0]);
        });
        int[] count=new int[n];
        for(int[] meeting:meetings){
            long s=meeting[0];
            long e=meeting[1];
            while(!oRooms.isEmpty() && oRooms.peek()[0]<=s){
                aRooms.offer((int)oRooms.poll()[1]);
            }
            if(!aRooms.isEmpty()){
                int room=aRooms.poll();
                oRooms.offer(new long[]{e,room});
                count[room]++;
            }else{
                long[] curr=oRooms.poll();
                long fTime=curr[0];
                int room=(int)curr[1];
                long newEnd=fTime+(e-s);
                oRooms.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }
        int max=-1,id=-1;
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
                id=i;
            }
        }
        return id;
    }
}