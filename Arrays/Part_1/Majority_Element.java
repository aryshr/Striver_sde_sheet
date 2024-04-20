package Arrays.Part_1;

public class Majority_Element {

    // public static int majorityElement(int[] nums) {
    // // Brute force T.C = O(n^2) and S.C = O(1)
    // int n = nums.length;
    // for(int i = 0; i < n; i++){
    // int cnt = 0;
    // for(int j = 0; j < n; j++){
    // if(nums[i] == nums[j]) cnt++;
    // }
    // if(cnt > n/2) return nums[i];
    // }
    // return -1;
    // }

    // Better Solution T.C = O(n*logn) and S.C = O(n)
    // public static int majorityElement(int[] nums) {
    // int n = nums.length;
    // HashMap<Integer, Integer> hm = new HashMap<>();
    // for(int i = 0; i < n; i++){
    // hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1); //Insertion in map takes
    // log*n times
    // if(hm.get(nums[i]) > n/2) return nums[i];
    // }
    // return -1;
    // }

    // Optimal Approach (Moore's Voting) T.C = O(n) and S.C = O(1)
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0, ele = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                ele = nums[i];
                cnt++;
            } else if (nums[i] == ele)
                cnt++;
            else {
                cnt--;
            }
        }

        // Verification
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (ele == nums[i])
                cnt1++;
        }
        if (cnt1 > n / 2)
            return ele;
        return -1;
    }
    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
    }
}
