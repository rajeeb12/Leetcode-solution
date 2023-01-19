class Solution{
    static int setBit(int N){
        for(int i=0; (1<<i)<N; i++)
        {
            if( (N & (1 << i)) == 0)
            {
                N = N | (1 << i);
                break;
            }
        }
        return N;
    }
}