package matmoore.superlogbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Matthew on 12/1/2017.
 */

public class LogBookFragment extends Fragment {

    private RecyclerView mEntryRecyclerView;
    private EntryAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entry_list, container, false);

        mEntryRecyclerView = (RecyclerView) view
                .findViewById(R.id.entry_recycler_view);
        mEntryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        LogBook logBook = LogBook.get(getActivity());
        List<Entry> entries = logBook.getEntries();

        if (mAdapter == null) {
            mAdapter = new EntryAdapter(entries);
            mEntryRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class EntryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Entry mEntry;
        private TextView mNameTextView;
        private ImageView mCreatureImageView;

        public EntryHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_entry, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.entry_name);
            mCreatureImageView = (ImageView) itemView.findViewById(R.id.list_image);
        }

        public void bind(Entry entry) {
            mEntry = entry;
            if (mEntry.isScanned()) {
                mNameTextView.setText(mEntry.getName());
            } else {
                mNameTextView.setText(R.string.not_scanned);
            }
            if (mEntry.getImage() != null) {
                mCreatureImageView.setImageResource(getResources().getIdentifier(mEntry.getImage(), "drawable", "matmoore.superlogbook"));
            }
        }

        @Override
        public void onClick(View view) {
            Intent intent = SuperActivity.newIntent(getActivity(), mEntry.getName());
            startActivity(intent);
        }
    }

    private class EntryAdapter extends RecyclerView.Adapter<EntryHolder> {

        private List<Entry> mEntries;

        public EntryAdapter(List<Entry> entries) {
            mEntries = entries;
        }

        @Override
        public EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new EntryHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(EntryHolder holder, int position) {
            Entry entry = mEntries.get(position);
            holder.bind(entry);
        }

        @Override
        public int getItemCount() {
            return mEntries.size();
        }
    }
}
