class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int n = nums.size();
        if(n % 2 == 0){
            for(int i = 0; i < n / 2; i++){
                list1.add(nums.get(i));
            }
            for(int i = n/ 2; i < n; i++){
                list2.add(nums.get(i));
            }
        }else{
            for(int i = 0; i <= n / 2; i++){
                list1.add(nums.get(i));
            }
            for(int i = n / 2 + 1; i < n; i++){
                list2.add(nums.get(i));
            }
        }
        int i = list1.size() - 1; 
        int j = list2.size() - 1;
        while(i >= 0 && j >= 0){
            if(list1.get(i) < list2.get(j)){
                list1.remove(i);
                list2.remove(j);
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        return (list1.size() + list2.size() );
    }
}