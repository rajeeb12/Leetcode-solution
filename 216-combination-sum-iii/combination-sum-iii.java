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
        if(cnum > 9) return;

        list.add(cnum);
        solve(cnum + 1, k - 1, target - cnum, list, ans);
        list.remove(list.size() - 1);
        solve(cnum + 1, k , target, list, ans);
    }
}