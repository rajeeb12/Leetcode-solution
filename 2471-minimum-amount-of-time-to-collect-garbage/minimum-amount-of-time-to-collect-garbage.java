class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for(int i = 1; i < travel.length; i++)
        {
            travel[i] += travel[i - 1];
        }
        int m_index = 0;
        int p_index = 0;
        int g_index = 0;
        int sum = 0;
        for(int i = 0; i < garbage.length; i++)
        {
            String str = garbage[i];
            sum += str.length();
            for(char ch: str.toCharArray())
            {
                if(ch == 'G')
                {
                    m_index = i;   
                }else if(ch == 'P')
                {
                    p_index = i;
                }else{
                    g_index = i;
                }
            }
        }
        sum += m_index <= 0 ? 0 : travel[m_index - 1];
        sum += p_index <= 0 ? 0 : travel[p_index - 1];
        sum += g_index <= 0 ? 0 : travel[g_index - 1];
        return sum;
    }
}