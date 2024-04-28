class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = (int)1e9;
        
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int prevDiff = Integer.MAX_VALUE;
                int m = 0;
                boolean isSame = true;
                for(int it = 0 ; it < n; it++)
                {
                    if(it == i || it == j) continue;
                    
                    int diff = nums2[m] - nums1[it];
                    if(prevDiff == Integer.MAX_VALUE || (prevDiff == diff))
                    {
                        prevDiff = diff;
                    }else
                    {
                        isSame = false;
                        break;
                    }
                    m++;
                }
                if(isSame)
                {
                    System.out.println(m);
                    ans = Math.min(ans , prevDiff);
                }
            }
        }
        return ans;
    }
}