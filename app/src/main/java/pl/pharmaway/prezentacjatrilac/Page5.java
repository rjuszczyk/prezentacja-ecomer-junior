package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page5 extends FooterActivity {

    protected long getDelay() {
        return 250;
    }

    protected long getDuration() {
        return 700;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View title1 = findViewById(R.id.title1);
        View title2 = findViewById(R.id.title2);
        View title3 = findViewById(R.id.title3);
        View title4 = findViewById(R.id.title4);
        View title5 = findViewById(R.id.title5);
        View green1 = findViewById(R.id.green1);
        View green2 = findViewById(R.id.green2);
        View green3 = findViewById(R.id.green3);
        View green_icon1 = findViewById(R.id.green_icon1);
        View green_icon2 = findViewById(R.id.green_icon2);
        View green_icon3 = findViewById(R.id.green_icon3);

        if (savedInstanceState == null) {
            setInvisible(
                    title1,
                    title2,
                    title3,
                    title4,
                    title5,
                    green1,
                    green2,
                    green3,
                    green_icon1,
                    green_icon2,
                    green_icon3
                    );

            title1.animate().alpha(1).setStartDelay(500).setDuration(1000).start();
            title2.animate().alpha(1).setStartDelay(500).setDuration(1000).start();
            title3.animate().alpha(1).setStartDelay(500).setDuration(1000).start();
            title4.animate().alpha(1).setStartDelay(500).setDuration(1000).start();
            title5.animate().alpha(1).setStartDelay(500).setDuration(1000).start();

            animateIn(1500, inAnimator,
                    green_icon1, green1,
                    green_icon2, green2,
                    green_icon3, green3
            );
        } else {
            setVisible(
                    title1,
                    title2,
                    title3,
                    title4,
                    title5,
                    green1,
                    green2,
                    green3,
                    green_icon1,
                    green_icon2,
                    green_icon3
            );
        }
    }
    

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page5;
    }

    @Override
    protected Class<?> getNextActivity() {
        return FormActivity.class;
    }
}
