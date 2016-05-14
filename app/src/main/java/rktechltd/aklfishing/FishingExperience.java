package rktechltd.aklfishing;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * Created by romelyn on 13/05/2016.
 */
public class FishingExperience {
    private int experienceId;
    private Location location;
    private Date date;
    private Time time;
    private String remark;


    public FishingExperience(int experienceId, Location location, Date date, Time time, String remark) {
        this.experienceId = experienceId;
        this.location = location;
        this.date = date;
        this.time = time;
        this.remark = remark;
    }

    public int getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(int experienceId) {
        this.experienceId = experienceId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
