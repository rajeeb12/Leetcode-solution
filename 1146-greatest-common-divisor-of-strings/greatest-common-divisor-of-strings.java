class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int size1 = str1.length();
        int size2 = str2.length();
        String ts1 = str1 + str2;
        String ts2 = str2 + str1;

        if(!ts1.equals(ts2)) return"";

        return str1.substring(0,gcd(size1,size2));
    }
    public int gcd(int n,int m)
    {
        if(n == m) return n;

        if(n > m) return gcd(n-m, m);
        return gcd(n,m-n);
    }
}