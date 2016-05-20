package rktechltd.aklfishing.models;

/**
 * Created by romelyn on 12/05/2016.
 */
public class Checklist {
    private int checkListId;
    private String description;
    private byte[] image;

    public Checklist(){}
    public Checklist(int checkListId, String description, byte[] image) {
        this.checkListId = checkListId;
        this.description = description;
        this.image = image;
    }

    public int getCheckListId() {
        return checkListId;
    }

    public void setCheckListId(int checkListId) {
        this.checkListId = checkListId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
