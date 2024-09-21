class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 1; i <= n; i++){
            solve(i,set, ans, n);
        }
        return ans;
    }
    public void solve(int i,HashSet<Integer> set,List<Integer> ans,int n){
        if(i > n) return;

        if(!set.contains(i) && i <= n){
            set.add(i);
            ans.add(i);
        }

        for(int j = i * 10 ; j < (i * 10) + 10; j++)
        {
            solve(j, set, ans, n);
        }
    }
}