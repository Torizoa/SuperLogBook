package matmoore.superlogbook;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 12/1/2017.
 */

public class LogBook {
    private static LogBook sLogBook;

    private List<Entry> mEntries;

    public static LogBook get(Context context) {
        if (sLogBook == null) {
            sLogBook = new LogBook(context);
        }
        return sLogBook;
    }

    private LogBook(Context context) {
        mEntries = new ArrayList<>();

        //add creatures from Crateria
        Entry entry = new Entry();
        mEntries.add(entry);

        entry = new Entry("Space Pirate");
        entry.setScanned(true);
        entry.setImage("img_pirate");
        mEntries.add(entry);

        entry = new Entry("Ripper");
        entry.setScanned(true);
        entry.setImage("img_ripper");
        mEntries.add(entry);

        entry = new Entry("Skree");
        entry.setScanned(true);
        entry.setImage("img_skree");
        mEntries.add(entry);

        entry = new Entry("Mellow");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Chozo Statue");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Kago");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Waver");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Skultera");
        entry.setScanned(false);
        mEntries.add(entry);

        entry = new Entry("Tripper");
        entry.setScanned(false);
        mEntries.add(entry);

        //add creatures from Brinstar
        entry = new Entry("Zeela");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Reo");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Geega");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Metaree");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Sidehopper");
        entry.setScanned(true);
        mEntries.add(entry);

        entry = new Entry("Kihunter");
        entry.setScanned(false);
        mEntries.add(entry);
    }

    public List<Entry> getEntries() {
        return mEntries;
    }

    public Entry getEntry(String name) {
        for (Entry entry : mEntries) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }

        return null;
    }
}
