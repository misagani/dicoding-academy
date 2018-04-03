package com.misagani.teslashowcase;

import java.util.ArrayList;

public class TeslaData
{
    public static String[][] data = new String[][]{
            {   "Tesla",
                "Model S",
                String.valueOf(R.drawable.model_s),
                "Model S sets an industry standard for performance and safety. Tesla’s all-electric powertrain delivers unparalleled performance in all weather conditions—with dual motor all-wheel drive, ludicrous acceleration and the highest safety rating of any car ever tested.",
                "Acceleration: 2.5 seconds 0-60 mph",
                "Range: 315 miles",
                "Drive: All-Wheel Drive",
                "Seating: 5 Adults + 2 Children"},

            {   "Tesla",
                "Model 3",
                String.valueOf(R.drawable.model_e),
                "Model 3 is a smaller, simpler, more affordable electric car. Although it is our newest vehicle, Model 3 is not “Version 3” or the most advanced Tesla. Like Model S, it is designed to be the safest car in its class.",
                "Acceleration: 5.1 seconds 0-60 mph",
                "Range: 310 miles",
                "Drive: All-Wheel Drive",
                "Seating: 5 Adults"},

            {   "Tesla",
                "Model X",
                String.valueOf(R.drawable.model_x),
                "Model X is the safest, quickest, most capable sport utility vehicle ever—with standard all-wheel drive, best in class storage and seating for up to seven adults. Falcon Wing doors are equipped with sensors to monitor the proximity of surroundings, and can open in even the tightest parking spaces.",
                "Acceleration: 2.9 seconds 0-60 mph",
                "Range: 289 miles",
                "Drive: All-Wheel Drive",
                "Seating: Up to 7 Adults"},

            {   "Tesla",
                "Roadster",
                String.valueOf(R.drawable.model_roadster),
                "The quickest car in the world, with record-setting acceleration, range and performance.",
                "Acceleration: 1.9 seconds 0-60 mph",
                "Range: 620 miles",
                "Drive: All-Wheel Drive",
                "Seating: 4 Adults"},
    };

    public static ArrayList<Tesla> getListData()
    {
        Tesla tesla;
        ArrayList<Tesla> list = new ArrayList<>();
        for (String[] aData : data)
        {
            tesla = new Tesla();
            tesla.setName(aData[0]);
            tesla.setRemarks(aData[1]);
            tesla.setPhoto(Integer.parseInt(aData[2]));
            tesla.setDetails(aData[3]);
            tesla.setAcc(aData[4]);
            tesla.setRange(aData[5]);
            tesla.setDrive(aData[6]);
            tesla.setSeat(aData[7]);

            list.add(tesla);
        }

        return list;
    }
}