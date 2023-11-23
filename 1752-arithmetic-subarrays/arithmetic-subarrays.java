class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean>  res= new ArrayList<>();
        
        int m=l.length;
        
        for(int i=0; i<m; i++)
        {
            int a1=l[i];
            int a2=r[i];
            ArrayList<Integer> list= new ArrayList<>();
            for(int j=a1; j<=a2; j++)
            {
                list.add(nums[j]);
            }
            res.add(check(list));
        }
        return res;
    }
    public static boolean check(ArrayList<Integer> list)
    {
        Collections.sort(list);
        int c_diff= list.get(0)-list.get(1);
        boolean flag =true;
        for(int i=1; i<list.size(); i++)
        {
            int diff= list.get(i-1)-list.get(i);
            if(diff!=c_diff)
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
}