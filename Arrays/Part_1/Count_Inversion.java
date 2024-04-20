package Arrays.Part_1;

import java.util.ArrayList;

public class Count_Inversion {
    
    // Brute force T.C = O(n^2) and S.C = O(1)
    // public boolean isIdealPermutation(int[] nums) {
    //     int global = 0, local = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = i+1; j < nums.length; j++){
    //             if(nums[i] > nums[j]){
    //                 global++;
    //             }
    //         }
    //         if(i+1 < nums.length){
    //             if(nums[i] > nums[i+1]) local++;
    //         }
    //     }
    //     return global == local;
    // }
    
    
    
    
    // Optimal Approach T.C = O(nlogn) and S.C = O(n)
    public static int isIdealPermutation(int[] nums) {
        int n = nums.length;
        int global = 0, local = 0;
        // for(int i = 0; i < nums.length-1; i++){
        //     if(nums[i] > nums[i+1]) local++;
        // }
        global = mergeSort(nums, 0, n-1);
        
        // System.out.println(global);
        // System.out.println(local);
        return global;
    }

    public static int mergeSort(int arr[], int low, int high){
        int count = 0;
        if(low >= high) return count;
        int mid = (low + high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int arr[], int low, int mid, int high){
        int count = 0;
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
                count += mid - left+1;
            }
        }

        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = isIdealPermutation(a);
        System.out.println("The number of inversions are: " + cnt);
    }
}
 
