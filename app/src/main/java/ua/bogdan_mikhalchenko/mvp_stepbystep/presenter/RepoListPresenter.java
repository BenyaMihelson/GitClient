package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.RepositoryDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.mappers.RepoListMapper;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Repository;
import ua.bogdan_mikhalchenko.mvp_stepbystep.view.fragments.RepoListView;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class RepoListPresenter extends BasePresenter {
    private static final String BUNDLE_REPO_LIST_KEY = "BUNDLE_REPO_LIST_KEY";

    private RepoListView view;

    private RepoListMapper repoListMapper = new RepoListMapper();

    private List<Repository> repoList;

    public RepoListPresenter(RepoListView view) {
        this.view = view;
    }

    public void onSearchButtonClick() {
        Log.d("RepolistPreasenter", " ON LICKED");
        String name = view.getUserName();
        if (TextUtils.isEmpty(name)){
            return;
        }
        Subscription subscription = dataRepository.getRpoList(name)
                .map(repoListMapper)
                .subscribe(new Observer<List<Repository>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                        Log.d("RepolistPreasenter", e.getMessage() + " LIST SIXZE");


                    }

                    @Override
                    public void onNext(List<Repository> list) {
                        Log.d("RepolistPreasenter", list.size() + " LIST SIXZE");

                        if (list != null && !list.isEmpty()) {
                            repoList = list;
                            view.showRepoList(list);
                        } else {
                            view.showEmptyList();
                        }

                    }
                });
        addSubscription(subscription);
    }

    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            repoList = (List<Repository>) savedInstanceState.getSerializable(BUNDLE_REPO_LIST_KEY);
        }

        if (!isRepoListEmpty()) {
            view.showRepoList(repoList);

        }
    }

    private boolean isRepoListEmpty() {
        return repoList == null || repoList.isEmpty();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!isRepoListEmpty()) {
            outState.putSerializable(BUNDLE_REPO_LIST_KEY, new ArrayList<>(repoList));
        }
    }

    public void clickRepo(Repository repository) {
        view.startRepoInfoFragment(repository);
    }


}
