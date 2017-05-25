package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.mappers;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto.BranchDTO;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Branch;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class RepoBranchesMapper implements Func1<List<BranchDTO>, List<Branch>> {
    @Override
    public List<Branch> call(List<BranchDTO> branchDTOs) {
        List<Branch> branches  = Observable.from(branchDTOs)
                .map(branchDTO -> new Branch(branchDTO.getName()))
                .toList()
                .toBlocking()
                .first();

        return branches;
    }
}
