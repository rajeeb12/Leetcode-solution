class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= 8; i++){
            q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.peek();
            if(num >= high){
                break;
            }
            int size = q.size();
            for(int i = 1; i <= size; i++){
                int curNum = q.poll();
                int lastDigit = curNum % 10;
                int nextNum = (curNum * 10)  + (lastDigit + 1);
                if(lastDigit >= 9) break;
                
                q.add(nextNum);
                if(nextNum >= low && nextNum <= high){
                    ans.add(nextNum);
                }
            }
        }
        
        return ans;
    }
}