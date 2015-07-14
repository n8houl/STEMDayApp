package edu.acmatucf.stemdayapp.schedule;

import java.util.ArrayList;
import java.util.List;

import edu.acmatucf.stemdayapp.ScheduleItem;

/**
 * Created by Ryan on 7/13/2015.
 */
public class Schedule implements ISchedule {

    private final List<ScheduleItem> scheduleItemList;

    public Schedule() {
        scheduleItemList = new ArrayList<>();
        long startDate = System.currentTimeMillis();


        for(int i = 0; i < 10; i++){
            startDate += 10000;
            scheduleItemList.add(new ScheduleItem(
                    startDate,
                    startDate + 10000,
                    "Test item " + i,
                    "The location"
            ));
        }
    }

    @Override
    public int size() {

        return scheduleItemList.size();
    }

    @Override
    public void add(ScheduleItem scheduleItem) {
         scheduleItemList.add(scheduleItem);
    }

    @Override
    public ScheduleItem get(int index) {

        return scheduleItemList.get(index);
    }

}
