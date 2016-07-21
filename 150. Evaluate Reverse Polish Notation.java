public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;      // corner case
        
        int a, b;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String s : tokens){
            if(s.equals("+")){
                stack.add(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }else if(s.equals("*")){
                stack.add(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }else{
                stack.add(Integer.parseInt(s));
            }
        }
        
        return stack.pop();
    }
}