package Arrays.Part_1;

public class Search_in_a_2D_matrix {
    // Linear search T.C = O(n*m) and S.C = O(1)
    // public static boolean searchMatrix(int[][] matrix, int target) {
    // int n = matrix.length, m = matrix[0].length;
    // for(int i = 0; i < n; i++){
    // for(int j = 0; j < m; j++){
    // if(matrix[i][j] == target){
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // Optimal Sol. T.C = O(log(m*n)) and S.C = O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = 0;
        int n = matrix.length * matrix[0].length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            row = mid / matrix[0].length;
            col = mid % matrix[0].length;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                left = mid + 1;
            else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 10;
        System.out.println(searchMatrix(matrix, target));
    }
}
