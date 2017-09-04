package com.allenliu.sentosa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sg.fooyo.sdkosp.sdk.FooyoSDK;
import sg.fooyo.sdkosp.sdk.listener.WindowDetailClickListener;
import sg.fooyo.sdkosp.sdk.model.FooyoIndex;


/**
 * Created by allenliu on 2017/9/1.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,null);
        view.findViewById(R.id.btn_set_Window_clcik).setOnClickListener(this);
        view.findViewById(R.id.btn_start_createPlan_page).setOnClickListener(this);
        view.findViewById(R.id.btn_start_fooyo_page).setOnClickListener(this);
        view.findViewById(R.id.btn_start_navi_page).setOnClickListener(this);
        view.findViewById(R.id.btn_start_photo_collage).setOnClickListener(this);
        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_fooyo_page:
                FooyoSDK.getSDKManager().startFooyoMapPage(getActivity(), new FooyoIndex());
                break;
            case R.id.btn_start_navi_page:
                FooyoSDK.getSDKManager().startNavigation(getActivity(), new FooyoIndex(), new FooyoIndex());
                break;
            case R.id.btn_start_createPlan_page:
                FooyoSDK.getSDKManager().startFooyoCreatePlan(getActivity());
                break;
            case R.id.btn_set_Window_clcik:
                FooyoSDK.getSDKManager().setOnWindowDetailClickListener(new WindowDetailClickListener() {
                    @Override
                    public void onClick(FooyoIndex fooyoIndex) {

                    }
                });
                break;
            case R.id.btn_start_photo_collage:

                FooyoSDK.getSDKManager().startFooyoPhotoCollage(getActivity());
                break;


        }
    }
}
