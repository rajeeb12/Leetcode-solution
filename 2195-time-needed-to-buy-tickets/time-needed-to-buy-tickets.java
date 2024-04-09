class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int index = 0;
        int n = tickets.length;
        int time = 0;
        while(tickets[k] != 0)
        {
            if(tickets[index % n] == 0)
            {
                index++;
            }else{
                tickets[index % n]--;
                index++;
                time++;
            }
        }
        return time;
    }
}