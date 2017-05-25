package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.mappers;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.ContributorDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Contributor;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class RepoContributorsMapper implements Func1<List<ContributorDTO>, List<Contributor>> {
    @Override
    public List<Contributor> call(List<ContributorDTO> contributorDTOs) {
        List<Contributor> contributors = Observable.from(contributorDTOs)
                .map(contributorDTO -> new Contributor(contributorDTO.getLogin()))
                .toList()
                .toBlocking()
                .first();

        return contributors;

    }
}
