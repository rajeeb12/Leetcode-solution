class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s: strs)
        {
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if(!map.containsKey(str))
            {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            ans.add(new ArrayList<>(entry.getValue()));
        }
        return ans;
    }
}