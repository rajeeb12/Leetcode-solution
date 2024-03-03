class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int n = score.length;
        int m = score[0].length;
        Arrays.sort(score, (a,b) -> b[k] - a[k]);
        return score;
    }
}