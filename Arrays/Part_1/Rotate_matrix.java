package Arrays.Part_1;

public class Rotate_matrix {

    //Brute Force - T.C = O(n^2) and S.C = O(n^2)

    // public static int[][] rotate(int[][] matrix) {
    //     int n = matrix.length;
    //     int rotated[][] = new int[n][n];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             rotated[j][n - i - 1] = matrix[i][j];
    //         }
    //     }
    //     return rotated;
    // }

    public static void rotate(int[][]matrix){
        int n = matrix.length;
        
        // Brute Force - Create another array and put the element at their places
        
        //Optimal Solution - T.C = O(n * n/2 + n * n/2) or O(n^2 + n^2) and S.C = O(1)
        // Two steps needed 
        // 1. Transpose the matrix      2. Reverse each row
        
        
        //Transpose O(n * n/2)      n/2 because we are just traversing in one part of matrix
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                swap(i, j, matrix);
            }
        }
        
        
        //Reverse O(n * n/2)
        for(int i = 0; i < n; i++){
            int j = 0, k = n-1;
            while( j < k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;k--;
            }
        } 
    }
    
    public static void swap(int i, int j, int[][]mat){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public static void main(String[] args){
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // arr = rotate(arr);   for brute force
        rotate(arr);  // for optimal solution
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
