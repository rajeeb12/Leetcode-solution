class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        int count=0;
        
        for(int i=1; i<=n; i++)
        {
            count += countBit(i);
        }
        return count; 
    }
    // this fn will count the number of ones in the bit set
    public static int countBit(int n)
    {
        if(n <=0)
        {
            return 0;
        }
        
        return (n % 2 == 0 ? 0 : 1) + countBit(n/2);
    }
}
TC- O(nlongn)
// method -2
class Solution{
    
    public static int countSetBits(int n){
        if(n==0)
            return 0;
        int x= findLargestPower(n);
        
        int count = ((1 << x-1) *x)  + (n-(1 << x) +1) + countSetBits(n - (1 << x));
                   //bits upto 2^x  + msb2^xton +rest , (1<<x) -2^x
        return count;
        
    }
    public static int findLargestPower(int n)
    {
        int i=0;
        while((1<<i) <=n)
        {
            i++;
        }
        
        return i-1;
    }
}
TC- O(n*x)