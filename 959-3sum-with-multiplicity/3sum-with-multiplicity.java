class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long map[]= new long[101];
        long mod = (int)1e9 + 7;
        for(int i: arr)
        {
            map[i]++;
        }
        long ans = 0;
        for(int i = 0 ; i <= 100; i++)
        {
            for(int j = i; j <= 100; j++)
            {
                int k = target - i - j;
                if(k > 100 || k < 0) continue;

                if(i == j && j == k)
                {
                    ans = (ans + ( map[i] * (map[i] - 1) * (map[i]-2) ) / 6 ) ; 
                }
                else if(i == j && j != k)
                {
                    ans = (ans + ( map[i] * (map[i]-1)  / 2 )* map[k] ) ;
                }
                else if(i < j && j < k){
                    ans += (map[i] * map[j] * map[k]);
                }
            }
        }
        return (int)(ans % mod);
    }
}