class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        solve(1, k , n , new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int cnum, int k , int target, List<Integer> list,List<List<Integer>> ans){
        if(k == 0){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        for(int i = cnum; i < 10; i++){
            if(i > target || k <= 0) break;
            list.add(i);
            solve(i + 1, k - 1, target - i, list, ans);
            list.remove(list.size() - 1);
        }
    }
}