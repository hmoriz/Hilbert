package jp.ac.titech.itpro.sdl.hilbert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView levelView;
    private HilbertView hilbertView;
    private final static int MAX_N = 9;
    private int n = 1;
    private static final String TAG = "MainActivity";
    private static final String KEY_N = "MainActivity.n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            n = savedInstanceState.getInt(KEY_N, 1);
        }
        setContentView(R.layout.activity_main);
        levelView = (TextView)findViewById(R.id.level_view);
        hilbertView = (HilbertView)findViewById(R.id.hilbert_view);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        display();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_N, n);
    }

    public void onClickDec(View v) {
        if (n > 1) n--;
        display();
    }

    public void onClickInc(View v) {
        if (n < MAX_N) n++;
        display();

    }

    private void display() {
        levelView.setText(getString(R.string.level_format, n));
        hilbertView.setLevel(n);
    }
}
