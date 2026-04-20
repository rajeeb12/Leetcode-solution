class Solution {
    public int largestAltitude(int[] gain) {
        int maxPoint = 0, sum = 0;
        for(int i : gain){
            sum += i;
            maxPoint = Math.max(maxPoint, sum);
        }   
        return maxPoint;
    }
}