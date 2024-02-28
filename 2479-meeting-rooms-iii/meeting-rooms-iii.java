class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        long room[] = new long[n];
        int roomUseCount[] = new int[n];
        for(int m[]: meetings)
        {
            int start = m[0];
            int end = m[1];
            int duration = end - start;
            
            boolean foundAnyRoom = false;
            int earlyEndRoom = 0;
            long earlyEndRoomTime = Long.MAX_VALUE;

            for(int i = 0 ; i < n; i++)
            {
                if(room[i] <= start)
                {
                    room[i] = end;
                    roomUseCount[i]++;
                    foundAnyRoom = true;
                    break;
                }
                if(earlyEndRoomTime > room[i])
                {
                    earlyEndRoom = i;
                    earlyEndRoomTime = room[i];
                }
            }
            if(!foundAnyRoom)
            {
                room[earlyEndRoom] += duration;
                roomUseCount[earlyEndRoom]++;
            }
        }
        int resRoom = -1;
        int maxUse = 0;
        for(int i = 0 ; i < n; i++)
        {
            // System.out.print(roomUseCount[i]);
            if(roomUseCount[i] > maxUse)
            {
                resRoom = i;
                maxUse = roomUseCount[i];
            }
        }
        return resRoom;
    }
}