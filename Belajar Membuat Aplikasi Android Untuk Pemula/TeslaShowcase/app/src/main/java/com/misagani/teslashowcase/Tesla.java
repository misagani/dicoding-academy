package com.misagani.teslashowcase;

import java.util.ArrayList;

public class Tesla extends ArrayList<Tesla>
{
    private String name;
    private String remarks;
    private int photo;
    private String details;
    private String acc;
    private String range;
    private String drive;
    private String seat;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public int getPhoto()
    {
        return photo;
    }

    public void setPhoto(int photo)
    {
        this.photo = photo;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getAcc()
    {
        return acc;
    }

    public void setAcc(String acc)
    {
        this.acc = acc;
    }

    public String getRange()
    {
        return range;
    }

    public void setRange(String range)
    {
        this.range = range;
    }

    public String getDrive()
    {
        return drive;
    }

    public void setDrive(String drive)
    {
        this.drive = drive;
    }

    public String getSeat()
    {
        return seat;
    }

    public void setSeat(String seat)
    {
        this.seat = seat;
    }
}