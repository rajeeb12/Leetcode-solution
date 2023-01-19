//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers sum to target.
//You may return the combinations in any order.
//pick and not pick
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp=  new ArrayList<>();
        solution(0,candidates,target,ans,temp);
        return ans;
    }
    public static void solution(int index,int[] cand,int target,List<List<Integer>> ans,List<Integer> temp)
    {
        if(index == cand.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(cand[index] <= target)
        {
            temp.add(cand[index]);
            solution(index,cand,target-cand[index],ans,temp);
            temp.remove(temp.size()-1);
        }   
        solution(index+1,cand,target,ans,temp);
    }
}