package ua.bogdan_mikhalchenko.mvp_stepbystep.view.adapters;

import java.util.List;

import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.RepoListPresenter;
import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Repository;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class RepoListAdapter extends BaseAdapter<Repository> {
    private RepoListPresenter presenter;


    public RepoListAdapter(List<Repository> list, RepoListPresenter presenter) {
        super(list);
        this.presenter = presenter;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        Repository repo = list.get(i);
        viewHolder.text.setText(repo.getRepoName());
        viewHolder.text.setOnClickListener(v -> presenter.clickRepo(repo));
    }

    public void setRepoList(List<Repository> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
