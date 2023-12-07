class Solution {
    public int numPairsDivisibleBy60(int[] time) {
       int count = 0;
       int arr[]= new int[60];
       for(int t: time)
       {
           int rem = (t % 60);
           if(rem == 0)
           {
               count += arr[rem];
           }
           else{
               count += arr[(60 - rem)];
           }
           arr[rem]++;
       } 
       return count;
    }
}