package ayaseruri.x.twittersearch.db;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by ayaseruri on 15/12/22.
 */
@SharedPref
public interface BearerPrefs {
    @DefaultString("")
    String bearer();
}
