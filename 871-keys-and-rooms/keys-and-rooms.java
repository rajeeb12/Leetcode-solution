class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int keys = q.poll();
                for(int j = 0; j < rooms.get(keys).size(); j++){
                    int room = rooms.get(keys).get(j);
                    if(!visited[room]){
                        q.add(room);
                        visited[room] = true;
                    }
                }
            }
        }
        for(boolean i: visited){
            if(!i) return false;
        }
        return true;
    }
}