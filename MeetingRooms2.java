//Leetcode 253 : Meeting Rooms II
// TC: O(N log N)
// S: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int n= intervals.length;

        if(n == 0) return 0;

        // Min heap to store the min meeting rooms
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });

        // sorting array based on the start time
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        //add first element to heap
        heap.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0] >= heap.peek()){
                heap.poll();
            }

            heap.add(intervals[i][1]);
        }

        return heap.size();
    }
}