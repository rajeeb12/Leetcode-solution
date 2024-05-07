class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
       HashMap<String, Integer> map = new HashMap<>();
       int n = word.length();
       for(int i = 0; i <= n - k; i += k)
       {
        String substr = word.substring(i, i + k); 
        map.put(substr, map.getOrDefault(substr, 0 ) + 1);
       }
       int maxFreq = 0;

       for(Map.Entry<String, Integer> e: map.entrySet()){
        int value = e.getValue();
        maxFreq = Math.max(maxFreq, value);
       }
       
       return (maxFreq == 1 ? (n - k) / k : (n - (k * maxFreq)) / k );
    }
}