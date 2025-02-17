class Solution {
    public int numTilePossibilities(String tiles) {
        if(tiles.length() == 0) return 0;
        char arr[] = tiles.toCharArray();
        HashSet<String> set = new HashSet<>();
        solve(0, arr, set);
        return set.size();
    }
    public void solve(int index,char arr[],HashSet<String> set){
        for(int i = index; i < arr.length; i++){
            swap(index, i, arr);
            String s = new String(arr);
            totalUnique(s, set);
            solve(index + 1, arr, set);
            swap(index, i, arr);
        }
    }
    public void totalUnique(String s, HashSet<String> set){
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                String substr = s.substring(i,j);
                set.add(substr);
            }
        }
    }
    public void swap(int i,int j,char arr[]){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
}