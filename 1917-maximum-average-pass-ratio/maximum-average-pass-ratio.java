class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        int n  = classes.length;
        double total = 0;
        for(int i = 0; i < n; i++){
            double ratio = (double) (classes[i][0] ) / classes[i][1];
            double uRatio = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double gain = uRatio - ratio;
            pq.add(new double[]{gain, classes[i][0], classes[i][1]});
            total += ratio; 
        }

        while(extraStudents-- > 0)
        {
            double temp[] = pq.poll();
            double pRatio = temp[1] / temp[2];

            total -= pRatio;
            ++temp[1];
            ++temp[2];

            double cRatio = temp[1] / temp[2];
            total += cRatio;

            double uRatio = (temp[1] + 1)/ (temp[2] + 1);
            double gain = uRatio - cRatio;

            pq.add(new double[]{gain, temp[1], temp[2]});
        }

        return (double) total / n;
    }
}