package com.htsi.vntv.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.htsi.vntv.di.base.HasComponent;

import butterknife.ButterKnife;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:26 PM
 * Project: VnTV
 */

public class BaseFragment extends Fragment {

    protected void onScreenVisible(){}

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        onScreenVisible();
    }
}
