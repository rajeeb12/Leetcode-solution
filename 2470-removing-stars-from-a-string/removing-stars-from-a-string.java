class Solution {
    public String removeStars(String s) {
        StringBuilder sb= new StringBuilder();

        for(char ch: s.toCharArray())
        {
            if(ch == '*')
            {
                if(sb.length() == 0) continue;
                else{
                    sb.delete(sb.length()-1,sb.length());
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}