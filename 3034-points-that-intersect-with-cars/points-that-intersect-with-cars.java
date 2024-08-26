class Pair{
    int x;
    int y;
    public Pair(int _x,int _y){
        this.x = _x;
        this.y = _y;
    }
}
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        List<Pair> temp = new ArrayList<>();
        int n = nums.size();
        int x = nums.get(0).get(0);
        int y = nums.get(0).get(1);
        for(int i = 1; i < n; i++){
            if(nums.get(i).get(0) <= y)
            {
                x = Math.min(x, nums.get(i).get(0));
                y = Math.max(y, nums.get(i).get(1));
            }else{
                temp.add(new Pair(x, y));
                x = nums.get(i).get(0);
                y = nums.get(i).get(1);
            }
        }
        temp.add(new Pair(x, y));

        int sum = 0;
        for(Pair it: temp){
            // System.out.print(it.x+" "+it.y);
            sum += (it.y - it.x + 1);
        }
        return sum;
    }
}