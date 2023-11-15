class Solution {
    public int maximumGroups(int[] grades) {
        int s = grades.length;
        return ( (int) (-1 + Math.sqrt(1 + 8 * s)) / 2);
    }
}