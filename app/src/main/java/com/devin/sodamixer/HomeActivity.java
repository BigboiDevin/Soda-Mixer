package com.devin.sodamixer;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

public class HomeActivity extends Activity {

    private ScrollView scrollView;
    private LinearLayout linear;
    private final String[] sodaNames = {"Coca-cola", "Sprite", "Fanta", "Pepsi", "Diet Coke", "Dr Pepper"
    , "Minutemaid", "Mt Dew", "Pure leaf", "Root Beer", "Pepsi"};
    private int progress = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        scrollView = this.findViewById(R.id.scroll_view);
        linear = this.findViewById(R.id.linear);
        createChildLinearLayout();
    }

    private void createChildLinearLayout() {
        TypedArray sodaIconsArr = getResources().obtainTypedArray(R.array.soda_icon_array);
        for (int i = 0; i < 10; i++) {
            LinearLayout.LayoutParams linearLp = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            final LinearLayout myLinear = new LinearLayout(this);
            linearLp.setMargins(5, 0, 5, 20);
            myLinear.setOrientation(LinearLayout.VERTICAL);
            myLinear.setTag(i);
            linear.addView(myLinear, linearLp);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            final ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(sodaIconsArr.getResourceId(i, -1));
            myLinear.addView(imageView, lp);

            final LinearLayout.LayoutParams textViewLp = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);



            TextView textView = new TextView(this);
            textView.setText(sodaNames[i]);
            textView.setGravity(Gravity.CENTER);
            myLinear.addView(textView, textViewLp);

            final SeekBar seekbar = new SeekBar(this);
            seekbar.setMax(4);
            seekbar.setProgress(0);
            final TextView seekbarText  =new TextView(this);
            seekbarText.setTextSize(30);
            seekbarText.setTextColor(Color.rgb(0, 0, 0));

            myLinear.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(imageView.getBackground().getAlpha() == 128) {
                        myLinear.removeView(seekbar);
                        myLinear.removeView(seekbarText);
                        imageView.getBackground().setAlpha(255);
                    } else {
                        imageView.getBackground().setAlpha(128);
                        myLinear.addView(seekbar, textViewLp);
                        myLinear.addView(seekbarText,textViewLp);
                    }
                }
            });
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

