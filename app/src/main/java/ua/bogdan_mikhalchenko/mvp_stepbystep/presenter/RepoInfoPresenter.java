package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.mappers.RepoBranchesMapper;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.mappers.RepoContributorsMapper;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Branch;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Contributor;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Repository;
import ua.bogdan_mikhalchenko.mvp_stepbystep.view.fragments.RepoInfoView;

/**
 * Created by Shipohvost on 16.05.2017.
 */

public class RepoInfoPresenter extends BasePresenter {

    private static final String BUNDLE_BRANCHES_KEY = "BUNDLE_BRANCHES_KEY";
    private static final String BUNDLE_CONTRIBUTORS_KEY = "BUNDLE_CONTRIBUTORS_KEY";

    private RepoInfoView view;

    private RepoBranchesMapper branchesMapper = new RepoBranchesMapper();
    private RepoContributorsMapper contributorsMapper = new RepoContributorsMapper();

    private List<Contributor> contributorList;
    private List<Branch> branchList;

    private Repository repository;

    public RepoInfoPresenter(RepoInfoView view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadData() {
        String owner = repository.getOwnerName();
        String name = repository.getRepoName();

        Subscription subscriptionBranches = dataRepository.getRepoBranches(owner, name)
                .map(branchesMapper)
                .subscribe(new Observer<List<Branch>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                        Log.d("RepolistPreasenter", name + " MAME");
                        Log.d("RepolistPreasenter", owner + " OWNER");


                        Log.d("RepolistPreasenter", e.getMessage() + " ERROR MESSAGE");

                    }

                    @Override
                    public void onNext(List<Branch> list) {
                        branchList = list;
                        view.showBranches(list);
                    }
                });
        addSubscription(subscriptionBranches);

        Subscription subscriptionContributors = dataRepository.getRepoContributors(owner, name)
                .map(contributorsMapper)
                .subscribe(new Observer<List<Contributor>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                        Log.d("RepolistPreasenter", e.getMessage() + " ERROR MESSAGE");

                    }

                    @Override
                    public void onNext(List<Contributor> list) {
                        contributorList = list;
                        view.showContributors(list);
                    }
                });

        addSubscription(subscriptionContributors);
    }

    public void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            contributorList = (List<Contributor>) savedInstanceState.getSerializable(BUNDLE_CONTRIBUTORS_KEY);
            branchList = (List<Branch>) savedInstanceState.getSerializable(BUNDLE_BRANCHES_KEY);
        }

        if (contributorList == null || branchList == null) {
            loadData();
        } else {
            view.showBranches(branchList);
            view.showContributors(contributorList);
        }

    }

    public void onSaveInstanceState(Bundle outState) {
        if (contributorList != null)
            outState.putSerializable(BUNDLE_CONTRIBUTORS_KEY, new ArrayList<>(contributorList));
        if (branchList != null)
            outState.putSerializable(BUNDLE_BRANCHES_KEY, new ArrayList<>(branchList));

    }
}
