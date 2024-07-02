class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i: nums1) max = Math.max(max, i);
        int hash1[] = new int[max + 1];
        int hash2[] = new int[max + 1]; 
        for(int i = 0; i < nums1.length; i++){
            hash1[nums1[i]]++;
        } 
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] > max) continue;
            hash2[nums2[i]]++;
        }
        ArrayList<Integer> ls = new ArrayList<>();
        for(int  i = 0; i <= max; i++){
            
            if(hash1[i] == 0 || hash2[i] == 0) continue;
            
            int occurences = Math.min(hash1[i], hash2[i]);
            
            for(int j = 0; j < occurences; j++)
            {
                ls.add(i);
            }
        }
        int ans[] = new int[ls.size()];
        int index = 0;
        for(int i = 0; i < ls.size(); i++){
            ans[index++] = ls.get(i);
        }
        return ans;
    }
}