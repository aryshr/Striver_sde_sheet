package Arrays.Part_1;

public class Find_Duplicate_Number {
    // Brute force T.C = O(nlogn) + O(n) and S.C = O(1)
    // public static int findDuplicate(int[] nums) {
    // Arrays.sort(nums);
    // for(int i = 0; i < nums.length; i++){
    // if(nums[i] == nums[i+1]) return nums[i];
    // }
    // return -1;
    // }

    // Better Approach T.C = O(n) and S.C = O(n)
    /*
     * For HashSet, LinkedHashSet, and EnumSet, the add(), remove() and contains()
     * operations cost constant O(1) time thanks to the internal HashMap
     * implementation. Likewise, the TreeSet has O(log(n)) time complexity
     */

    // public static int findDuplicate(int[] nums){
    // HashSet<Integer> set = new HashSet<>();
    // for(int i: nums){
    // if(set.contains(i)) return i;
    // set.add(i);
    // }
    // return -1;
    // }

    // Optimal Approach T.C = O(n) and S.C = O(1)
    public static int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        hare = nums[0];
        while (hare != tortoise) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }

        return tortoise;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2, 2 };
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }
}
