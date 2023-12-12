class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ans = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }else if(nums2[j] < nums1[i])
            {
                j++;
            }
            else{
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }
        int res[]= new int[ans.size()];
        int index = 0;
        for(int item: ans)
        {
            res[index++] = item;
        }
        return res;
    }
}