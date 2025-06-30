class Pair{
    int index;
    int count;
    public Pair(int _index,int _count){
        this.index = _index;
        this.count= _count;
    }
}
class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Pair> right = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(right.containsKey(nums[i])){
                Pair temp = right.get(nums[i]);
                int count = temp.count;
                int index = temp.index;

                right.put(nums[i], new Pair(Math.min(index, i) , count + 1));
            }
            else{
                right.put(nums[i] , new Pair(i, 1));
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(right.containsKey(nums[i] - 1)){
                ans = Math.max(ans, right.get(nums[i]).count + right.get(nums[i] -  1).count);
            }
        }
        return ans;
    }
}