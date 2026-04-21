class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i: nums1) set1.add(i);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(0, new ArrayList<>());
        ans.add(1, new ArrayList<>());
        for(int i: nums2){
            set2.add(i);
        }

        for(int i: set1){
            if(!set2.contains(i)){
                ans.get(0).add(i);
            }
        }
        for(int i: set2){
            if(!set1.contains(i)){
                ans.get(1).add(i);
            }
        }
        return ans;
    }
}