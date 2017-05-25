package ua.bogdan_mikhalchenko.mvp_stepbystep.model;

import java.util.List;

import rx.Observable;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.BranchDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.ContributorDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.RepositoryDTO;

/**
 * Created by Shipohvost on 11.05.2017.
 */

public interface Model {
    Observable<List<RepositoryDTO>> getRpoList(String name);
    Observable<List<BranchDTO>> getRepoBranches(String owner, String name);
    Observable<List<ContributorDTO>> getRepoContributors(String owner, String name);
}
