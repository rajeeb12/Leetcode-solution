class Solution {
    public int passThePillow(int n, int time) {
        if(time < n) return time + 1;

        int curTime = 0;
        int num = 1;
        boolean turn = true;
        while(true){
            if(turn){
                num++;    
            }else{
                num--;
            }
            ++curTime;
            
            if(curTime == time) return num;

            if(num == n){
                turn = false;
            }else if(num == 1)
            {
                turn = true; 
            }
        }
    }
}