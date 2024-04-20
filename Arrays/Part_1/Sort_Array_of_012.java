package Arrays.Part_1;

public class Sort_Array_of_012 {
    //Brute force is to use sort function in nlogn time 

    //Better Approach - T.C = O(2n) and S.C = O(1)
    // public static void sortArray(int[] nums) {
    //     int zeroes = 0, ones = 0, twos = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         if(nums[i] == 0)zeroes++;
    //         else if(nums[i] == 1)ones++;
    //         else{
    //             twos++;
    //         }
    //     }
    //     for(int i = 0; i < nums.length; i++){
    //         if(i < zeroes) nums[i] = 0;
    //         else if(i-zeroes < ones) nums[i] = 1;
    //         else{
    //             nums[i] = 2;
    //         }
    //     }
    // }

    //Optimal Approach - T.C = O(n) and S.C = (1) (Dutch nation flag algo)
    public static void sortArray(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++; mid++;
            }
            else if(nums[mid] == 1) mid++;
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    
    public static void main(String args[]) {
        int n = 6;
        int[] nums = new int[]{0, 2, 1, 2, 0, 1};
        sortArray(nums);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
}
