package com.gbrbrothers.fitme2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TK on 2016-12-18.
 */

public class TrainerSortFragment extends Fragment {

    private Spinner mDateSpinner, mCitySpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trainer_sort, container, false);
        mDateSpinner = (Spinner) v.findViewById(R.id.date_select_dropdown);
        mCitySpinner = (Spinner) v.findViewById(R.id.region_select_dropdown);
        addItemOnDateSpinner(mDateSpinner); // 날짜를 표시하기로 바꾸거나, 정렬 방법 설정

        // dropdown list value check and update list methods

        return v;
    }

    public void addItemOnDateSpinner(Spinner mDateSpinnerTarget) {

        List<String> list = new ArrayList<String>();
        list.add("날짜별");
        list.add("오늘");
        list.add("내일");
        list.add("내일 모레");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDateSpinnerTarget.setAdapter(dataAdapter);
    }

    // dropdown list value check - update list 추가해야함

}
