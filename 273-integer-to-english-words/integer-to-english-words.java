class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String ans = solve(num,0);
        return ans.substring(0, ans.length() - 1);
    }
    public String solve(int num,int section)
    {
        String ones[] = {"","One", "Two","Three" ,"Four","Five","Six","Seven","Eight","Nine"};
        String beforeTwenty[] = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String tens[] ={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String sect[] = {"","Thousand ","Million ","Billion "};

        if(num == 0) return "";

        String ans ="";

        int temp = num % 1000;
        if(temp > 99)
        {
            ans = ones[temp / 100] + " Hundred ";
        }
        temp = temp % 100;
        if(temp > 9 && temp < 20){
            ans = ans + beforeTwenty[temp % 10]+" ";
        }else{
            if(temp >= 20){
                ans =ans + tens[temp / 10]+" ";
            }
            temp = temp % 10;
            if(temp > 0){
                ans =ans+ones[temp]+" ";
            }
        }
        
        ans = solve(num / 1000, section + 1)+ ans + (ans.length() == 0 ? "" : sect[section]);

        return ans;
    }
}