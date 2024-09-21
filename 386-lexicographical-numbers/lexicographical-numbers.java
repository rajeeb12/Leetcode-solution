class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= 9; i++)
        {
            solve(i, ans, n);
        }
        return ans;
    }
    public void solve(int i,List<Integer> ans,int n)
    {
        if(i > n) return;

        ans.add(i);

        for(int j = 0; j <= 9; j++)
        {
            int curnumber = i * 10 + j; // main 
            if(curnumber <= n){
                solve(curnumber, ans, n);
            }else{
                break;
            }
        }
    }
}