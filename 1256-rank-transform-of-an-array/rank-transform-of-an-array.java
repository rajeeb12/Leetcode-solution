class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int drr[] = new int[n];
        for(int i = 0; i < n; i++) drr[i] = arr[i];
        Arrays.sort(drr);

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 1;
        for(int i = 0; i < drr.length; i++)
        {
            if(!map.containsKey(drr[i]))
            {
                map.put(drr[i], count);
                count++;
            }
        }
        int ans[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}