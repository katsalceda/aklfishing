package rktechltd.aklfishing;

/**
 * Created by romelyn on 12/05/2016.
 */
public class Fish {
    private int fishId;
    private String fishName;
    private String fishDescription;
    private byte[] fishImage;
    private Category fishCat;


    public Fish(int fishId, String fishName, String fishDescription, byte[] fishImage) {
        this.fishId = fishId;
        this.fishName = fishName;
        this.fishDescription = fishDescription;
        this.fishImage = fishImage;
    }

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public String getFishDescription() {
        return fishDescription;
    }

    public void setFishDescription(String fishDescription) {
        this.fishDescription = fishDescription;
    }

    public byte[] getFishImage() {
        return fishImage;
    }

    public void setFishImage(byte[] fishImage) {
        this.fishImage = fishImage;
    }

    public Category getFishCat() {
        return fishCat;
    }

    public void setFishCat(Category fishCat) {
        this.fishCat = fishCat;
    }
}
