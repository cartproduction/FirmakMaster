package com.application.firmak;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

  TextInputLayout inputText1;
  TextInputLayout inputText2;
  EditText regisEditText1;
  EditText regisEditText2;
  private Button login;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_log);

    inputText1 = (TextInputLayout) findViewById(R.id.inputEmail);
    inputText2 = (TextInputLayout) findViewById(R.id.inputPass);

    regisEditText1 = (EditText) findViewById(R.id.loginEmail);
    regisEditText2 = (EditText) findViewById(R.id.loginPass);
    login = (Button) findViewById(R.id.btnSignIn);

    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String Email = regisEditText1.getText().toString();
        String Password = regisEditText2.getText().toString();

        if (Email.isEmpty()) {
          inputText1.setError("Kullanıcı boş olamaz");
          regisEditText1.requestFocus();
          return;
        }

        if (Password.isEmpty()) {
          inputText1.setError("Şifrenizi giriniz");
          regisEditText1.requestFocus();
          return;
        }

        InputMethodManager im = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        if (im != null) {
          im.hideSoftInputFromWindow(regisEditText1.getWindowToken() , InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
        if(true) {
          Intent i = new Intent(getBaseContext(), MainActivity.class);/*
        i.putExtra("banner", (Serializable) ActivitySplashScreen.ARBannerItems);
        i.putExtra("loc",   (Serializable) ActivitySplashScreen.ARLocationItems);
        i.putExtra("video",  (Serializable) ActivitySplashScreen.ARVideoItems);
        i.putExtra("soci",  (Serializable) ActivitySplashScreen.ARSocialItems);
        i.putExtra("beacon",  (Serializable) ActivitySplashScreen.BeaconItems);
        i.putExtra("news",  (Serializable) ActivitySplashScreen.newsItems);
        i.putExtra("not",  (Serializable) ActivitySplashScreen.notItems);*/
          startActivity(i);
          finish();
        }
          //Toast.makeText(act,"Giriş Başarısız",Toast.LENGTH_LONG).show();
        //new LoadTask(LoginActivity.this,Email, Password).execute();
      }
    });






  }



  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }



}
