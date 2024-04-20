package Arrays.Part_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class four_Sum {
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     int n = nums.length;
    //     Set<List<Integer>> set = new HashSet<>();
    //     for(int i = 0; i<n;i++){
    //         for(int j = i+1; j <n; j++){
    //             for(int k = j+1; k < n; k++){
    //                 for(int l = k+1; l < n; l++){
    //                     int sum = nums[i]+nums[j]+nums[k]+nums[l];
    //                     if(sum == target) {
    //                         List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
    //                         Collections.sort(temp);
    //                         set.add(temp);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(set);
    //     return ans;
    // }
    
    
    //Better Solution T.C = O(N^3 * log(no. of ele in set))  some operations on the set data structure which take log(M) time complexity.
    // S.C = O(2 * N + N) 2*n for outer set and ans list, and N for inner set that can contain at most all elements
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     int n = nums.length;
    //     Set<List<Integer>> set = new HashSet<>();
    //     for(int i = 0; i<n;i++){
    //         for(int j = i+1; j <n; j++){
    //             Set<Long> set1 = new HashSet<>();
    //             for(int k = j+1; k < n; k++){
    //                 long sum = (long)nums[i]+(long)nums[j]+(long)nums[k];
    //                 long forth = target - sum;
    //                 if(set1.contains(forth)) {
    //                     List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int)forth);
    //                     Collections.sort(temp);
    //                     set.add(temp);
    //                 }
    //                 set1.add((long)nums[k]);
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>(set);
    //     return ans;
    // }
    
    
    
    //Optimal soluion T.C = O(n^3) and S.C = O(no. of quadruplets)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j + 1, l = n-1;
                while(k < l){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}

