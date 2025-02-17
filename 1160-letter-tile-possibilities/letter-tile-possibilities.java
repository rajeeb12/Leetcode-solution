class Solution {
    public int numTilePossibilities(String tiles) {
        int arr[] = new int[26];
        for(char c: tiles.toCharArray()) arr[c-'A']++;
        int ans[] = new int[1];
        solve(arr, ans);
        return ans[0];
    }
    public void solve(int arr[], int ans[]){
        for(int i = 0; i < 26; i++){
            if(arr[i] == 0) continue;
            ans[0]++;
            arr[i]--;
            solve(arr, ans);
            arr[i]++;
        }
    }
}