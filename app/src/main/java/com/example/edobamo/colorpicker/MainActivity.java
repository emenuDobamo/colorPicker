package com.example.edobamo.colorpicker;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    View view1;
    SeekBar red_seekbar;
    SeekBar blue_seekbar;
    SeekBar green_seekbar;
    CardView cardView;
    GridLayout grid_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red_seekbar = (SeekBar) findViewById(R.id.redSeek);
        blue_seekbar = (SeekBar) findViewById(R.id.blueSeek);
        green_seekbar = (SeekBar) findViewById(R.id.greenSeek);
        grid_layout = (GridLayout) findViewById(R.id.grid);
        CardView cardView00 = (CardView) findViewById(R.id.card00);
        cardView = (CardView) findViewById(R.id.card);
        Toast.makeText(getApplicationContext(), "Long press to pick color", Toast.LENGTH_LONG).show();

        long_clicked(cardView);

        view1 = (View) findViewById(R.id.frame);

        colorChanger(cardView);


    }

    public void long_clicked(CardView view) {

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                pop_up(view, (int) view.getX(), (int) view.getY());
                return true;
            }
        });
    }


    public void colorChanger(final View view) {

        red_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView redHex = (TextView) findViewById(R.id.redHex);
                int redNum = red_seekbar.getProgress();
                redHex.setText(String.valueOf(Integer.toHexString(redNum)));
                TextView redtext = (TextView) findViewById(R.id.redNum);

                redtext.setText(String.valueOf(redNum));
                view.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
                cardView.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));


                TextView textView = (TextView) findViewById(R.id.text00);
                textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                colorChanger(view);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView textView = (TextView) findViewById(R.id.text00);
                textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                colorChanger(view);

            }
        });

        blue_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView blueHex = (TextView) findViewById(R.id.blueHex);
                int blueNum = blue_seekbar.getProgress();
                TextView bluetext = (TextView) findViewById(R.id.blueNum);
                blueHex.setText(String.valueOf(Integer.toHexString(blueNum)));
                bluetext.setText(String.valueOf(blueNum));
                cardView.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                view.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                TextView textView = (TextView) findViewById(R.id.text00);
                textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                colorChanger(view);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView textView = (TextView) findViewById(R.id.text00);
                textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                colorChanger(view);

            }
        });

        green_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView greenHex = (TextView) findViewById(R.id.greenHex);
                TextView greentext = (TextView) findViewById(R.id.greenNum);
                int greenNum = green_seekbar.getProgress();
                greenHex.setText(String.valueOf(Integer.toHexString(greenNum)));
                greentext.setText(String.valueOf(greenNum));

                cardView.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                view.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
                Log.i(String.valueOf(view.getId()), "id");

                Integer.toHexString(greenNum);

                TextView textView = (TextView) findViewById(R.id.text00);
                textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                colorChanger(view);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextView textView = (TextView) findViewById(R.id.text00);
                textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

                colorChanger(view);


            }
        });


    }


    public void clicked00(View view) {
        TextView textView = (TextView) findViewById(R.id.text00);
        // pop_up(view, ((int) view.getX()), (int) view.getY());
//       textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        long_clicked((CardView) view);
        ((CardView) view).setTranslationZ(20);

        colorChanger(view);


    }

    public void clicked01(View view) {
        TextView textView = (TextView) findViewById(R.id.text01);
        long_clicked((CardView) view);

        textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        // pop_up(view, ((int) view.getX()), (int) view.getY());
        // if(okClicked(view))
        colorChanger(view);
    }

    public void clicked10(View view) {
        TextView textView = (TextView) findViewById(R.id.text10);
        long_clicked((CardView) view);

        textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        //pop_up(view, ((int) view.getX()), (int) view.getY());
        // if(okClicked(view))
        colorChanger(view);

    }

    public void clicked11(View view) {
        TextView textView = (TextView) findViewById(R.id.text11);
        long_clicked((CardView) view);

        // textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        //pop_up(view, ((int) view.getX()), (int) view.getY());
        // // if(okClicked(view))
        colorChanger(view);
    }

    public void clicked20(View view) {
        TextView textView = (TextView) findViewById(R.id.text20);
        long_clicked((CardView) view);

        textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        //pop_up(view, ((int) view.getX()), (int) view.getY());
        // if(okClicked(view))
        colorChanger(view);
    }

    public void clicked21(View view) {
        TextView textView = (TextView) findViewById(R.id.text21);
        long_clicked((CardView) view);

        textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        //pop_up(view, ((int) view.getX()), (int) view.getY());
        // if(okClicked(view))
        colorChanger(view);
        Intent intent ;
    }

    public void clicked30(View view) {
        TextView textView = (TextView) findViewById(R.id.text30);
        long_clicked((CardView) view);

        textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        open_window(view);

        //pop_up(view, ((int) view.getX()), (int) view.getY());

        colorChanger(view);
    }

    public void clicked31(View view) {
        TextView textView = (TextView) findViewById(R.id.text31);
        textView.setText(color_name(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));
        long_clicked((CardView) view);
        open_window(view);
        // if(okClicked(view))
        colorChanger(view);
    }

    public void open_window(View view) {
        view.setTranslationZ(20);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        view.setAnimation(animation);
        animation.start();


    }


    public Drawable pop_up(View view, int x, int y) {
        int cx = view1.getWidth();
        int cy = view1.getHeight();
        float radius = (float) Math.hypot(cx, cy);

        Animator animator = ViewAnimationUtils.createCircularReveal(view1, x, y, 0, radius);
        if (view1.getVisibility() == View.INVISIBLE) {
            view1.setVisibility(View.VISIBLE);
            animator.start();
            grid_layout.setAlpha(0.1f);
        } else {
            if (view1.getVisibility() == View.VISIBLE) {
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(view1, cx, cy, radius, 0);

                anim.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view1.setVisibility(View.INVISIBLE);

                    }
                });


                anim.start();
                grid_layout.setAlpha(1f);
            }
        }

        return view.getBackground();


    }

    public boolean okClicked(View view) {
        final SeekBar red_seekbar = (SeekBar) findViewById(R.id.redSeek);
        final SeekBar blue_seekbar = (SeekBar) findViewById(R.id.blueSeek);
        final SeekBar green_seekbar = (SeekBar) findViewById(R.id.greenSeek);
        grid_layout.setAlpha(1f);
        int cx = view1.getWidth();
        int cy = view1.getHeight();
        float radius = (float) Math.hypot(cx, cy);


        if (view1.getVisibility() == View.VISIBLE) {
            Animator anim =
                    ViewAnimationUtils.createCircularReveal(view1, cx, cy, radius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view1.setVisibility(View.INVISIBLE);


                }
            });
            anim.start();
            grid_layout.setAlpha(1f);

            final View view1 = findViewById(R.id.frame);
            view1.setVisibility(View.INVISIBLE);
            view1.setBackgroundColor(Color.rgb(red_seekbar.getProgress(), green_seekbar.getProgress(), blue_seekbar.getProgress()));

        }
        return true;
    }

    public void floating_action_clicked(View view) {

        pop_up(view, 150, 150);
    }

    public String color_name(int r, int g, int b) {
        TextView textView = (TextView) findViewById(R.id.text00);

        if (r < 30) {
            if (g < 30) {
                if (b < 30) {
                    return "BLACK";
                }
                return "BLUE";
            }
            return "GREEN";
        } else
            return "RED";

    }}
