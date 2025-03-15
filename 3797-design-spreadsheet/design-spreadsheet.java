class Spreadsheet {
    HashMap<String ,Integer> map;
    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        if(!map.containsKey(cell)){
            map.put(cell, value);
        }
        else{
            map.put(cell, value);
        }
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String arr[] = formula.split("\\+");
        String left = arr[0].substring(1, arr[0].length());
        String right = arr[1];
        int num1 = 0 , num2 = 0;

        if((left.charAt(0) >= 'A' && left.charAt(0) <= 'Z'))
        {
            num1 = (map.containsKey(left) ? map.get(left) : 0);
        }else{
            for(char c: left.toCharArray()){
                num1 = (num1 * 10) + (c - '0');
            }
        }
        if((right.charAt(0) >= 'A' && right.charAt(0) <= 'Z'))
        {
            num2 = (map.containsKey(right) ? map.get(right) : 0);
        }else{
            for(char c: right.toCharArray()){
                num2 = num2 * 10 + (c -'0');
            }
        }
        return num1 + num2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */