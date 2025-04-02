class DetectSquares {
    List<int[]> list;
    HashMap<String,Integer> map;
    public DetectSquares() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        String s = point[0]+"|"+point[1];
        list.add(point);
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
    
    public int count(int[] point) {
        int ans = 0;
        int px = point[0];
        int py = point[1];
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            if(px == x || py == y || Math.abs(px - x) != Math.abs(py - y)) continue;
            
            String p1 = x+"|"+py; 
            String p2 = px+"|"+y;
            
            ans += map.getOrDefault(p1, 0) * map.getOrDefault(p2, 0);
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