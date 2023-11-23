class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int m = l.length;
        // TC - O(m * n)
        for(int i = 0 ; i < m ; i++){

            HashSet<Integer> set = new HashSet<>();
            int max = -(int)1e9, min = (int)1e9;

            for(int index = l[i] ; index <= r[i] ; index++){
                set.add(nums[index]);
                max = Math.max(max, nums[index]);
                min = Math.min(min, nums[index]);
            }
            boolean flag = true;
            int n = r[i] - l[i] ; // (n-1)
            // tn = a + (n-1)*d
            if((max - min) % n != 0)
            {
                ans.add(false);
                continue;
            }
            int diff = (max - min) / n;

            int cur = min; // a
            while(cur < max){
                if(!set.contains(cur)){
                    flag = false;
                    break;
                }
                cur += diff;
            }
            ans.add(flag);
        }
        return ans;
    }
}
// using sort TC - O(m * nlogn)
// int n = l.length; 
// for(int i = 0 ; i < n ; i++){
//    ArrayList<Integer> temp = new ArrayList<>();

//    for(int index = l[i] ; index <= r[i] ; index++){
//        temp.add(nums[index]);
//    }
//    Collections.sort(temp);
            
//    int diff= temp.get(0) - temp.get(1);
//    boolean flag = true;
//    for(int index = 1 ; index < temp.size()-1 ; index++){
//    if(temp.get(index) - temp.get(index + 1) != diff){
//          flag = false;
//          break;
//    }
//   }
//  ans.add(flag);
// }
// return ans;