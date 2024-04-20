package Arrays.Part_1;

import java.util.*;

public class SubArray_with_given_XOR {
    // Brute force approach T.C = O(n^3) as 3 loops and S.C = O(1) no extra space used
    // public static int solve(ArrayList<Integer> A, int B) {
    //     int n = A.size();
    //     int count = 0;
    //     for(int i = 0; i < n; i++){
    //         for(int j = i; j < n; j++){
    //             int xor = 0;
    //             for(int k = i; k <= j; k++){
    //                 xor = xor ^ A.get(k);
    //             }
    //             if(xor == B){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    
    
    // Better approach T.C = O(n^2) and S.C = O(1) 
    // public static int solve(ArrayList<Integer> A, int B) {
    //     int n = A.size();
    //     int count = 0;
    //     for(int i = 0; i < n; i++){
    //         int xor = 0;
    //         for(int j = i; j < n; j++){
    //             xor = xor ^ A.get(j);
                
    //             if(xor == B){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    
    
    //Optimal Approach T.C = O(n*logn) in worst case and S.C = O(n)
    public static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int xr = 0;
        hm.put(xr, 1);
        for(int i = 0; i < n; i++){
            xr = xr ^ A.get(i);
            int x = xr ^ B;
            if(hm.containsKey(x)){
                count += hm.get(x);
            }
            hm.put(xr, hm.getOrDefault(xr,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(4);
        li.add(2);
        li.add(2);
        li.add(6);
        li.add(4);
        int k = 6;
        int ans = solve(li, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}

