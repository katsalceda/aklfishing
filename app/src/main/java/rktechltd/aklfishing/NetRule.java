package rktechltd.aklfishing;

/**
 * Created by romelyn on 12/05/2016.
 */
public class NetRule {
    private int rulesId;
    private String description;
    private byte[] image;

    public NetRule(){}
    public NetRule(int rulesId, String description, byte[] image) {
        this.rulesId = rulesId;
        this.description = description;
        this.image = image;
    }


    public int getRulesId() {
        return rulesId;
    }

    public void setRulesId(int rulesId) {
        this.rulesId = rulesId;
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
