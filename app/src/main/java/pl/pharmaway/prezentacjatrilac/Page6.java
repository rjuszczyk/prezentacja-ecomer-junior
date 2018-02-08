package pl.pharmaway.prezentacjatrilac;

public class Page6 extends FooterActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page6;
    }

    @Override
    protected Class<?> getNextActivity() {
        return FormActivity.class;
    }
}
