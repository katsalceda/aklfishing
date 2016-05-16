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
    private int minFishLengthCm;
    private int minFishMeshSizeMm;
    private int minDragNetMeshMm;
    private int maxDailyLimit;
    private boolean isCombinedBag;


    public Fish(){}
    public Fish(int fishId, String fishName, String fishDescription, byte[] fishImage, Category fishCat, int minFishLengthCm, int minFishMeshSizeMm, int minDragNetMeshMm,int maxDailyLimit, boolean isCombinedBag){
        this.fishId = fishId;
        this.fishName = fishName;
        this.fishDescription = fishDescription;
        this.fishImage = fishImage;
        this.fishCat = fishCat;
        this.minFishLengthCm = minFishLengthCm;
        this.minFishMeshSizeMm = minFishMeshSizeMm;
        this.minDragNetMeshMm = minDragNetMeshMm;
        this.maxDailyLimit = maxDailyLimit;
        this.isCombinedBag = isCombinedBag;
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

    public int getMinFishLengthCm() {
        return minFishLengthCm;
    }

    public void setMinFishLengthCm(int minFishLengthCm) {
        this.minFishLengthCm = minFishLengthCm;
    }

    public int getMinFishMeshSizeMm() {
        return minFishMeshSizeMm;
    }

    public void setMinFishMeshSizeMm(int minFishMeshSizeMm) {
        this.minFishMeshSizeMm = minFishMeshSizeMm;
    }

    public int getMinDragNetMeshMm() {
        return minDragNetMeshMm;
    }

    public void setMinDragNetMeshMm(int minDragNetMeshMm) {
        this.minDragNetMeshMm = minDragNetMeshMm;
    }

    public int getMaxDailyLimit() {
        return maxDailyLimit;
    }

    public void setMaxDailyLimit(int maxDailyLimit) {
        this.maxDailyLimit = maxDailyLimit;
    }

    public boolean isCombinedBag() {
        return isCombinedBag;
    }

    public void setCombinedBag(boolean combinedBag) {
        isCombinedBag = combinedBag;
    }
}
