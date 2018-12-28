package com.application.firmak;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by civil on 03/07/15.
 */
public class ApplicationClass{

    public static final String applicationID = "30";
    public static String TOKEN;
    public static final String BASE_URL = "http://iotv2api.argede.com.tr";
    public static final String LOGINTEST = "Mobil/LoginTest?";
    public static final String LOGIN = "Mobil/Login";
    public static final String SAVE_RANDEVU = "Mobil/SaveRandevu";
    public static final String SAVE_KAM = "Mobil/PostKampanyaBasvuru";
    public static final String POST = "Mobil/PostBildirimGeriDonus";
    public static final String NOTIFICATION = "Mobil/GetBildirim";
    public static final String NOTIFICATIONS = "Mobil/ListBildirim";
    public static final String CONFIGURATIONS = "Mobil/GetKonfigurasyon";
    public static final String CONSTANTS = "Mobil/GetSabit";
    public static final String DATE = "Mobil/GetRandevu";
    public static final String DATES = "Mobil/ListRandevu";
    public static final String CAMPAIGNS = "Mobil/ListKampanya";
    public static final String CAMPAIGN = "Mobil/GetKampanyaDetay";
    public static final String KONUM = "Mobil/ListKonumGecmis";
    public static final String CAR = "Mobil/GetArac";
    public static final String PROFILE = "Mobil/GetKullaniciProfil";
    public static final String SYMBOLS = "Mobil/ListSembol";
    public static final String TELEPHONES = "Mobil/ListTelefonNumara";
    public static final String COMMAND = "Mobil/PostKomut";
    public static final String SEARCH_QUERY_TWEETS = "saumobil";
    public static final String SEARCH_QUERY_FAVS = "saumobil";
    public static final String SEARCH_RESULT_TYPE = "recent";
    public static Location loct;
    public static String IS_IT_FIRST_TIME = "is_it_first_time_pref";
    /*public static List<Kampanya> campaings = new ArrayList<Kampanya>();
    public static Data arac = new Data();
    public static Profil profil = new Profil();
    public static List<Tel> telephones = new ArrayList<Tel>();
    public static List<Bildirim> notis = new ArrayList<Bildirim>();
    public static List<Konum> locations = new ArrayList<Konum>();
    public static List<Sem> symbols = new ArrayList<Sem>();
    public static List<Rand> rdates = new ArrayList<Rand>();*/
    public static List<Sbit> sabt = new ArrayList<Sbit>(){{
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
    }};
    public static List<Sbit> baslik = new ArrayList<Sbit>(){{
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
    }};
    public static List<Sbit> aciklama = new ArrayList<Sbit>(){{
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
        add(new Sbit("deneme","deneme","deneme"));
    }};
    private static final int SEARCH_COUNT = 20;
    private static long MAXID;
    public static int width;
    public static int height;

    public static JSONArray infoFromAssets;

   public static void initShareIntent(String type , Context ctx) {
        boolean found = false;
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");

        // gets the list of intents that can be loaded.
        List<ResolveInfo> resInfo = ctx.getPackageManager().queryIntentActivities(share, 0);
        if (!resInfo.isEmpty()){
            for (ResolveInfo info : resInfo) {
                if (info.activityInfo.packageName.toLowerCase().contains(type) ||
                        info.activityInfo.name.toLowerCase().contains(type) ) {
                    share.putExtra(Intent.EXTRA_SUBJECT, ctx.getResources().getString(R.string.app_name));
                    share.putExtra(Intent.EXTRA_TEXT, ctx.getResources().getString(R.string.app_name) + "https://play.google.com/store/apps/details?id=com.civil.platform");
                    share.setPackage(info.activityInfo.packageName);
                    found = true;
                    break;
                }
            }
            if (!found)
                return;

            ctx.startActivity(Intent.createChooser(share, "Select"));
        }
    }

    public static void initShareIntentForHata(String type , Context ctx) {
        boolean found = false;
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");

        // gets the list of intents that can be loaded.
        List<ResolveInfo> resInfo = ctx.getPackageManager().queryIntentActivities(share, 0);
        if (!resInfo.isEmpty()){
            for (ResolveInfo info : resInfo) {
                if (info.activityInfo.packageName.toLowerCase().contains(type) ||
                        info.activityInfo.name.toLowerCase().contains(type) ) {
                    share.putExtra(Intent.EXTRA_SUBJECT,  ctx.getResources().getString(R.string.share_subject_for_hata));
                    share.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@saumobil.com"});
                    share.setPackage(info.activityInfo.packageName);
                    found = true;
                    break;
                }
            }
            if (!found)
                return;

            ctx.startActivity(Intent.createChooser(share, "Select"));
        }
    }

    public static void loadJSONFromAsset(Context ctx) {

        if(ApplicationClass.infoFromAssets == null){
            String json = null;
            JSONArray jsonArray = null;
            try {
                InputStream is = ctx.getAssets().open("locations.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
                jsonArray = new JSONArray(json);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            ApplicationClass.infoFromAssets = jsonArray;
            Log.d("infoFromAssets", "infoFromAssets bostu dolduruldu");

        }else{
            Log.d("infoFromAssets","infoFromAssets doluydu olan cagirildi");
        }

    }

}
