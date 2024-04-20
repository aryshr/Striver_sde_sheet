package Arrays.Part_1;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    //T.C = O(n^2) and S.C = O(n)
    public static int lengthOfLongestSubstring(String s){
        if(s.length()==0)
             return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) 
        {
            Set < Character > se = new HashSet < > ();
            for (int j = i; j < s.length(); j++) 
            
            {
                if (se.contains(s.charAt(j))) 
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(s.charAt(j));
            }
        }
        return maxans;
    }
    // T.C = O(2*n) and S.C = O(n)
    // public static int lengthOfLongestSubstring(String s) {
    //     int n = s.length();
    //     Set<Character> set = new HashSet<Character>();
    //     int left = 0;
    //     int maxLen = 0;
    //     for(int right = 0; right < n; right++){
    //         if(set.contains(s.charAt(right))){
    //             while(set.contains(s.charAt(right))){
    //                 set.remove(s.charAt(left));
    //                 left++;
    //             }
    //         }
    //         else{
    //             maxLen = Math.max(maxLen, right-left+1);
    //         }
    //         set.add(s.charAt(right));
    //     }
    //     return maxLen;
    // }
    
    
    //T.C = O(n) and S.C = O(n)
    // public static int lengthOfLongestSubstring(String s){
    //     int n = s.length();
    //     HashMap<Character, Integer> hm = new HashMap<>();
    //     int left = 0;
    //     int maxlen = 0;
    //     for(int right = 0; right < n; right++){
    //         if(!hm.containsKey(s.charAt(right)) || hm.get(s.charAt(right)) < left){
    //             hm.put(s.charAt(right), right);
    //             maxlen = Math.max(maxlen, right-left+1);
    //         }
    //         else{
    //             left = hm.get(s.charAt(right))+1;
    //             hm.put(s.charAt(right), right);
    //         }
    //     }
    //     return maxlen;
    // }

    
    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + lengthOfLongestSubstring(str));
    }
}

