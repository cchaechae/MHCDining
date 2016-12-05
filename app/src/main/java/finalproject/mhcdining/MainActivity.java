package finalproject.mhcdining;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {



    private Button mRefreshButton;
    private DiningHalls mDiningHallss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mDiningHallss = new DiningHalls();

        RelativeLayout ll = (RelativeLayout) findViewById(R.id.activity_main);

        DrawingView ov = new DrawingView(this);
        ll.addView(ov);

        mRefreshButton = (Button) findViewById(R.id.refresh);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDiningHallss.updateDiningHalls();

                RelativeLayout ll = (RelativeLayout) findViewById(R.id.activity_main);

                DrawingView ov = new DrawingView(ll.getContext());
                ll.addView(ov);
            }
        };
        mRefreshButton.setOnClickListener(listener);
    }



    public class DrawingView extends View {

        public DrawingView(Context context) {
            super(context);
        }

//        public DrawingView(Context context, AttributeSet attrs, int defStyle) {
//            super(context, attrs, defStyle);
//        }
//
//        public DrawingView(Context context, AttributeSet attrs) {
//            super(context, attrs);
//        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(22);
            paint.setAntiAlias(true);

            //Abbey
            canvas.drawCircle(290, 490, 170, paint);
            //Rocky
            canvas.drawCircle(800, 490, 170, paint);
            //Wilder
            canvas.drawCircle(290, 1000, 170, paint);
            //Ham
            canvas.drawCircle(800, 1000, 170, paint);
            //Prospect
            canvas.drawCircle(290, 1500, 170, paint);

            //MacGregor
            canvas.drawCircle(800, 1500, 170, paint);

            //Abbey
            paint.setColor(Color.YELLOW);
            float radius = (float)(170*0.58);
            canvas.drawCircle(290, 490, radius, paint);

            //Rocky
            paint.setColor(Color.YELLOW);
            radius = (float)(170*0.60);
            canvas.drawCircle(800, 490, radius, paint);

            //Wilder
            paint.setColor(Color.GREEN);
            radius = (float)(170*0.05);
            canvas.drawCircle(290, 1000, radius, paint);

            //Ham
            paint.setColor(Color.GREEN);
            radius = (float)(170*0.08);
            canvas.drawCircle(800, 1000, radius, paint);

            //Prospect
            paint.setColor(Color.BLUE);
            //canvas.drawCircle(290, 1500, 170/100*mDiningHallss.getPercentage(0), paint);

            //MacGregor
            paint.setColor(Color.BLUE);
            radius = (float)(170*0.11);
            canvas.drawCircle(800, 1500, radius, paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize(100);
            canvas.drawText("58%", 220, 525, paint);
            canvas.drawText("60%", 730, 525, paint);
            canvas.drawText("5%", 220, 1035, paint);
            canvas.drawText("8%", 730, 1035, paint);
            canvas.drawText("22%", 220, 1535, paint);
            canvas.drawText("11%", 730, 1535, paint);
        }
    }

}