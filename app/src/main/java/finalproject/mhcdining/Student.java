package finalproject.mhcdining;

/**
 * Created by Sujin on 12/3/2016.
 */

public class Student {
    private int mArrivaltime;
    private int mTime;

    public Student(int arrivaltime, int time)
    {
        this.mArrivaltime = arrivaltime;
        this.mTime = time;
    }

    public int getArrivalTime()
    {
        return mArrivaltime;
    }

    public int getTime()
    {
        return mTime;
    }
}
