class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int minTime = 0;
        int m_Index = 0;
        int p_Index = 0;
        int g_Index = 0;

        for(int i = 0 ; i < garbage.length ; i++){
            int length = garbage[i].length();
            for(char ch : garbage[i].toCharArray()){
                if(ch == 'M'){
                    m_Index = i;
                }else if(ch == 'P'){
                    p_Index = i;
                }else if(ch == 'G'){
                    g_Index = i;
                }
            }
            minTime += length;
        }

       int totalTime[] = new int[travel.length];
       totalTime[0]= travel[0];
       for(int i = 1 ; i < travel.length; i++){
           totalTime[i] = totalTime[i - 1] + travel[i];  
       } 

       minTime += m_Index > 0 ? totalTime[m_Index - 1] : 0 ;
       minTime += p_Index > 0 ? totalTime[p_Index - 1] : 0 ;
       minTime += g_Index > 0 ? totalTime[g_Index - 1] : 0 ;
       return minTime;
    }
}