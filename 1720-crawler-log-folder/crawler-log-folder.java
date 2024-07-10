class Solution {
    public int minOperations(String[] logs) {
        int steps = 0;
        for(String s: logs){
            if(s.equals("../")){
                if(steps == 0) continue;
                steps--;
            }else if(s.equals("./")){
                continue;
            }else{
                steps++;
            }
        }
        return steps;
    }
}