package Arrays.Part_1;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_1 {
    // public static List<Integer> majorityElement(int[] nums) {
    //     // Brute force T.C = O(n^2) and S.C = O(1)
    //     int n = nums.length;
    //      List<Integer> ls = new ArrayList<>();
    //     for(int i = 0; i < n; i++){
    //         if(ls.size() == 0 || ls.get(0) != nums[i]){
    //             int cnt = 0;
    //             for(int j = 0; j < n; j++){
    //                 if(nums[i] == nums[j]) cnt++;
    //             }
    //             if(cnt > n/3) ls.add(nums[i]);
    //         }
    //         if(ls.size() == 2) break;
    //     }
    //     return ls;
    // }
    
    
    //Better Solution T.C = O(n*logn) and S.C = O(n)
//     public static List<Integer> majorityElement(int[] nums) {
//         int n = nums.length;
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         List<Integer> ls = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1); //Insertion in map takes log*n times 
//             if(ls.size() == 0 || ls.get(0) != nums[i]){
//                 if(hm.get(nums[i]) > n/3) ls.add(nums[i]);
//             }
//             if(ls.size()==2)break;
//         }
//         return ls;
//     }
    
    
    //Optimal Approach (Moore's Voting) T.C = O(n) and S.C = O(1)
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, ele1 = Integer.MIN_VALUE , cnt2 = 0, ele2 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(cnt1 == 0 && ele2 != nums[i]){
                ele1 = nums[i];
                cnt1++;
            }
            else if(cnt2 == 0 && ele1 !=nums[i]){
                 ele2 = nums[i];
                 cnt2++;
            } 
            else if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else{
                cnt1--; cnt2--;
            }
        }
        List<Integer> ls = new ArrayList<>();
        //Verification 
        int cnttt1 = 0, cnttt2 = 0;
        for(int i = 0; i < n; i++){
            if(ele1 == nums[i]) cnttt1++;
            if(ele2 == nums[i]) cnttt2++;
        }
        if(cnttt1 > n/3) ls.add(ele1);
        if(cnttt2 > n/3) ls.add(ele2);
        return ls;
    }

    public static void main(String args[]) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
