class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int inorder[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]: prerequisites){
            adj.get(i[1]).add(i[0]);
            inorder[i[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inorder[i] == 0) q.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        
        int index = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                temp.add(node);
                
                for(int adjNode: adj.get(node)){
                    inorder[adjNode]--;
                    if(inorder[adjNode] == 0){
                        q.add(adjNode);
                    }
                }
            }
        }
        
        if(temp.size() != numCourses) return new int[]{};

        int res[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = temp.get(i);
        }
        return res;
    }
}