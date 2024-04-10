class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        int n = deck.length;
        for(int i = 0; i < n; i++) q.add(i);
        int res[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return res;
    }
}