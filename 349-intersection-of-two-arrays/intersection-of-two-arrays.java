class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> tempAns = new HashSet<>();
        for(int i : nums1)
        {
            set1.add(i);
        }
        for(int i: nums2)
        {
            if(set1.contains(i))
            {
                tempAns.add(i);
            }
        }
        int ans[] = new int[tempAns.size()];
        int index = 0;
        for(int i : tempAns)
        {
            ans[index] = i;
            index++;
        } 
        return ans;
    }
}