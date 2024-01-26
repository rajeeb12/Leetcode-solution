class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1= new Stack<>();
        Stack<Character> st2= new Stack<>();
        for(char ch: s.toCharArray())
        {
            if(ch == '#')
            {
                if(st1.isEmpty()) continue;
                st1.pop();
            }
            else st1.add(ch);
        }
        for(char ch: t.toCharArray())
        {
            if(ch == '#')
            {
                if(st2.isEmpty()) continue;
                st2.pop();
            }
            else st2.add(ch);
        }
        if(st1.size() == 0 && st2.size() == 0) return true;
        String res1 = "";
        String res2 = "";

        while(!st1.isEmpty())
        {
            res1 = st1.pop() + res1;  
        }
        while(!st2.isEmpty())
        {
            res2 = st2.pop() + res2;  
        }
        return res1.equals(res2);
    }
}