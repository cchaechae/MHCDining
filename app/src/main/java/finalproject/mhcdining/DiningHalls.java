package finalproject.mhcdining;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Sujin on 12/4/2016.
 */

public class DiningHalls {

    private static final String TAG = "DiningHallActivity";

    private static final int CAPA_PROSPECT = 90;
    private static final int CAPA_ABBEY = 90;
    private static final int CAPA_WILDER = 90;
    private static final int CAPA_ROCKY = 90;
    private static final int CAPA_HAM = 90;
    private static final int CAPA_MAC = 90;

    private int[][] mDiningHalls;
    private String[] mDiningHallName = new String[]{"Prospect", "Abbey", "Wilder", "Rocky", "Ham", "Mac" };
    private int hallNumber;
    private int[] mCapacity;

    private DatabaseReference mDatabase;

    public DiningHalls()
    {
        mDiningHalls = new int[6][2];

        mCapacity = new int[]{CAPA_PROSPECT, CAPA_ABBEY, CAPA_WILDER, CAPA_ROCKY, CAPA_HAM, CAPA_MAC};
        updateDiningHalls();

        for(int i = 0; i < mDiningHallName.length; i++)
            mDiningHalls[i][1] = mCapacity[i];
    }

    public void updateDiningHalls()
    {
        for(int i = 0; i < mDiningHallName.length; i++ )
        {
            hallNumber = i;
            mDatabase.child(mDiningHallName[i]).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // Get user value
                            int p = ((Long) dataSnapshot.getValue()).intValue();
                            mDiningHalls[hallNumber][0] = p;
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "load:onCancelled", databaseError.toException());
                            // ...
                        }
                    });
        }
    }

    public int getPercentage(int hallNumber)
    {
        return (int) mDiningHalls[hallNumber][0]/mDiningHalls[hallNumber][1]*100;
    }
}
