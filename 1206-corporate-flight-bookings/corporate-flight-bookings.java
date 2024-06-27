class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];

        for(int i[]: bookings)
        {
            int start = i[0];
            int end = i[1];
            int value = i[2];
            for(int j = start - 1; j < end; j++){
                ans[j] += value;
            }
        }
        return ans;
    }
}