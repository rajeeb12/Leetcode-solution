class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        if(!start.replaceAll("_", "").equals(target.replaceAll("_",""))) return false;

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
        
        
        return true;
    }
}