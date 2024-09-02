class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i: chalk){
            sum += i;
        }
        long c = k / sum;
        long temp = c * sum;

        if(k < sum){
            return solve(chalk, k);
        } 
        return solve(chalk,Math.abs(temp - k));
    }
    public int solve(int[] chalk,long k)
    {
        int n = chalk.length;
        for(int i = 0; i < n; i++)
        {
            if(k - chalk[i] < 0) return i;
            k -= chalk[i];
        }
        return n;
    }
}