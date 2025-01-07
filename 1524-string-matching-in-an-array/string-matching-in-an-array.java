class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a,String b){
                return a.length() - b.length();
            }
        });
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int k = words.length - 1; k >= 0; k--)
        {
            System.out.print(words[k]+" ");
            String s = words[k];
            if(set.contains(s)) ans.add(s);
            for(int i = 0; i < s.length(); i++){
                for(int j = i; j < s.length(); j++){
                    String substr = s.substring(i, j + 1);
                    set.add(substr);
                    //System.out.print(substr+" ");
                }
            }
        }
        return ans;
    }
}