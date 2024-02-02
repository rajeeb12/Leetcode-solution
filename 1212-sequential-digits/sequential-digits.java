class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= 8; i++)
        {
            q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int num = q.poll();
            System.out.print(num+" ");
            if(num >= low && num <= high)
            {
                ans.add(num);
            }   
            
            int ld = num % 10;    
            if(ld + 1 <= 9 ) 
            {
                num = num * 10 + (ld + 1);
                q.add(num);
            }
            
        }
        return ans;
    }
}