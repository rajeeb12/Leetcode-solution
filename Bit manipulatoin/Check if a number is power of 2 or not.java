// checking the right most bit set and doing this operation if the res == n the  the number is power of 2
class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        if(n==0) return false;
        return((n & (~(n-1))) == n);
    }
}
//  Brian Kernighan’s algorithm:
class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        if(n==0) return false;
        return((n & (n-1)) == 0);
    }
    
}
//brute
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        long i=0;
        while(true)
        {
            long num = (1 << i); 
            if(num > n) break;
            
            if( num == n)
            {
                return true;
            }
            i++;
        }
        return false;
        
    }
    
}