package Arrays.Part_1;

public class Next_Permutation {
    public static void nextPermutation(int[] a) {

        /*Brute force will be using recursion by generating all possibe permutations and then apply linear search and find the next
        permutation of the given array */

        //optimal solution
        //T.C = O(3N) and S.C = O(N) incl. array or O(1) excl. array
        
        int n = a.length;
        int ind = -1;
        
        //finding the first smaller element from last 
        for(int i = n-2; i >= 0; i--){
            if(a[i] < a[i+1]){
                ind = i;
                break;
            }
        }
        
        if(ind == -1){
            int low = ind+1;
            int high = n-1;
            while(low <= high){
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            }
        }else{
        
            //finding the least greater element than a[ind] from last
            for(int i = n-1; i >= ind; i--){
                if(a[i] > a[ind]){
                    int temp = a[i];
                    a[i] = a[ind];
                    a[ind] = temp;
                    break;
                }
            }

            //reverse the right part of ind
            int low = ind+1;
            int high = n-1;
            while(low <= high){
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            }
        }
    }

    public static void main(String[]args){
        int[] arr = new int[]{2,1,5,4,3,0,0};
        nextPermutation(arr);
        for(int i: arr)
            System.out.print(i+" ");
    }
}

