package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;

import pl.pharmaway.prezentacjatrilac.animation.AnimationOperator;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page4 extends FooterActivity {

    private View red1;
    private View red2;
    private View red3;
    private View red_icon1;
    private View red_icon2;
    private View red_icon3;
    private View red_label1;
    private View red_label2;
    private View red_label3;
    private int selectedIndex = -1;

    private final float enabledAlpha = 0.6f;
    private AnimationOperator inAnimator60 = new AnimationOperator() {
        @Override
        public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
            return animator.alpha(0.6f);
        }
    };
    private Cancelable aniamtion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View arrow1 = findViewById(R.id.blue_strzalka1);
        View arrow2 = findViewById(R.id.blue_strzalka2);

        red1 = findViewById(R.id.blue1);
        red2 = findViewById(R.id.blue2);
        red3 = findViewById(R.id.blue3);
        red_icon1 = findViewById(R.id.red_icon1);
        red_icon2 = findViewById(R.id.red_icon2);
        red_icon3 = findViewById(R.id.red_icon3);
        red_label1 = findViewById(R.id.blue_label1);
        red_label2 = findViewById(R.id.blue_label2);
        red_label3 = findViewById(R.id.blue_label3);

        setListeners();

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
            animateIn(500, inAnimator, arrow1);
            animateIn(500, inAnimator, arrow2);
            aniamtion = animateIn(1500, inAnimator60,
                    red_icon1, red_label1,
                    red_icon2, red_label2,
                    red_icon3, red_label3
            );
        } else {
            selectedIndex = savedInstanceState.getInt("selectedIndex", -1);
            selectIndex(selectedIndex);
        }
    }

    private void setListeners() {
        red_label1.setOnClickListener(index1ClickListener);
        red_label2.setOnClickListener(index2ClickListener);
        red_label3.setOnClickListener(index3ClickListener);
        red_icon1.setOnClickListener(index1ClickListener);
        red_icon2.setOnClickListener(index2ClickListener);
        red_icon3.setOnClickListener(index3ClickListener);
    }

    View.OnClickListener index1ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectIndex(1);
        }
    };
    View.OnClickListener index2ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectIndex(2);
        }
    };
    View.OnClickListener index3ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectIndex(3);
        }
    };

    private void selectIndex(int index) {
        if(aniamtion != null) aniamtion.cancel();

        selectedIndex = index;
        red1.setAlpha(index == 1 ? 1.0f : 0);
        red2.setAlpha(index == 2 ? 1.0f : 0);
        red3.setAlpha(index == 3 ? 1.0f : 0);
        red_icon1.setAlpha(index == 1 ? 1.0f : enabledAlpha);
        red_icon2.setAlpha(index == 2 ? 1.0f : enabledAlpha);
        red_icon3.setAlpha(index == 3 ? 1.0f : enabledAlpha);
        red_label1.setAlpha(index == 1 ? 1.0f : enabledAlpha);
        red_label2.setAlpha(index == 2 ? 1.0f : enabledAlpha);
        red_label3.setAlpha(index == 3 ? 1.0f : enabledAlpha);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selectedIndex", selectedIndex);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page4;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page5.class;
    }
}
