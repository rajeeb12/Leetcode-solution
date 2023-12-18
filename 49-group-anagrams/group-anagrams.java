class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int hash[] = new int[26];
        for(String str: strs)
        {
            for(char ch: str.toCharArray())
            {
                hash[ch - 'a']++;
            }
            String newString = "";
            for(int i = 0 ; i < 26; i++)
            {
                while(hash[i] > 0)
                {
                    newString += (i + 'a');
                    hash[i]--;
                }
            }

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