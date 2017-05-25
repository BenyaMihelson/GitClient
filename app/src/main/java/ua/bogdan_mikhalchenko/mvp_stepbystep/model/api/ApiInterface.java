package ua.bogdan_mikhalchenko.mvp_stepbystep.model.api;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.BranchDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.ContributorDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.RepositoryDTO;

/**
 * Created by Shipohvost on 11.05.2017.
 */

public interface ApiInterface {

    @GET("users/{user}/repos")
    Observable<List<RepositoryDTO>> getRepositories(@Path("user") String user);

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<ContributorDTO>> getContributors(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/branches")
    Observable<List<BranchDTO>> getBranches(@Path("owner") String owner, @Path("repo") String repo);

}
