class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char arr[] = s.toCharArray();
        char brr[] = t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(brr);

        for(int i = 0; i < s.length(); i++){
            if(arr[i] != brr[i]) return false;
        }
        return true;
    }
}