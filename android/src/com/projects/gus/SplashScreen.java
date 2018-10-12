package com.projects.gus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends Activity {
  private static int SPLASH_TIME_OUT = 5000;
  ImageView img;

  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_splash);
    this.img = (ImageView)findViewById(R.id.imgIcon);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent(SplashScreen.this, Menu.class);
        SplashScreen.this.startActivity(localIntent);
        SplashScreen.this.finish();
      }
    }, SPLASH_TIME_OUT);
  }
}

