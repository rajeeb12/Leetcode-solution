class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String s1 = num1+"";
        String s2 = num2+"";
        String s3 = num3+"";

        if(s1.length() < 4){
            int diff = 4 - s1.length();
            String zero = "";
            for(int i = 0; i < diff; i++){
                zero += "0";
            }
            s1 = zero + s1;
        }
        if(s2.length() < 4){
            int diff = 4 - s2.length();
            String zero = "";
            for(int i = 0; i < diff; i++){
                zero += "0";
            }
            s2 = zero + s2;
        }
        if(s3.length() < 4){
            int diff = 4 - s3.length();
            String zero = "";
            for(int i = 0; i < diff; i++)
            {
                zero += "0";
            }
            s3 = zero + s3;
        }
        String ans = "";
        for(int i = 0; i < 4; i++){
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';
            int c = s3.charAt(i) - '0';

            int min = Math.min(a, Math.min(b , c));
            ans = ans + min;
        }
        return Integer.parseInt(ans);
    }
}