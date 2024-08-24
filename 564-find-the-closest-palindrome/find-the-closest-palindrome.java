class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        // case 1 - 10, 100 , 1000..
        if(num <= 10 || (num % 10 == 0 && n.charAt(0)=='1'))
        {
            return ""+ (num - 1);
        }
        // case 2- 11 , 101, 1001
        if(num == 11 || (num % 10 == 1 && n.charAt(0) == '1' &&  Long.parseLong(n.substring(1, len - 1)) == 0))
        {
            return "" + (num - 2);
        }
        
        // all 9's
        if(isAllNines(n)){
            return "" + (num + 2);
        }

        // calculating absolute diff and deciding which no. is smaller on the basis of abs diff
        boolean isEven = len % 2 == 0;
        String firstHalf = isEven ? n.substring(0, len / 2) : n.substring(0, (len / 2) + 1);
        int front = Integer.parseInt(firstHalf);

        long equal = getNumber(front+"" , isEven);
        long diffEqual = Math.abs(num - equal);

        long bigger = getNumber("" +(front + 1), isEven);
        long diffBigger = Math.abs(num - bigger);

        long smaller = getNumber(""+ (front - 1), isEven);
        long diffSmaller = Math.abs(num - smaller);

        long closest = (diffBigger < diffSmaller ? bigger : smaller);
        long minDiff = Math.min(diffBigger, diffSmaller);

        if(diffEqual != 0)
        {
            if(diffEqual == minDiff){
                closest = Math.min(closest, equal);
            }else if(diffEqual < minDiff){
                closest = equal;
            }
        }
        return ""+ closest;
    }
    public long getNumber(String num,boolean isEven){
        StringBuffer back = new StringBuffer(num).reverse();

        String ans = (isEven ? num + back.toString() : num + back.substring(1,back.length())).toString();
        return Long.parseLong(ans);
    }
    public boolean isAllNines(String s){
        for(char c: s.toCharArray()){
            if(c != '9'){
                return false;
            }
        }
        return true;
    }
}