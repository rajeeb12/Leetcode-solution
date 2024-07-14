class Pair{
    String s;
    int count;
    public Pair(String _s,int _c){
        this.s = _s;
        this.count = _c;
    }
}
class Solution {
    public String countOfAtoms(String formula) {
        Stack<Pair> st = new Stack<>();
        int n = formula.length();
        for(int i = 0; i < n; i++){
            char c = formula.charAt(i);
            if(Character.isUpperCase(c)){
                String s = "";
                s += c;
                int j;
                for(j = i + 1; j < n; j++){
                    if(!Character.isLowerCase(formula.charAt(j))) break;
                    s += formula.charAt(j);
                }
                String num = "";
                int k;
                for(k = j; k < n; k++){
                    if(!Character.isDigit(formula.charAt(k))) break;
                    num += formula.charAt(k);
                }
                int count = (num.length() == 0 ? 1 : Integer.parseInt(num));
                st.add(new Pair(s+"", count));
                i = k - 1;
            }
            else if(c == '('){
                st.add(new Pair(c+"", -1));
            }else{
                String num ="";
                int k;
                for(k = i + 1; k < n; k++)
                {
                    if(!Character.isDigit(formula.charAt(k))) break;
                    num += formula.charAt(k);
                }
                int count = (num.length() == 0 ? 1 : Integer.parseInt(num));

                List<Pair> ls = new ArrayList<>();

                while(!st.isEmpty())
                {
                    Pair p = st.pop();
                    if(p.s.charAt(0) == '(') break;
                    
                    p.count *= count;
                    ls.add(p); 
                } 
                for(Pair p : ls){
                    st.add(p);
                }
                i = k - 1;
            }
        }
        TreeMap<String, Integer> map = new TreeMap<>();

        while(!st.isEmpty()){
            Pair p = st.pop();
            if(map.containsKey(p.s)){
                map.put(p.s, map.get(p.s) + p.count);
            }
            else{
                map.put(p.s, p.count);
            }
        }
        String ans = "";

        for(Map.Entry<String,Integer> e: map.entrySet()){
            ans += e.getKey() + "" + (e.getValue() == 1 ? "" : e.getValue());
        }
        return ans;
    }
}