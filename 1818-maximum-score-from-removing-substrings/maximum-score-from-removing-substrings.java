class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int max = Math.max(x,y);
        int min = Math.min(x,y);
        String maxstr = (x > y ? "ab" : "ba");
        String minstr = (x > y ? "ba" : "ab");
        int ans = 0;

        String s1 = removeString(s, maxstr);
        int temp1 = (n - s1.length()) / 2;
        ans = temp1 * max;

        String s2 = removeString(s1, minstr);
        int temp2 = (s1.length() - s2.length()) / 2;
        ans += temp2 * min;
        
        return ans;
    }
    public String removeString(String s,String maxstr){
        StringBuilder str = new StringBuilder();
        int i = 0;

        for(int j = 0; j < s.length(); j++){
            str.append(s.charAt(j));
            i++;

            if(i >= 2 && str.charAt(i - 2) == maxstr.charAt(0) && str.charAt(i - 1) == maxstr.charAt(1)){
                str.delete(i - 2, i);
                i -= 2;
            }
        }
        System.out.print(str+" ");
        return str.toString();
    }
}