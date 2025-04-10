class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = (start - 1)+"";
        String finishStr = finish+"";

        return solve(finishStr, s, limit) - solve(startStr, s, limit); 
    }
    public long solve(String str, String suffix, int limit){
        if(str.length() < suffix.length()) return 0;
        long count = 0;

        int remainLen = str.length() - suffix.length();
        String remStr = str.substring(str.length() - suffix.length());

        for(int i = 0; i < remainLen; i++){
            int digit = str.charAt(i) -'0';
            if(digit <= limit){
                count += digit * Math.pow(limit + 1, remainLen - i - 1);
            }else{
                count += Math.pow(limit + 1, remainLen - i);
                return count;
            }
        }
        if(remStr.compareTo(suffix) >= 0){
            count++;
        }
        return count;
    }
}