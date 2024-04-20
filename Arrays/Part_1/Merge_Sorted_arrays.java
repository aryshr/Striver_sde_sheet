package Arrays.Part_1;

public class Merge_Sorted_arrays {
    //Brute force solution will be to create another array and then put each element in the created array and then sort it

    //Better Solution T.C = O(n+m) and S.C = O(n+m)
    // public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int[] arr = new int[n + m];
    //     int i =0, j =0, k=0;
    //     while(i < m && j < n){
    //         if(nums1[i] <= nums2[j]){
    //             arr[k++] = nums1[i++];
    //         }
    //         else{
    //             arr[k++] = nums2[j++];
    //         }
    //     }
        
    //     while(i < m){
    //         arr[k++] = nums1[i++];
    //     }
    //     while(j < n){
    //         arr[k++] = nums2[j++];
    //     }
        
    //     for(i = 0; i < n+m; i++){
    //         nums1[i] = arr[i];
    //     }
    // }

    //Optimal Solution T.C = O(n+m) and S.C = O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i =m-1, j =n-1, k=n+m-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
        
        while(i >= 0){
            nums1[k--] = nums1[i--];
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[]args){
        int[] arr = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        int m = 3, n = 3;
        merge(arr, m, arr2, n);
        for(int i: arr) System.out.print(i + " ");
    }

}
