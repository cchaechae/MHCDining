package finalproject.mhcdining;

import java.util.LinkedList;

/**
 * Created by Sujin on 12/3/2016.
 */

public class DiningHall {
    private LinkedList<Student> mList;
    private int mCapacity;

    public DiningHall(int capacity)
    {
        this.mCapacity = capacity;
        mList = new LinkedList<Student>();
    }

    public void add( Student s )
    {
        mList.add(s);
    }

    public int getppl()
    {
        return mList.size();
    }

    public Student getFirst()
    {
        return mList.getFirst();
    }

    public void delete()
    {
        mList.removeFirst();
    }

    public boolean isEmpty()
    {
        return mList.isEmpty();
    }
}
