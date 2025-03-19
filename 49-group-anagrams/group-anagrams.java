class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);

            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String,List<String>> e: map.entrySet()){
            List<String> temp = e.getValue();
            ans.add(temp);
        }
        return ans;
    }
}