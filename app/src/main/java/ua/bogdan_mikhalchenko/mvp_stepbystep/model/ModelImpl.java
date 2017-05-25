package ua.bogdan_mikhalchenko.mvp_stepbystep.model;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.api.ApiInterface;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.api.ApiModule;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.BranchDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.ContributorDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.RepositoryDTO;

/**
 * Created by Shipohvost on 11.05.2017.
 */

public class ModelImpl implements Model {

    private final Observable.Transformer schedulersTransformer;
    ApiInterface apiInterface = ApiModule.getApiInterface();

    public ModelImpl() {
        schedulersTransformer = o -> ((Observable) o ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }


    @Override
    public Observable<List<RepositoryDTO>> getRpoList(String name) {

        return apiInterface
                .getRepositories(name)
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<BranchDTO>> getRepoBranches(String owner, String name) {
        return apiInterface
                .getBranches(owner, name)
                .compose(applySchedulers());
    }

    @Override
    public Observable<List<ContributorDTO>> getRepoContributors(String owner, String name) {
        return apiInterface
                .getContributors(owner, name)
                .compose(applySchedulers());
    }
    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }
}
