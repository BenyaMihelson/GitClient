package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.mappers;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.RepositoryDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Repository;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class RepoListMapper implements Func1<List<RepositoryDTO>, List<Repository>> {
    @Override
    public List<Repository> call(List<RepositoryDTO> repositoryDTOs) {
        if (repositoryDTOs == null) {
            return null;
        }
        List<Repository> repositoryList = Observable.from(repositoryDTOs)
                .map(repositoryDTO -> new Repository(repositoryDTO.getName(), repositoryDTO.getOwner().getLogin()))
                .toList()
                .toBlocking()
                .first();

        return repositoryList;
    }
}
