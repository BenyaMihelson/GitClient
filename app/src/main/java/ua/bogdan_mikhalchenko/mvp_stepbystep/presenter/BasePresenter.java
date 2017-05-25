package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.Model;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.ModelImpl;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class BasePresenter implements Presenter {
    protected Model dataRepository = new ModelImpl();
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected void addSubscription(Subscription subscription){
        compositeSubscription.add(subscription);
    }

    @Override
    public void onStop() {

    }
}
