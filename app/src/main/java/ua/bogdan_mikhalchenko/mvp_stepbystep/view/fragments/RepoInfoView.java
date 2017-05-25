package ua.bogdan_mikhalchenko.mvp_stepbystep.view.fragments;

import java.util.List;

import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Branch;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Contributor;

/**
 * Created by Shipohvost on 16.05.2017.
 */

public interface RepoInfoView extends View {

    void showContributors(List<Contributor> contributors);

    void showBranches(List<Branch> branches);

}
