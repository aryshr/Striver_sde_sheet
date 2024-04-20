package Arrays.Part_1;


class Set_Matrix_Zeroes {
    //BRUTE FORCE APPROACH T.C = O[(n*m)*(n+m)+(n*m)] and S.C = O(1)
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(i, matrix);
                    markCol(j, matrix);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }

    public static void markRow(int i, int[][] m) {
        for (int j = 0; j < m[0].length; j++) {
            if (m[i][j] != 0)
                m[i][j] = -1;
        }
    }

    public static void markCol(int j, int[][] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][j] != 0)
                m[i][j] = -1;
        }
    }


    //BETTER APPROACH T.C = O(2(n*m)) and S.C = O(n+m)
    // public void setZeroes(int[][] matrix) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int[] col = new int[m];
    //     int[] row = new int[n];
        
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < m; j++){
    //             if(matrix[i][j] == 0){
    //                 col[j] = 1;
    //                 row[i] = 1;
    //             }
    //         }
    //     }
        
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < m; j++){
    //             if(row[i] == 1 || col[j] == 1){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }



    // //OPTIMAL APPROACH T.C = O(2(n*m)) and S.C = O(1)
    // public void setZeroes(int[][] matrix) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int col0 = 1;
        
    //     // marking row and col array
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < m; j++){
    //             if(matrix[i][j] == 0){
    //                 matrix[i][0] = 0;
    //                 if(j != 0){
    //                     matrix[0][j] = 0;   
    //                 }else{
    //                     col0=0;
    //                 }
    //             }
    //         }
    //     }
        
    //     //marking the remaining area
    //     for(int i = 1; i < n; i++){
    //         for(int j = 1; j < m; j++){
    //             if(matrix[i][j] != 0){
    //                 if(matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
    //             }
    //         }
    //     }
        
    //     //marking col array
    //     if(matrix[0][0] == 0){
    //         for(int j = 0; j < m; j++)matrix[0][j] = 0;
    //     }        
    //     if(col0 == 0){
    //         for(int i = 0; i < n; i++) matrix[i][0] = 0;
    //     }
    // }


    public static void main(String[] args){
        int[][]matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};

        setZeroes(matrix);

        System.out.println("The Final matrix is: ");
        for (int[] i: matrix) {
            for (int ele : i) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}