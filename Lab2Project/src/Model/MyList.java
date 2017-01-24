package Model;

/**
 * Created by teo on 10/16/2016.
 */
public class MyList<T> implements IMyList<T> {
    protected
    T[] data;
    int index;

    public MyList(int size) {
        data = (T[])(new Object[size]);
        index = 0;
    }

    @Override
    public void add(T object) {
        if(index == this.data.length)
            return; //throw exception or resize
        data[index] = object;
    }

    @Override
    public void remove(int pos) {
        if (index == 0)
            return; // throw exception
        for(int i = pos; i < index; i++)
            data[i] = data[i+1];
    }

    @Override
    public T get(int pos) {
        if (pos >= index || pos < 0)
            return null; //throw exception or something
        return data[pos];
    }

    @Override
    public String toString() {
        String items = "";
        for(T i : data)
            if (i == null)
                break;
            else
                items+=i.toString() + "\n";
        return items;
    }
}
