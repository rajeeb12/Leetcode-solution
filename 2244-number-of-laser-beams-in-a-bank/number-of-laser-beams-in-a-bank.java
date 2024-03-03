class Solution {
    public int numberOfBeams(String[] bank) {
        ArrayList<Integer> countOfDevice = new ArrayList<>();

        for(String str: bank)
        {
            int count = 0;
            for(char ch: str.toCharArray())
            {
                if(ch == '1') count++;
            }
            if(count == 0) continue;
            countOfDevice.add(count);
        }
        if(countOfDevice.size() <= 1) return 0;
        int ans = 0;
        for(int i = 0 ; i < countOfDevice.size() - 1; i++)
        {
            ans += (countOfDevice.get(i) * countOfDevice.get(i + 1));
        }
        return ans;
    }
}