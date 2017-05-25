package ua.bogdan_mikhalchenko.mvp_stepbystep.view.fragments;

import java.util.List;

import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Repository;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public interface RepoListView extends View {
    void showRepoList(List<Repository> vo);

    void startRepoInfoFragment(Repository vo);

    void showEmptyList();

    String getUserName();
}
