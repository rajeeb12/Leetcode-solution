class Solution {
    public String losingPlayer(int x, int y) {
        boolean turn = true;

        while(x >= 1 && y >= 4)
        {
            if(turn){
                turn = !turn;
            }else{
                turn = !turn;
            }
            x -= 1;
            y -= 4;
        }
        return (turn ? "Bob" : "Alice");
    }
}