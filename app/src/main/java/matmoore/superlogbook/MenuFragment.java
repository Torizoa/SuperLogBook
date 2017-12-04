package matmoore.superlogbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Matthew on 12/3/2017.
 */

public class MenuFragment extends Fragment {

    private TextView mCreatureView;
    private TextView mArtifactView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_list, container, false);

        mCreatureView = (TextView)view.findViewById(R.id.menu_creatures);
        mArtifactView = (TextView)view.findViewById(R.id.menu_artifacts);

        mCreatureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LogBookActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }



}
