class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(ls.size() == 0 || nums[i] < nums[ls.get(ls.size() - 1)])
            {
                ls.add(i);
            }else{
                int low = 0, high = ls.size() - 1;
                int pans = -1;
                while(low <= high)
                {
                    int mid = (low + high) >> 1;
                    if(nums[ls.get(mid)] <= nums[i]){
                        pans = ls.get(mid);
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }

                if(pans != -1) ans = Math.max(ans, i - pans);
            }
        }
        return ans;
    }
}