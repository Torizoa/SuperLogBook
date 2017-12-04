package matmoore.superlogbook;

import android.support.v4.app.Fragment;

/**
 * Created by Matthew on 12/3/2017.
 */

public class MenuActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MenuFragment();
    }
}
