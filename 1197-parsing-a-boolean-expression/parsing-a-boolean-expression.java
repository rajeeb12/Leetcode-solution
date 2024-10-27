class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for(char c: expression.toCharArray()){
            if(c == '(' || c == ',') continue;

            if(c == '&' || c == '|' || c == '!' || c == 't' || c== 'f'){
                st.add(c);
            }else if(c == ')'){
                boolean hasTrue = false;
                boolean hasFalse = false;
                boolean temp = false;

                while(!st.isEmpty() && st.peek() != '&' && st.peek() != '|' && st.peek() != '!' ){
                    char t = st.pop();
                    if(t == 't') hasTrue = true;
                    if(t == 'f') hasFalse = true;
                }
                char sign = st.pop();
                if(sign == '|'){
                    if(hasTrue){
                        temp = true;
                    }else{
                        temp = false;
                    }
                }
                if(sign == '&'){
                    if(hasFalse){
                        temp = false;
                    }else{
                        temp = true;
                    }
                }
                if(sign == '!'){
                    if(hasTrue){
                        temp = false;
                    }else if(hasFalse){
                        temp = true;
                    }
                }
                st.add(temp ? 't' : 'f');
            }
        }
        return (st.pop() == 't' ? true : false);
    }
}