class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long sum = 0;
        int ans = 0;

        for(int i: usageLimits){
            sum += i;
            //required number of elements if I want to create k + 1th group.
            if(sum >= ( ((ans + 1) * (ans + 2)) / 2)){
                ans++;
            }
        }
        return ans;
    }
}