package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;

import java.util.ArrayList;
import java.util.List;

import pl.pharmaway.prezentacjatrilac.animation.AnimationOperator;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;
import pl.pharmaway.prezentacjatrilac.mvp.fake.SimpleCancelable;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

public abstract class FooterActivity extends AppCompatActivity {

    protected AnimationOperator inAnimator =  new AnimationOperator() {
        @Override
        public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
            return animator.alpha(1);
        }
    };

    @Nullable private View buttonNext;
    @Nullable private View buttonPrev;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        SYSTEM_UI_FLAG_FULLSCREEN |
                        SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(getLayoutResourceId());

        buttonPrev = findViewById(R.id.button_prev);
        buttonNext = findViewById(R.id.button_next);

        if (buttonNext != null) {
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNextClicked();
                }
            });
        }
        if (buttonPrev != null) {
            buttonPrev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPrevClicked();
                }
            });
        }
    }

    protected void onNextClicked() {
        Intent intent = new Intent(this, getNextActivity());
        startActivity(intent);
    }

    protected void onPrevClicked() {
        onBackPressed();
    }

    protected long getDelay() {
        return 500;
    }

    protected long getDuration() {
        return 1500;
    }

    protected Cancelable animateIn(long initialDelay, AnimationOperator animationOpeartor, View... paragraphs) {
        long delay = getDelay();
        long duration = getDuration();

        final List<ViewPropertyAnimator> animations = new ArrayList<>();

        for (int i = 0; i < paragraphs.length; i++) {
            View paragraph = paragraphs[i];
            ViewPropertyAnimator animation = animationOpeartor.apply(paragraph.animate())
                    .setDuration(duration)
                    .setStartDelay(initialDelay + i * delay + i * duration);
            animation.start();
            animations.add(animation);
        }

        return new Cancelable() {
            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public void cancel() {
                for (ViewPropertyAnimator animation : animations) {
                    animation.cancel();
                }
            }
        };
    }

    protected void setInvisible(View... paragraphs) {
        for (View paragraph : paragraphs) {
            paragraph.setAlpha(0);
        }
    }

    protected void setVisible(View... views) {
        for (View view : views) {
            view.setAlpha(1);
        }
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();

    protected abstract Class<?> getNextActivity();
}