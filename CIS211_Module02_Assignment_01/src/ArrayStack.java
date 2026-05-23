public class ArrayStack <T> implements Stack<T>
{
    private T[] stack;
    private int count;
    private T temp; // Variable used to store info temporarily.

    // Constructor
    public ArrayStack() {this.stack = (T[]) new Object[5];}

    // Overloaded Constructor
    public ArrayStack(int stackSize) {this.stack = (T[]) new Object[stackSize];}

    @Override
    public void push(T item) throws IllegalStateException
    {
        // Error handling when stack is full. Used the following link to understand how to use throws & try/ catch.
        // https://www.google.com/search?q=how+to+properly+use+throws+in+java&sca_esv=c04783e6906b025b&sxsrf=ANbL-n6QNsI6n_zd8bkI47wzD7AV3txo2g%3A1770074450644&ei=UjGBacX8JoOh5NoPkdm94Qo&biw=1466&bih=842&aic=0&ved=0ahUKEwjF7eyW-buSAxWDEFkFHZFsL6wQ4dUDCBE&uact=5&oq=how+to+properly+use+throws+in+java&gs_lp=Egxnd3Mtd2l6LXNlcnAiImhvdyB0byBwcm9wZXJseSB1c2UgdGhyb3dzIGluIGphdmEyCBAhGKABGMMEMggQIRigARjDBEimF1DCBFiSFnABeAGQAQCYAWCgAcACqgEBNLgBA8gBAPgBAZgCBaACxgLCAgoQABiwAxjWBBhHwgIFEAAY7wXCAggQABiABBiiBJgDAIgGAZAGCJIHATWgB4QNsgcBNLgHxQLCBwM0LjHIBwKACAA&sclient=gws-wiz-serp
        if (count >= stack.length)
        {
            throw new IllegalStateException("Error! Unable to add " + item + " to the stack due to IllegalStateException:\nStack is currently filled to capacity.");
        }

        stack[count] = item;
        count++;
        System.out.println(item + " has been successfully added to the stack.");
    }

    @Override
    public T pop()
    {
        if (count == 0) {return null;}
        else
        {
           temp = stack[count-1];
           stack[count-1] = null;
           count--;
           return temp;
        }
    }

    @Override
    public T peek()
    {
        if (count == 0) {return null;}
        else {return stack[count-1];}
    }

    @Override
    public boolean isEmpty()
    {
        if (count == 0) {return true;}
        else {return false;}
    }

    @Override
    public int length() {return count;}

    // Method used to return a string representation of the stack.
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        if  (count == 0)
        {
            text.append("[]");
            return text.toString();
        }
        else
        {
            text.append("[");
            for (int i = 0; i < count - 1; i++) {text.append(stack[i] + ", ");}
            text.append(stack[count - 1] + "]");

            return text.toString();
        }
    }
}
