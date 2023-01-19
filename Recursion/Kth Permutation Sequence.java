class Solution {
    public String getPermutation(int n, int k) {
        k=k-1;
        int fact=1;
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=1; i<n; i++)
        {
            fact = fact *i;
            arr.add(i);
        }
        arr.add(n);
        String ans="";
        while(true)
        {
            ans = ans + arr.get(k/fact);// to get the index number of the number from which kth sequence need to be taken # check notebook once if not able to understand
            arr.remove(k/fact);
            if(arr.size()==0)
            {
                break;
            }
            k = k % fact;
            fact =  fact / arr.size(); 
        }
        return ans;
    }
}