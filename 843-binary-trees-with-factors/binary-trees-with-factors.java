class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        
        HashMap<Integer,Long> map = new HashMap<>();
        int mod = (int)1e9 + 7;

        int n = arr.length;
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            long count = 1;
            for(int j = 0; j < i; j++)
            {
                if(i == j) continue;
                if(arr[i] % arr[j] == 0)
                {
                    int x = arr[i] / arr[j];
                    if(map.containsKey(x))
                    {
                        count = (count % mod + ( map.getOrDefault(x , 1L) * map.getOrDefault(arr[j], 1L) ) % mod) % mod ;
                    }
                }
            }
            map.put(arr[i] , count);
        }
        for(Map.Entry<Integer,Long> e: map.entrySet())
        {
            ans = (int)(ans + e.getValue()) % mod;
        }
        return ans;
    }
}