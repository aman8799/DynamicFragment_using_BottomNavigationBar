package com.example.dynafragbottomnav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private TextView textView;
    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        Log.d("data--",Constant.userData);
        if(!TextUtils.isEmpty(Constant.userData)){
            textView.setText(Constant.userData);
        }
        return view;

    }
}