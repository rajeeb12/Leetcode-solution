class Solution {
    public int numberOfWays(String corridor) {
        int mod = (int)1e9 + 7;
        int count = 0;
        ArrayList<Integer> storeIndex = new ArrayList<>();

        for(int i = 0 ; i < corridor.length() ; i++){
            char ch = corridor.charAt(i);
            if(ch == 'S'){ 
                storeIndex.add(i);
                count++;
            }
            
        }
        if(count < 2 || count % 2 == 1) return 0;
        
        long ans = 1;
        for(int i = 2 ; i < storeIndex.size(); i +=2)
        {
            ans = (ans * ((storeIndex.get(i) - storeIndex.get(i - 1)) % mod) ) % mod;
        }
        return (int) ans;
    }
}