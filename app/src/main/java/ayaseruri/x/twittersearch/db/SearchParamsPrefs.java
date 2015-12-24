package ayaseruri.x.twittersearch.db;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by ayaseruri on 15/12/24.
 */
@SharedPref(value = SharedPref.Scope.UNIQUE)
public interface SearchParamsPrefs {
    @DefaultString("")
    String lang();
    @DefaultString("")
    String location();
}
