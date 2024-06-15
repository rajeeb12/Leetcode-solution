class DetectSquares {
    int a[][];
    List<int[]> list;
    public DetectSquares() {
        a = new int[1001][1001];
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        a[point[0]][point[1]] += 1;
        list.add(new int[]{point[0], point[1]});
    }
    
    public int count(int[] point) {
        int x1 = point[0] , y1 = point[1];
        int ans = 0;
        for(int p3[]: list){
            if(Math.abs(x1 - p3[0]) == 0 || Math.abs(x1 - p3[0]) != Math.abs(y1 - p3[1])) continue;

            ans += a[x1][p3[1]] * a[p3[0]][y1];
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */