class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int map[] = new int[1001];
        for(int i : target){
            map[i]++;
        }
        for(int i: arr){
            map[i]--;
        }
        for(int i = 1; i <= 1000; i++)
        {
            if(map[i] != 0) return false;
        }
        return true;
    }
}