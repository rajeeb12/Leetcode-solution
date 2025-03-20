class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int inOrder[] = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int p[]: prerequisites){
            inOrder[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(inOrder[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int u = q.poll();
                ans.add(u);

                for(int v: adj.get(u)){
                    inOrder[v]--;

                    if(inOrder[v] == 0){
                        q.add(v);
                    }
                }
            }
        }
        
        if(ans.size() != numCourses) return new int[]{};

        int result[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }

        return result;

    }
}