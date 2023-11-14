class Solution {
    public int countPalindromicSubsequence(String s) {
        int length = s.length();
        int left_idx[]= new int[26];
        int right_idx[]= new int[26];

        Arrays.fill(left_idx, Integer.MAX_VALUE);
        Arrays.fill(right_idx, Integer.MIN_VALUE);
        int ans = 0;
        for(int i = 0 ; i < length ; i++){
            int ascii_ch = s.charAt(i) - 'a'; // ascii value
            // Getting left most index and right most index for that character
            left_idx[ascii_ch] = Math.min(left_idx[ascii_ch], i);
            right_idx[ascii_ch] = Math.max(right_idx[ascii_ch], i);
        }

        for(int i = 0; i < 26 ; i++){
            if(left_idx[i] == Integer.MAX_VALUE ) continue;
            int left = left_idx[i];
            int right = right_idx[i];

            //Storing unique characters count between left most index and right most index    
            HashSet<Character> unique = new HashSet<>();
            for(int index = left + 1; index <= right - 1; index++){
                unique.add(s.charAt(index));
            }
            ans += unique.size();
        }
        return ans;
        
    }
}