class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int count = 0;
        int max = 0;
        HashSet<String> set = new HashSet<>();
        for(int j: arr2)
        {
            String s = Integer.toString(j);
            for(int i = 0 ; i < s.length(); i++)
            {
                set.add(s.substring(0, i + 1));
            }
        }
        for(int i: arr1)
        {
            String s = Integer.toString(i);
            
            for(int j = 0 ; j < s.length(); j++)
            {
                String substr = s.substring(0, j + 1);
                if(set.contains(substr))
                {
                    max = Math.max(substr.length(), max);
                }
            }
            
        }
        return max;
    }
}