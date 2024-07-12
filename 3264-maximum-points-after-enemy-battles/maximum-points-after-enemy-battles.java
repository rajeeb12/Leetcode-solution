class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        if(currentEnergy < enemyEnergies[0]) return 0;
        int n = enemyEnergies.length;
        int min = enemyEnergies[0];
        long points = 0;
        int index = n - 1;
        while(true)
        {
            if(currentEnergy >= min){
                int temp = currentEnergy / min;
                points += temp;
                currentEnergy = currentEnergy % min;
            }
            currentEnergy += enemyEnergies[index--];
            if(index < 0) break;
        }
        return points;
    }
}