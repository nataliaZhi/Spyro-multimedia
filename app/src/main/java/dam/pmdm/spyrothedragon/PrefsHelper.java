package dam.pmdm.spyrothedragon;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsHelper {

    private static final String PREFS_NAME = "SpyroPrefs";
    private static final String KEY_GUIDE_SHOWN = "guide_shown";

    private SharedPreferences sharedPreferences;

    public PrefsHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // Método para verificar si la guía ya se mostró
    public boolean isGuideShown() {
        return sharedPreferences.getBoolean(KEY_GUIDE_SHOWN, false);
    }

    // Método para marcar que la guía ya se mostró
    public void setGuideShown(boolean shown) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_GUIDE_SHOWN, shown);
        editor.apply();
    }
}