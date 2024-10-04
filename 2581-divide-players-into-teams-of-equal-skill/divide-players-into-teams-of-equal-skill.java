class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long ans = 0;
        Arrays.sort(skill);
        int same = skill[0] + skill[n - 1];
        ans = skill[0] * skill[n - 1];
        for(int i = 1; i < n / 2; i++)
        {
            int num1 = skill[i];
            int num2 = skill[n - i - 1];
            int same2 = num1 + num2;
            if(same2 != same) return -1;
            ans += (num1 * num2);
        }
        return ans;
    }
}