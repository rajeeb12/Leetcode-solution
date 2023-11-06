//optimal
class SeatManager {
    PriorityQueue<Integer> pq;
    int seatMarker;
    public SeatManager(int n) {
        pq = new PriorityQueue<>((a,b) -> a - b);
        seatMarker = 1;
    }
    
    public int reserve() {
        if(!pq.isEmpty()){
            int seat = pq.peek();
            pq.poll();
            return seat;
        }
        int currentSeat = seatMarker;
        seatMarker++;
        return currentSeat;
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

//Brute 
// class SeatManager {
//     int seats[];
//     public SeatManager(int n) {
//         seats = new int[n + 1];
//         Arrays.fill(seats, -1);
//     }
    
//     public int reserve() {
//        int reserve = -1;
//        for(int i = 1 ; i < seats.length ; i++){
//            if(seats[i] == -1){
//                seats[i] = 1;
//                reserve = i;
//                break;
//            }
//        }
//        return reserve;
//     }
    
//     public void unreserve(int seatNumber) {
//         seats[seatNumber] = -1;
//     }
// }

//Better
// class SeatManager {
//     PriorityQueue<Integer> pq;
//     public SeatManager(int n) {
//         pq = new PriorityQueue<>((a,b) -> a - b);
//         for(int i= 1 ; i <= n ; i++){
//             pq.add(i);
//         }
//     }
    
//     public int reserve() {

//         return pq.poll();
//     }
    
//     public void unreserve(int seatNumber) {
//         pq.add(seatNumber);
//     }
// }


/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */