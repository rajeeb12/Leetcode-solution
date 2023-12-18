class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs)
        {
            char arr[]= str.toCharArray();
            Arrays.sort(arr);
            String newString = new String(arr);
            if(!map.containsKey(newString))
            {
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(str);
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: map.entrySet())
        {
            List<String> it= entry.getValue();
            List<String> temp = new ArrayList<>();
            for(String str: it)
            {
                temp.add(str);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}