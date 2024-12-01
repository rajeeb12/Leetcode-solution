class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i] , 0) + 1);
        }
        for(int val: arr){
            if(val != 0 && map.containsKey(2 * val)) return true;
            if(val == 0 && map.get(val) >= 2) return true;
        }
        return false;
    }
}