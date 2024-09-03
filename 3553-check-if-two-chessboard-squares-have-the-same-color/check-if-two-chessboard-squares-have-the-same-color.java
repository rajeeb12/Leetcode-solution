class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        if(coordinate1.equals(coordinate2)) return true;
        int index[]={0,1,2,3,4,5,6,7};

        int index1 = coordinate1.charAt(1) - 'a';
        int index2 = coordinate2.charAt(1) - 'a';

        int dist1= coordinate1.charAt(0) - '0';
        int dist2= coordinate2.charAt(0) - '0';

        boolean color1 = (index1 % 2 == 0 ? true : false);
        boolean color2 = (index2 % 2 == 0 ? true : false);

        for(int i = 1; i < dist1; i++){
            color1 = !color1;
        }
        for(int i = 1; i < dist2; i++){
            color2 = !color2;
        }
        return (color1 == color2);
    }
}