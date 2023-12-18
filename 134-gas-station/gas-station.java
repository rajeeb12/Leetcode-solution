class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_gas = 0;
        int tank = 0;
        int start = 0;
        for(int i = 0 ; i < n; i++)
        {
            total_gas += gas[i] - cost[i]; // diff between gas and cost
            tank += gas[i] - cost[i];

            if(tank < 0) // if tank become zero reset
            {
                tank = 0;
                start = i + 1;
            }
        }

        return (total_gas < 0 ? -1 : start);
    }
}