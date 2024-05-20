// TC: O(N log (max-min)) max - max element in the array , min - min element in the array
// S: O(1)
// Approach -> Since the matrix is sorted rowwise and columnwise, applying binary search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // taking first element as my low
        int low = matrix[0][0];

        // last element as my high
        int high = matrix[n-1][n-1];

        while(low != high){
            // calculating mid
            int mid = low + (high - low) /2;

            // checking the count of of elements in the left and right array of the mid
            int count = countArrayElements(matrix, mid);

            // if left array has lesser number elements than K then I need to increase my search range towards right
            // else move search range towards right
            if(count < k){
                low = mid +1;
            }else {
                high = mid;
            }
        }

        return low;
    }

    /**
    This method checking elements lesser than mid in rows and columns
    */
    private int countArrayElements(int[][] matrix, int mid){

        int n = matrix.length;
        int count =0;
        int row = n -1;
        int col =0;

        while(row >= 0 && col < n){
            if(matrix[row][col] > mid){
                row--;
            }else {
                count += row + 1;
                col++;
            }
        }

        return count;
    }
}