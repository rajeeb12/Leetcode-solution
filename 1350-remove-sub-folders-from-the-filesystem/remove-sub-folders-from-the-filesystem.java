class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for(String s: folder){
            boolean found = false;
            for(int i = 2; i < s.length(); i++)
            {
                if(s.charAt(i) == '/' && set.contains(s.substring(0, i)))
                {
                    found = true;
                    break;
                }
            }
            if(!found){
                ans.add(s);
                set.add(s);
            }
        }
        return ans;
    }
}