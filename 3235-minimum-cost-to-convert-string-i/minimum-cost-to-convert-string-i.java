class Pair{
    char dest;
    int cost;
    public Pair(char _d,int _c){
        this.dest = _d;
        this.cost = _c;
    }
}
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int adj[][] = new int[26][26];

        for(int i[]: adj) Arrays.fill(i, (int)1e9);

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j) adj[i][j] = 0;
            }
        }

        for(int i = 0; i < n; i++){
            int o = original[i] -'a';
            int c = changed[i] -'a';
            adj[o][c]= Math.min(adj[o][c], cost[i]);
        }

        for(int via = 0; via < 26; via++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][via] + adj[via][j]);
                }
            }
        }

        long ans = 0;

        for(int j = 0; j < source.length() ; j++)
        {
            char s = source.charAt(j);
            char t = target.charAt(j);
            
            if(s == t) continue;
            
            if(adj[s-'a'][t-'a'] == (int)1e9){
                return -1;
            }
            ans += adj[s-'a'][t-'a'];
        }
        return ans;
    }
}