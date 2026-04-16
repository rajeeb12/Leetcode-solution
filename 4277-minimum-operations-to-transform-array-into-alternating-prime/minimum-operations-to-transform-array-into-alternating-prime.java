class Solution {
    int size = 1000001;
    public int minOperations(int[] nums) {
        int ans = 0;
        boolean seive[] = getPrime();
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                while(seive[nums[i]++]){
                    ans++;
                }
            }else{
                while(!seive[nums[i]++]) ans++;
            }
        }
        return ans;
    }
    public boolean[] getPrime(){
        boolean seive[] = new boolean[size];
        seive[0] = seive[1] = true;

        for(int i = 2; i <= 316; i++){
            if(seive[i]) continue;
            for(int j = i * i; j < size; j += i){
                seive[j] = true;
            }
        }
        return seive;
    }
}