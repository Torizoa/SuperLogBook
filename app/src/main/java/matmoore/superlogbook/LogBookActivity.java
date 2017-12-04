package matmoore.superlogbook;

import android.support.v4.app.Fragment;

/**
 * Created by Matthew on 12/1/2017.
 */

public class LogBookActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LogBookFragment();
    }
}
