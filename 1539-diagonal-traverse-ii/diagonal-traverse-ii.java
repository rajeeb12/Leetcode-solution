class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0});
        ArrayList<Integer> list= new ArrayList<>();
        int n = nums.size();

        while(!q.isEmpty())
        {
            int temp[]= q.poll();
            int x = temp[0];
            int y = temp[1];
            list.add(nums.get(x).get(y));

            if(y == 0 && x + 1 < n){
                q.add(new int[]{x + 1, y});
            }
           
            if(y + 1 < nums.get(x).size()) q.add(new int[]{x , y + 1});
        }
        int ans[]= new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }
}