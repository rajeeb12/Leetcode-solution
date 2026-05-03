class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        if(s.length() != goal.length()) return false;
        HashSet<String> set = new HashSet<>();
        set.add(s);

        for(int i = 0; i < s.length(); i++){
            String substr = s.substring(1, s.length());
            s = substr + s.charAt(0);
            set.add(s);
        }
        if(set.contains(goal)) return true;
        return false;
    }
}