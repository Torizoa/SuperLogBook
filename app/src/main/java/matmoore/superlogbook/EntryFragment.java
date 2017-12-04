package matmoore.superlogbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.widget.CompoundButton.*;
import static matmoore.superlogbook.R.styleable.CompoundButton;

/**
 * Created by Matthew on 11/30/2017.
 */

public class EntryFragment extends Fragment {

    private static final String ARG_ENTRY_NAME = "entry_name";

    private Entry mEntry;
    private CheckBox mScannedCheckBox;
    private TextView mEntryName;
    private ImageView mEntryImage;
    private TextView mThreatText;
    private TextView mEntryText;

    public static EntryFragment newInstance(String entryName) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ENTRY_NAME, entryName);

        EntryFragment fragment = new EntryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String entryName = (String) getArguments().getSerializable(ARG_ENTRY_NAME);
        mEntry = LogBook.get(getActivity()).getEntry(entryName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_entry, container, false);

        mEntryName = (TextView)v.findViewById(R.id.entry_name);
        mEntryImage = (ImageView)v.findViewById(R.id.entry_image);
        mThreatText = (TextView)v.findViewById(R.id.threat_text);
        mEntryText = (TextView)v.findViewById(R.id.entry_text);

        if (mEntry.getImage() != null) {
            mEntryImage.setImageResource(getResources().getIdentifier(mEntry.getImage(), "drawable", "matmoore.superlogbook"));
        }
        mEntryText.setText(mEntry.getDescrip());


        mScannedCheckBox = (CheckBox)v.findViewById(R.id.entry_scanned);
        mScannedCheckBox.setChecked(mEntry.isScanned());
        mScannedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mEntry.setScanned(isChecked);
                checkScanned();
            }
        });

        checkScanned();

        return v;
    }

    private void checkScanned() {
        if (mEntry.isScanned()){
            mEntryName.setText(mEntry.getName());
            mThreatText.setText(mEntry.getThreat());
            mEntryText.setVisibility(VISIBLE);
        } else {
            mEntryName.setText(R.string.not_scanned);
            mThreatText.setText(R.string.not_scanned);
            mEntryText.setVisibility(INVISIBLE);
        }
    }
}
