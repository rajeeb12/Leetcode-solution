class Solution {
    public int minimumChairs(String s) {
        int n = s.length();
        int occupied = 0;
        int notOccupied = 1;
        int totalChair = 1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'E'){
                if(notOccupied == 0){
                    totalChair++;
                    occupied++;
                }else{
                    occupied++;
                    notOccupied--;
                }
            }else{
                occupied--;
                notOccupied++;
            }
        }
        return totalChair;
    }
}