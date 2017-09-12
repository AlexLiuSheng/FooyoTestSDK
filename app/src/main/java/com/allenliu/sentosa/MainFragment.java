package com.allenliu.sentosa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;

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
        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_fooyo_page:
                FooyoIndex fooyoIndex = new FooyoIndex();
                fooyoIndex.setCategory("Attractions");
                fooyoIndex.setLevelOneId(488 + "");
                FooyoSDK.getSDKManager().startFooyoMapPage(getActivity(), fooyoIndex);
                break;
            case R.id.btn_start_navi_page:
                FooyoIndex start = new FooyoIndex();
                start.setCategory("Attractions");
                start.setLevelOneId(488 + "");
                FooyoIndex end = new FooyoIndex();
                end.setCategory("Interactive Trails");
                end.setLevelOneId(6033 + "");
                end.setLevelTwoId("hs36c4134d");
                FooyoSDK.getSDKManager().startNavigation(getActivity(), start, end);
                break;
            case R.id.btn_start_createPlan_page:
                FooyoSDK.getSDKManager().startFooyoCreatePlan(getActivity());
                break;
            case R.id.btn_set_Window_clcik:
                FooyoSDK.getSDKManager().setOnWindowDetailClickListener(new WindowDetailClickListener() {
                    @Override
                    public void onClick(FooyoIndex fooyoIndex) {
                        ToastUtils.showShort(fooyoIndex.toString());
                    }
                });
                break;


        }
    }
}
