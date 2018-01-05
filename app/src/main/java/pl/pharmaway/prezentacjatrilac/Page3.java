package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page3 extends FooterActivity {
    @Override
    protected long getDelay() {
        return 250;
    }
    @Override
    protected long getDuration() {
        return 750;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View arrow1 = findViewById(R.id.red_strzalka1);
        View arrow2 = findViewById(R.id.red_strzalka2);

        View red1 = findViewById(R.id.red1);
        View red2 = findViewById(R.id.red2);
        View red3 = findViewById(R.id.red3);
        View red_icon1 = findViewById(R.id.red_icon1);
        View red_icon2 = findViewById(R.id.red_icon2);
        View red_icon3 = findViewById(R.id.red_icon3);
        View red_label1 = findViewById(R.id.red_label1);
        View red_label2 = findViewById(R.id.red_label2);
        View red_label3 = findViewById(R.id.red_label3);

        if (savedInstanceState == null) {
            setInvisible(
                    arrow1,
                    arrow2,
                    red1,
                    red2,
                    red3,
                    red_icon1,
                    red_icon2,
                    red_icon3,
                    red_label1,
                    red_label2,
                    red_label3);
            animateIn(500, inAnimator, arrow2);
            animateIn(500, inAnimator,
                    arrow1,
                    red_icon1, red_label1, red1,
                    red_icon2, red_label2, red2,
                    red_icon3, red_label3, red3
                    );
        } else {
            setVisible(
                    arrow1,
                    arrow2,
                    red1,
                    red2,
                    red3,
                    red_icon1,
                    red_icon2,
                    red_icon3,
                    red_label1,
                    red_label2,
                    red_label3);
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page3;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page4.class;
    }
}
