class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        int count[] = new int[26];
        for(String str: strs){
            Arrays.fill(count, 0);

            for(char c: str.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < 26; i++){
                temp.append("#");
                temp.append(count[i]);
            }
            String key = temp.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String,List<String>> e: map.entrySet()){
            List<String> temp = e.getValue();
            ans.add(temp);
        }
        return ans;
    }
}