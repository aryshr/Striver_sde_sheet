package Arrays.Part_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
     //Brute force approach T.C = O(nlogn + 2n) and S.C = O(n)
//     public static int[][] merge(int[][] intervals) {
//         int n = intervals.length;
        
//         List<int[]> ans = new ArrayList<>();
//         Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        
//         // for (int i = 0; i < n; i++)
//         //     System.out.println(intervals[i][1]+" ");
        
//         for(int i = 0; i < n; i++){
//             int start = intervals[i][0];
//             int end = intervals[i][1];
//             if(ans.size() > 0 && end <= ans.get(ans.size()-1)[1]){
//                 continue;
//             }
            
//             for(int j = i+1; j < n; j++){
//                 if(intervals[j][0] <= end){
//                     end = Math.max(end, intervals[j][1]);
//                 }
//                 else{
//                     break;
//                 }
//             }
//             ans.add(new int[]{start, end});
//         }
        
        
//         int[][]res = new int[ans.size()][];
//         for (int i = 0; i < res.length; i++)
//             res[i] = ans.get(i);
//         return res;
        
//     }
    
    
    //optimal approach T.C = O(nlogn + n) and S.C = O(n) 
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        
        // for (int i = 0; i < n; i++)
        //     System.out.println(intervals[i][1]+" ");
        
        for(int i = 0; i < n; i++){
            if(ans.size() == 0 || intervals[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
            }
            else{
                int end = Math.max(intervals[i][1], ans.get(ans.size()-1)[1]);
                ans.get(ans.size()-1)[1] = end;
            }
        }
        
        
        int[][]res = new int[ans.size()][];
        for (int i = 0; i < res.length; i++)
            res[i] = ans.get(i);
        return res;
        
    }

    public static void main(String[] args){
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] ans = merge(arr);
        System.out.print("The merged intervals are: \n");
        for (int it[] : ans) {
            System.out.print("[" + it[0] + ", " + it[1] + "] ");
        }
        System.out.println();
    }
}
