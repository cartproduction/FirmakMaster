package com.application.firmak.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.application.firmak.activities.MainActivity
import com.application.firmak.R
import kotlinx.android.synthetic.main.fragment_log.*

//1
class Login : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment


    return inflater!!.inflate(R.layout.fragment_log, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    btnSignIn.setOnClickListener(View.OnClickListener {
      val Email = loginEmail.text.toString()
      val Password = loginPass.text.toString()

      if (Email.isEmpty()) {
        inputEmail.error = "Kullanıcı boş olamaz"
        loginEmail.requestFocus()
        return@OnClickListener
      }

      if (Password.isEmpty()) {
        inputEmail.error = "Şifrenizi giriniz"
        loginEmail.requestFocus()
        return@OnClickListener
      }

      val im = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
      im?.hideSoftInputFromWindow(loginEmail.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
      if (true) {
        val i = Intent(requireActivity().getBaseContext(), MainActivity::class.java)/*
    i.putExtra("banner", (Serializable) ActivitySplashScreen.ARBannerItems);
    i.putExtra("loc",   (Serializable) ActivitySplashScreen.ARLocationItems);
    i.putExtra("video",  (Serializable) ActivitySplashScreen.ARVideoItems);
    i.putExtra("soci",  (Serializable) ActivitySplashScreen.ARSocialItems);
    i.putExtra("beacon",  (Serializable) ActivitySplashScreen.BeaconItems);
    i.putExtra("news",  (Serializable) ActivitySplashScreen.newsItems);
    i.putExtra("not",  (Serializable) ActivitySplashScreen.notItems);*/
        requireActivity().startActivity(i)
        requireActivity().finish()
      }
      //Toast.makeText(act,"Giriş Başarısız",Toast.LENGTH_LONG).show();
      //new LoadTask(LoginActivity.this,Email, Password).execute();
    })
  }

}