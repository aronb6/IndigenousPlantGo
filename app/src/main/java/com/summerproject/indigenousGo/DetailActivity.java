package com.summerproject.indigenousGo;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private Intent intent;
    private ImageView imageView;
    private TextView textView1;
    private ImageButton imgPlay;

    SoundPool soundPool1, soundPool2, soundPool3, soundPool4, soundPool5, soundPool6, soundPool7, soundPool8, soundPool9 ;
    int soundPlay1, soundPlay2, soundPlay3, soundPlay4, soundPlay5, soundPlay6, soundPlay7, soundPlay8, soundPlay9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // MainActivity에서 보낸 imgRes를 받기위해 getIntent()로 초기화
        intent = getIntent();
        imageView = (ImageView) findViewById(R.id.imageView);
        textView1 = (TextView) findViewById(R.id.textViewDetail1);
        imgPlay = (ImageButton) findViewById(R.id.imgPlay);

        // "imgRes" key로 받은 값은 int 형이기 때문에 getIntExtra(key, defaultValue);
        // 받는 값이 String 형이면 getStringExtra(key);
        imageView.setImageResource(intent.getIntExtra("imgRes", 0));
        System.out.println(intent.getIntExtra("imgRes", 0));


        soundPool1  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay1 = soundPool1.load(this, R.raw.coastalstrawberry, 1);

        soundPool2  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay2 = soundPool2.load(this, R.raw.kinnikinnick, 1);

        soundPool3  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay3 = soundPool3.load(this, R.raw.snowberry, 1);

        soundPool4  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay4 = soundPool4.load(this, R.raw.coniferoustrees, 1);

        soundPool5  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay5 = soundPool5.load(this, R.raw.dandelion, 1);

        soundPool6  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay6 = soundPool6.load(this, R.raw.swordferns, 1);

        soundPool7  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay7 = soundPool7.load(this, R.raw.lavendar, 1);

        soundPool8  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay8 = soundPool8.load(this, R.raw.salal, 1);

        soundPool9  = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPlay9 = soundPool9.load(this, R.raw.westernwedcedar, 1);




        if (intent.getIntExtra("imgRes", 0) == 2131230825) {
            textView1.setText("This evergreen ground cover has three leaves, and white flowers that bloom in the summer.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool1.play(soundPlay1, 1f, 1f, 0, 0, 1f);
                }
            });
        } else if (intent.getIntExtra("imgRes", 0) == 2131230868) {
            textView1.setText("Kinnikinnick is an evergreen ground cover. It has small white or pink flowers that typically bloom in May and June, and red berries later in the season.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool2.play(soundPlay2, 1f, 1f, 0, 0, 1f);
                }
            });
        }
        else if (intent.getIntExtra("imgRes", 0) == 2131230903) {
            textView1.setText("These shrubs have white flowers in spring, and white berries through the fall and winter.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool3.play(soundPlay3, 1f, 1f, 0, 0, 1f);
                }
            });
        }
        else if (intent.getIntExtra("imgRes", 0) == 2131230845) {
            textView1.setText("Sometimes called evergreens, most coniferous trees keep their foliage year-round. Products made from coniferous trees include paper, many kinds of lumber, furniture and anti-cancer drugs.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool4.play(soundPlay4, 1f, 1f, 0, 0, 1f);
                }
            });
        }
        else if (intent.getIntExtra("imgRes", 0) == 2131230846) {
            textView1.setText("Dandelion [Fr, dent-de-lion, \"lion's tooth\"], perennial, herbaceous plant of family Compositae or Asteraceae. Valued for its medicinal properties, the dandelion has been used to stimulate the kidneys and to combat liver disorders, weak digestion, anemia and eczema.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool5.play(soundPlay5, 1f, 1f, 0, 0, 1f);
                }
            });
        }
        else if (intent.getIntExtra("imgRes", 0) == 2131230904) {
            textView1.setText("Sword fern gets its name from its elongated blade-like fronds. The robust, handsome leaves can grow several feet long and the plant can have as many as a hundred leaves. This plant can be used as a pain reliever!");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool6.play(soundPlay6, 1f, 1f, 0, 0, 1f);
                }
            });
        }
        else if (intent.getIntExtra("imgRes", 0) == 2131230869) {
            textView1.setText("Lavander is a prerennial shrub with purple flowers that bloom during the summer.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool7.play(soundPlay7, 1f, 1f, 0, 0, 1f);
                }
            });
        }

        else if (intent.getIntExtra("imgRes", 0) == 2131230902) {
            textView1.setText("Salal is a perennial evergreen shrub.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool8.play(soundPlay8, 1f, 1f, 0, 0, 1f);
                }
            });
        }
        else if (intent.getIntExtra("imgRes", 0) == 2131230930) {
            textView1.setText("Western Red Cedar is a large evergreen tree. The Western Red Cedar has been called \"the cornerstone of Northwest Coast aboriginal culture,\" and has great spiritual significance. Coastal people used all parts of the tree. They used the wood for dugout canoes, house planks, bentwood boxes, clothing, and many tools such as arrow shafts, masks, and paddles.");
            imgPlay.setOnClickListener(new ImageButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPool9.play(soundPlay9, 1f, 1f, 0, 0, 1f);
                }
            });
        }
   /*     switch(intent.getIntExtra("imgRes", 0)) {
            case 2131230825:
                textView1.setText("1");
            case 2131230868:
                textView1.setText("2");
            case 2131230903:
                textView1.setText("3");
            case 2131230845:
                textView1.setText("4");
            case 2131230846:
                textView1.setText("5");
            case 2131230904:
                textView1.setText("6");
            case 2131230869:
                textView1.setText("7");
            case 2131230902:
                textView1.setText("8");
            case 2131230930:
                textView1.setText("9");

        } */
    }
}