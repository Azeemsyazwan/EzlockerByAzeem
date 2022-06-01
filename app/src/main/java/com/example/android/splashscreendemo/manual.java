package com.example.android.splashscreendemo;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class manual extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



            addFragment(new PermissionStep.Builder()
                    .setPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
                    .setTitle("Manual EzLocker")
                    .setContent("User Guidance For Ez Locker")
                    .setBackgroundColor(Color.parseColor("#1098FE"))
                    //.setDrawable(R.drawable.imgteam)
                    .build());


            addFragment(new Step.Builder().setTitle("Register!")
                    .setContent("Register Account For A First Time User")
                    .setBackgroundColor(Color.parseColor("#1098FE"))
                    .setDrawable(R.drawable.img1)
                    .setSummary("First Step")
                    .build());

            addFragment(new Step.Builder()
                    .setTitle("Select Locker And Scan!")
                    .setContent("Select And Scan Only Available Locker")
                    .setBackgroundColor(Color.parseColor("#1098FE"))
                    .setDrawable(R.drawable.imglocker)
                    .setSummary("Second Step")
                    .build());

            addFragment(new Step.Builder()
                    .setTitle("Lock!")
                    .setContent("Insert Your Item And Press Lock Button")
                    .setBackgroundColor(Color.parseColor("#1098FE"))
                    .setDrawable(R.drawable.img2)
                    .setSummary("Third Step")
                    .build());

            addFragment(new Step.Builder()
                    .setTitle("Pay!")
                    .setContent("Press Pay Button To Get Your Item Back")
                    .setBackgroundColor(Color.parseColor("#1098FE"))
                    .setDrawable(R.drawable.img3)
                    .setSummary("Last Step")
                    .build());

        }

         @Override
        public void finishTutorial() {
            Toast.makeText(this, "Tutorial finished", Toast.LENGTH_SHORT).show();
            finish();
        }

           public void currentFragmentPosition(int position) {
           Toast.makeText(this,"Position : " + position,Toast.LENGTH_SHORT).show();
          }
}
