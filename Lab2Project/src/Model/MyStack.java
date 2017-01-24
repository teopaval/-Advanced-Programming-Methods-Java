package Model;

/**
 * Created by teo on 10/16/2016.
 */
public class MyStack<T> implements IMyStack<T> {
    protected T[] data;
    protected int index;

    public MyStack(int size) {
        this.data = (T[])(new Object[size]);
        this.index = 0;
    }

    @Override
    public boolean isEmpty() {
        if (index == 0)
            return true;
        return false;
    }

    @Override
    public T pop() {
        if (this.isEmpty())
            return null; //throw exception
        index--;
        return data[index];
    }

    @Override
    public void push(T object) {
        if(index==data.length)
            return; //throw exception or resize array
        data[index] = object;
        index++;
    }

    @Override
    public String toString() {
        String items = "";
        for(T i : data)
            if (i == null)
                break;
            else
                items += i.toString() + "\n";
        return items;
    }
}
