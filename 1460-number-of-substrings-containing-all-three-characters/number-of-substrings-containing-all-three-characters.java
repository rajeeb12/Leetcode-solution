class Solution {
    public int numberOfSubstrings(String s) {
        int count[] = new int[3];                                                    
        int i = 0, res = 0;
        for(int j = 0; j < s.length(); j++)
        {
            count[s.charAt(j) - 'a']++;
            
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                count[s.charAt(i) - 'a']--;
                i++;
            }

            res += i;
        }
        return res;
    }
}
 