class MyQueue{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor
    MyQueue(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void stack2ToStack1(){
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    // Push element x to the back of queue
    public void push(int x){
        stack2.push(x);
    }

    // Removes the element from in front of queue
    public void pop(){
        if(stack1.empty()){
            stack2ToStack1();
        }
        stack1.pop();
    }

    // Get the front element
    public int peek(){
        if(stack1.empty()){
            stack2ToStack1();
        }
        return stack1.peek();
    }

    // Returns whether the queue is empty
    public boolean empty(){
        return stack1.empty() && stack2.empty();
    }
}