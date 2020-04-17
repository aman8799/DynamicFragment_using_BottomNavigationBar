package com.example.dynafragbottomnav;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
        * A simple {@link Fragment} subclass.
        */
public class FavouriteFragment extends Fragment {
    private FavouriteFragmentListener listener;

    private TextView textView;
    private EditText name;
    private Button send;

    public FavouriteFragment() {
        // Required empty public constructor
    }
    public interface FavouriteFragmentListener
    {
        void onDataSend(String data);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        name = view.findViewById(R.id.name);
        send = view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                listener.onDataSend(userName);
            }
        });
        textView = (TextView) view.findViewById(R.id.textView);
        Log.d("data--",Constant.userData);
        if(!TextUtils.isEmpty(Constant.userData)){
            textView.setText(Constant.userData);
        }
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FavouriteFragmentListener){
            listener = (FavouriteFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString() +
                    "Must implement FavouriteFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
