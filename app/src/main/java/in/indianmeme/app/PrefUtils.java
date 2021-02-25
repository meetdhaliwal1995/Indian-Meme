package in.indianmeme.app;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils {

    private static final String MYPREF = "Mypres";
    private static SharedPreferences sharedPreferences;

    public static String getAccessToken() {
        sharedPreferences = MyApp.getInstance().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constant.ACCESS_TOKEN, null);

    }

    public static void setAccessToken(String value) {
        sharedPreferences = MyApp.getInstance().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(Constant.ACCESS_TOKEN, value)
                .apply();

    }

    public static int getUserId() {
        sharedPreferences = MyApp.getInstance().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Constant.USER_ID, 0);
    }

    public static void setUserId(int value) {
        sharedPreferences = MyApp.getInstance().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putInt(Constant.USER_ID, value)
                .apply();
    }

    public static String getAvatar() {

        sharedPreferences = MyApp.getInstance().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constant.AVATAR, null);
    }

    public static void setAvatar(String avatar) {
        sharedPreferences = MyApp.getInstance().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(Constant.AVATAR, avatar)
                .apply();
    }
}
