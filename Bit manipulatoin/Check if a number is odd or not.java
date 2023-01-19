class Solution{
    static String oddEven(int N){
        if((N & (1 << 0))==1)
        {
            return "odd";
        }
        else
            return "even";
    }
}