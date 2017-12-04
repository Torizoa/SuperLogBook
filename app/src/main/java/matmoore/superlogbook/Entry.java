package matmoore.superlogbook;

/**
 * Created by Matthew on 11/29/2017.
 */

public class Entry {

    private String mName;
    private String mThreat;
    private String mDescrip;
    private boolean mScanned;
    private String mImage;

    public Entry() {
        mName = "Zoomer";
        mThreat = "Low";
        mDescrip = "It's just a Zoomer";
        mScanned = false;
        mImage = "zoomer_sm_sprite";
    }

    public Entry(String name) {
        mName = name;
    }

    public String getName(){
        return mName;
    }

    public String getThreat() {
        return mThreat;
    }

    public String getDescrip() { return mDescrip; }

    public String getImage() { return mImage; }

    public void setImage(String image) { mImage = image; }

    public boolean isScanned() { return mScanned; }

    public void setScanned(boolean isScanned) { mScanned = isScanned; }
}