class Solution {
    public int pivotInteger(int n) {
        int arr[] = new int[n];
        arr[0] = 1;
        for(int i = 1 ; i < n ; i++)
        {
            arr[i] = arr[i - 1] + (i + 1); 
        }
        for(int i = 0; i < n; i++)
        {
            int val1 = arr[i];
            int val2 = arr[n - 1] - val1 + (i + 1);
            if(val1 == val2)
            {
                return i + 1;
            }
        }
        return -1;
    }
}