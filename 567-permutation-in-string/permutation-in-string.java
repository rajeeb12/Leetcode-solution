class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int map1[]= new int[26];
        int map2[]= new int[26];

        for(int i = 0 ; i < s1.length(); i++)
        {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(map1, map2)) return true;
        int left = 0;
        int right = s1.length();
        int n = s2.length();
        while(right < n)
        {
            map2[s2.charAt(left) - 'a']--;
            left++;

            map2[s2.charAt(right) -'a']++;
            right++;

            if(Arrays.equals(map1, map2)) return true;
        }
        return false;
    }
}