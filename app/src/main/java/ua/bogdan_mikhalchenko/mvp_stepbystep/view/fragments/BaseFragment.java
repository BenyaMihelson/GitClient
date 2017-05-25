package ua.bogdan_mikhalchenko.mvp_stepbystep.view.fragments;

import android.support.v4.app.Fragment;

import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.BasePresenter;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract BasePresenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }
}