class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i: nums)
        {
            if(i < 0){
                neg.add(i);
            }else{
                pos.add(i);
            }
        }

        int i = 0, j = 0;
        int index = 0; 
        while(i < pos.size() && j < neg.size())
        {
            if(index % 2 == 0)
            {
                nums[index] = pos.get(i);
                i++;
            }else{
                nums[index] = neg.get(j);
                j++;
            }
            index++;
        }
        while(i < pos.size())
        {
            nums[index] = pos.get(i);
            i++;
            index++;
        }
        while(j < neg.size())
        {
            nums[index] = neg.get(j);
            j++;
            index++;
        }
        return nums;
    }
}