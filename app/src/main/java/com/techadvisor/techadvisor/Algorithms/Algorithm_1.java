package com.techadvisor.techadvisor.Algorithms;

import android.util.Log;
import android.webkit.WebView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techadvisor.techadvisor.POJO.SmartPhone;
import com.techadvisor.techadvisor.POJO.WeightedSmartPhone;
import com.techadvisor.techadvisor.RecommendationActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by test on 10/15/2018.
 */

public class Algorithm_1 {

    public static ArrayList<WeightedSmartPhone> list1 = new ArrayList<>();
    public static ArrayList<Integer> scores = new ArrayList<>();

    public static void arrangeList(Integer min_price, Integer max_price, Integer ram, Integer camera, Integer battery, Integer processor) {

        Log.d("sm___", "arrangeList: " + min_price + "\t" + max_price);

        for (int i=0;i< RecommendationActivity.smartPhonesList.size();i++) {
            SmartPhone smartPhone = RecommendationActivity.smartPhonesList.get(i);
            Log.d("sm___", "arrangeList: " + smartPhone.getPrice());
            if (smartPhone.getPrice() > min_price && smartPhone.getPrice() < max_price) {
                list1.add(new WeightedSmartPhone(smartPhone.getName(), smartPhone.getPrice(), smartPhone.getRam(), smartPhone.getCamera(), smartPhone.getBattery(), smartPhone.getProcessor(), 0));
            }
        }

        Log.d("sm___", "arrangeList: " + list1.size());

        for (int i=0;i<list1.size();i++) {
            WeightedSmartPhone sm = list1.get(i);
            Integer s = 0;
            s += (sm.getRam() * (5 - ram));
            s += (sm.getCamera() * (5 - camera));
            s += (sm.getBattery() * (5 - battery));
            s += (sm.getProcessor() * (5 - processor));

            list1.get(i).setScore(s);
        }

        Collections.sort(list1, new Comparator<WeightedSmartPhone>() {
            @Override
            public int compare(WeightedSmartPhone o1, WeightedSmartPhone o2) {
                if (o1.getScore() > o2.getScore()) return 1;
                return 0;
            }
        });

        for (int i=0;i<list1.size();i++) {
            Log.d("sm___1", "arrangeList: " + list1.get(i).getName());
        }

    }

}
