class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int n = l.length; 
        for(int i = 0 ; i < n ; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int index = l[i] ; index <= r[i] ; index++){
                temp.add(nums[index]);
            }
            Collections.sort(temp);
            
            int diff= temp.get(0) - temp.get(1);
            boolean flag = true;
            for(int index = 1 ; index < temp.size()-1 ; index++){
                if(temp.get(index) - temp.get(index + 1) != diff){
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}