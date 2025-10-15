class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            String hash = getHash(str);
            if(!map.containsKey(hash)){
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
        // TC - O(n * (O(mlogm) + O(m)))
        // SC - O(n)
    }
    public String getHash(String s){
        int arr[] = new int[26];
        for(char ch: s.toCharArray()){
            arr[ch-'a']++;
        }
        String hash = "";
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                hash += ((char)(i + 'a'))+""+ arr[i];
            }
        }
        return hash;
    }
}