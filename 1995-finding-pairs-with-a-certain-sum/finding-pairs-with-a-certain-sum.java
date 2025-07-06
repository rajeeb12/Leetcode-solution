class FindSumPairs {
    HashMap<Integer,Integer> map2;
    HashMap<Integer,Integer> map1;
    int n1, n2;
    int arr[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        map2 = new HashMap<>();
        map1 = new HashMap<>();
        int index = 0;
        n2 = nums2.length;

        arr = new int[n2];
        
        for(int i : nums1){
            map1.put(i, map1.getOrDefault(i, 0 ) + 1);
        }
        
        for(int i : nums2){
            map2.put(i, map2.getOrDefault(i ,0) + 1);
            arr[index] = i;
            index++;
        }
    }
    
    public void add(int index, int val) {
        int temp = arr[index];
        arr[index] += val;
        map2.put(temp, map2.get(temp) - 1);
        map2.put(arr[index] , map2.getOrDefault(arr[index] ,0) + 1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for(Map.Entry<Integer,Integer> e: map1.entrySet()){
            if(map2.containsKey(tot - e.getKey())){
                ans += e.getValue() * map2.get(tot - e.getKey());
            }
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */