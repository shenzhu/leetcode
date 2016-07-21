// Method One: Built-in function
public class Solution {
    public String reverseWords(String s) {
    	if(s == null || s.length() == 0) return s;		// corner case

        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}


// Method Two: 
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        // Step 1. Reverse whole array
        reverse(arr, 0, n - 1);
        // Step 2. Reverse each word
        reverseEachWord(arr, n);
        // Step 3. Clean spaces
        return cleanSpaces(arr, n);
    }
    
    private String cleanSpaces(char[] arr, int n){
        int i = 0;
        int j = 0;
        
        while(j < n){
            while(j < n && arr[j] == ' ') j++;
            while(j < n && arr[j] != ' ') arr[i++] = arr[j++];
            while(j < n && arr[j] == ' ') j++;
            if(j < n) arr[i++] = ' ';
        }
        
        return new String(arr).substring(0, i);
    }
    
    private void reverseEachWord(char[] arr, int n){
        int i = 0;      // pointer to jump spaces
        int j = 0;      // pointer to jump non-spaces
        
        while(i < n){
            while(i < j || (i < n && arr[i] == ' ')) i++;       // jump spaces
            while(j < i || (j < n && arr[j] != ' ')) j++;       // jump non-spaces
            reverse(arr, i, j - 1);     // reverse word
        }
    }
    
    private void reverse(char[] arr, int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}