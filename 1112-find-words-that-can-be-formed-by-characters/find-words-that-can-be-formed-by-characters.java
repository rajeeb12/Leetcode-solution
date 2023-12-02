class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch: chars.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int good = 0;

        for(String str: words)
        {
            int arr[]= new int[26];
            boolean isGood = true;
            for(char ch: str.toCharArray())
            {
                arr[ch - 'a']++;
                if(!map.containsKey(ch) || !(map.get(ch) >= arr[ch-'a']))
                {
                    isGood = false;
                    break;
                }
            }
            if(isGood) good += str.length();
        }
        return good;
    }
}