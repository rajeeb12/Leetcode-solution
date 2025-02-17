class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = (n * 2) - 1;
        int ans[] = new int[size];
        boolean used[] = new boolean[n + 1];
        solve(0, ans, used, n);
        return ans;
    }
    public boolean solve(int index,int ans[],boolean used[],int n){

        while(index < ans.length && ans[index] != 0) index++;

        if(index == ans.length) return true;

        for(int num = n; num >= 1; num--){
            if(used[num]) continue;

            if(num == 1){
                ans[index] = 1;
                used[num] = true;
                if(solve(index + 1, ans, used, n)) return true;
                ans[index] = 0;
                used[num] = false; 
            }else{
                if(index + num < ans.length && ans[index + num] == 0)
                {
                    ans[index] = num;
                    ans[index + num] = num;
                    used[num] = true;
                    if(solve(index + 1, ans, used, n)){
                        return true;  
                    }else{
                        ans[index] = 0;
                        ans[index + num] = 0;
                        used[num] = false;
                    }
                }
            }
        }
        return false;
    }
    
}