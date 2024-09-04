class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dirx[] = {0, 1, 0, -1}; 
        int diry[] = {1, 0, -1, 0};

        HashSet<String> set = new HashSet<>();
        for(int i[]: obstacles){
            set.add(i[0]+" "+i[1]);
        }
        int n = commands.length;
        int direction = 0, x = 0, y = 0, max = 0;
        for(int i = 0; i < n; i++)
        {
            if(commands[i] == -1){
                direction = (direction + 1) % 4;
            }else if(commands[i] == -2){
                direction = (direction + 3) % 4;
            }else{
                for(int j = 0; j < commands[i]; j++)
                {
                    if(set.contains((x + dirx[direction])+" "+ (y + diry[direction]))) break;
                    x += dirx[direction];
                    y += diry[direction];
                }
            }
            
            
            max = Math.max(max, x * x + y * y);
        }
        return max;
    }
}