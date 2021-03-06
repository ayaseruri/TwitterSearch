package ayaseruri.x.twittersearch.global;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.androidannotations.annotations.EApplication;

import ayaseruri.x.twittersearch.util.LocalDisplay;

/**
 * Created by ayaseruri on 15/12/23.
 */
@EApplication
public class Mapplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        LocalDisplay.init(this);
    }
}
