class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n =  arr.length / 4;

        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(entry.getValue() > n) return entry.getKey();
        }
        return -1;
    }
}