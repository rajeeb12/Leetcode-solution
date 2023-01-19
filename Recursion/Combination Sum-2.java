//Given a collection of candidate numbers (candidates)
// and a target number (target),find all unique combinations in candidates where the candidate numbers sum to target.
class Solution {
    public static void solution(int index,int[] arr,int target,List<List<Integer>> res,List<Integer> ds)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index; i<arr.length; i++)
        {
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            
            ds.add(arr[i]);
            solution(i+1, arr, target-arr[i], res,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(candidates);
        solution(0,candidates,target,res,new ArrayList<>());
        return res;
    }
}