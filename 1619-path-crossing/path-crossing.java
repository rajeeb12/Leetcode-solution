class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int row = 0 , col = 0;
        set.add(new String(row+""+col));

        for(char ch: path.toCharArray())
        {
            if(ch == 'N')
            {
                row += 1;
            }else if(ch == 'S')
            {
                row -= 1;
            }else if(ch== 'E')
            {
                col -= 1; 
            }else{
                col += 1;
            }
            String cord = row+""+col;
            if(set.contains(cord)) return true;

            set.add(cord);
        }
        return false;

    }
}