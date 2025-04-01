class Solution {
    public String multiply(String n1, String n2) {
        int m = n1.length();
        int n = n2.length();
        int ans[] = new int[n + m];

        for(int i = m - 1; i >= 0; i--){
            int carry1 = 0;

            for(int j = n - 1; j >= 0; j--){
                int num1 = n1.charAt(i) - '0';
                int num2 = n2.charAt(j) - '0';
                int mul = num1 * num2;
                int pos1 = i + j, pos2 = i + j + 1;
                int sum = ans[pos2] + mul;

                ans[pos1] += sum / 10;
                ans[pos2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: ans){
            if(sb.length() == 0 && i == 0) continue;
            sb.append(i);
        }
        return (sb.length() == 0 ? "0" : sb.toString());
    }
}