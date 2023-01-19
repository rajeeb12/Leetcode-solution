// approach-1
class Solution {
    public static void solution(List<Integer> ds,boolean[] check,List<List<Integer>> res,int[] nums)
    {
        if(ds.size()==nums.length)
        {
            res.add(new ArrayList<>(ds));
        }
        
        for(int i=0; i < nums.length; i++)
        {
            if(!check[i])
            {
                ds.add(nums[i]);
                check[i]=true;
                solution(ds,check,res,nums);
                ds.remove(ds.size()-1);
                check[i]= false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        boolean[] check= new boolean[nums.length];
        solution(ds,check,res,nums);
        
        return res;
    }
    
}
// approach-2
class Solution {
    public static void solution(int index,int[] nums,List<List<Integer>> res)
    {
        if(index==nums.length)
        {
            List<Integer> ds= new ArrayList<>();
            for(int i=0; i<nums.length; i++)
            {
                ds.add(nums[i]);
            }
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i= index; i < nums.length; i++)
        {
            swap(i,index,nums);
            solution(index+1,nums,res);
            swap(i,index,nums);
        }
    }
    public static void swap(int index1, int index2, int[] nums)
    {
        int temp= nums[index1];
        nums[index1]= nums[index2];
        nums[index2]= temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        solution(0,nums,res);
        return res;
    }
}