package rktechltd.aklfishing;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * Created by romelyn on 13/05/2016.
 */
public class FishingExperience {
    private int experienceId;
    private int locationid;
    private Date date;
    private Time time;
    private String remark;

    public FishingExperience(int experienceId, int locationid, Date date, Time time, String remark) {
        this.experienceId = experienceId;
        this.locationid = locationid;
        this.date = date;
        this.time = time;
        this.remark = remark;
    }


    public int getExperienceId() {
        return experienceId;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
