class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int occurence[] = new int[arr.length + 1];
        for(int i: map.values()){
            occurence[i]++;
            if(occurence[i] > 1) return false;
        }
        return true;

    }
}