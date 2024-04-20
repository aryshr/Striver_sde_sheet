package Arrays.Part_1;

import java.util.*;

public class Pascal_Triangle {
    // Brute Force - T.C = O(n*n*r)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int col = 1; col <= i; col++){
                arr.add(findnCr(i-1, col-1));
            }
            ans.add(arr);
        }
        return ans;
    }
    
    public static int findnCr(int n, int r){
        long res = 1;
        for(int i = 0; i < r; i++){
            res = res*(n-i);
            res = res / (i+1);
        }
        return (int)res;
    }
    
    
    
    //Optimal sol T.C = O(n^2) and S.C = O(1) excluding result array
    
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> ans = new ArrayList<>();
//         for(int i = 1; i <= numRows; i++){
//             ans.add(findnCr(i));
//         }
//         return ans;
//     }
    
//     public List<Integer> findnCr(int r){
//         ArrayList<Integer> arr = new ArrayList<>();
//         arr.add(1);
//         long res = 1;
//         for(int i = 1; i < r; i++){
//             res = res*(r-i);
//             res = res / i;
//             arr.add((int)res);
//         }
//         return arr;
//     }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = generate(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
