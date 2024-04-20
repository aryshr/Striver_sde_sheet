package Arrays.Part_1;

import java.util.ArrayList;

public class Reverse_pairs {
    //Brute force T.C = O(n^2) and S.C = O(1)
    // public int reversePairs(int[] nums) {
    //     int cnt = 0;
    //     int n = nums.length;
    //     for(int i = 0; i < n; i++){
    //         for(int j = i+1; j < n; j++){
    //             if(nums[i] > 2*nums[j]) cnt++;
    //         }
    //     }
    //     return cnt;
    // }
    
    //Optimal Solution T.C = O(2N*logn) mergeSort() takes logn time and merge() and countpairs() takes n time and S.C = O(1)
    
    public static int reversePairs(int[] nums){
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
    }
    
    public static int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid+1, high);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return cnt;
    }
    
    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
    public static int countPairs(int[] nums, int low, int mid, int high){
        int right = mid+1;
        int cnt = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && nums[i] > (2* (long) nums[right])){
                right++;
            }
            cnt += right - (mid+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3, 1};
        int cnt = reversePairs(a);
        System.out.println("The number of reverse pair is: " + cnt);
    }
    
}

