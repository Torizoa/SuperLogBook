package matmoore.superlogbook;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class SuperActivity extends SingleFragmentActivity {

    private static final String EXTRA_ENTRY_NAME = "matmoore.SuperLogBook.entry_name";

    public static Intent newIntent(Context packageContext, String entryName) {
        Intent intent = new Intent(packageContext, SuperActivity.class);
        intent.putExtra(EXTRA_ENTRY_NAME, entryName);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String entryName = (String) getIntent()
                .getSerializableExtra(EXTRA_ENTRY_NAME);
        return EntryFragment.newInstance(entryName);
    }
}