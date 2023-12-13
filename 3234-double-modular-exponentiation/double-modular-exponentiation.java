class Solution {
    public List<Integer> getGoodIndices(int[][] v, int target) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < v.length; i++)
        {
            int a = v[i][0];
            int b = v[i][1];
            int c = v[i][2];
            int d = v[i][3];
            
            int prod1 =1;
            for(int j = 0 ; j < b ; j++)
            {
                prod1 = (prod1 * a) % 10;
            }
            int prod2 = 1;
            for(int j = 0 ; j < c; j++)
            {
                prod2 = (prod1 * prod2 ) % d;
            }
            if(prod2 == target){
                ans.add(i);
            }
        }
        return ans;
    }
    
}