package edu.acmatucf.stemdayapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentSchedule extends Fragment {

    private ScheduleAdapter scheduleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);


        //Set up recyclerview
        scheduleAdapter = new ScheduleAdapter();
        RecyclerView.LayoutManager scheduleLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView scheduleRecyclerView = (RecyclerView) view.findViewById(R.id.schedule);
        scheduleRecyclerView.setLayoutManager(scheduleLayoutManager);
        scheduleRecyclerView.setAdapter(scheduleAdapter);
        return view;


    }

    @Override
    public void onResume() {
        super.onResume();

        String[] test = new String[50];

        for (int i = 0; i < test.length; i++) {
            test[i] = String.valueOf(i + 1);

        }

        scheduleAdapter.SetData(test);

    }
}


