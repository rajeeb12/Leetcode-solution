class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, ArrayList<Integer>> map= new TreeMap<>();
        int n = nums.size();
        int totalElement = 0;
        for(int i = n-1 ; i >= 0; i--){
            int m = nums.get(i).size();
            for(int j = 0 ; j < m ; j++){
                int sumOfindexes = i + j;

                if(!map.containsKey(sumOfindexes)){
                    map.put(sumOfindexes, new ArrayList<>());
                }
                map.get(sumOfindexes).add(nums.get(i).get(j));
            }
            totalElement += m;
        }
        int index = 0;
        int ans[]= new int[totalElement];
        for(ArrayList<Integer> item: map.values()){
            for(int el: item){
                ans[index++] = el;
            }
        }
        return ans;
    }
}