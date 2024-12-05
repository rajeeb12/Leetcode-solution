class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        String ans1 = "";
        String ans2 = "";
        int l1 = 0 , r1 = 0, l2 = 0, r2 = 0; 

        for(int i = 0 ; i < n; i++){
            char c = start.charAt(i);
            char c2 = target.charAt(i);

            if(c != '_'){
                ans1 += c; 
                l1 = (c == 'L' ? 1 : 0);
                r1 = (c == 'R' ? 1 : 0);
            }
            if(c2 != '_'){
                ans2 += c2;
                l2 = (c2 == 'L' ? 1 : 0);
                r2 = (c2 == 'R' ? 1 : 0);
            }
        }
        for(int i = 0 , j = 0 ; i < n && j < n; i++, j++){
            while(i < n && start.charAt(i) == '_'){
                i++;
            }
            while(j < n && target.charAt(j) == '_'){
                j++;
            }
            if(i < n && j < n){
                if(start.charAt(i) == 'L' && i < j) return false;
                if(start.charAt(i) == 'R' && i > j) return false;
            }
        }
        if(l1 != l2 || r1 != r2 || !ans1.equals(ans2)) return false;
        
        return true;
    }
}