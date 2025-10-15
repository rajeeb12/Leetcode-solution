class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String str_ = new String(arr);
            if(!map.containsKey(str_)){
                map.put(str_, new ArrayList<>());
            }
            map.get(str_).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}