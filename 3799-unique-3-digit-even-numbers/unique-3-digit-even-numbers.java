class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int visited[] = new int[10];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < digits.length; i++){
            visited[i] = 1;
            solve(digits,digits[i], 2, visited, set);
            visited[i] = 0;
        }
        return set.size();
    }
    public void solve(int digit[],int num,int k,int visited[],HashSet<Integer> set){
        if(k == 0){
            String s = num +"";
            if(s.length() == 3 && num % 2 == 0){
                set.add(num);
            }
            return;
        }

        for(int i = 0; i < digit.length; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            solve(digit, num * 10 + digit[i], k - 1, visited, set);
            visited[i] = 0;
        }
    }
}