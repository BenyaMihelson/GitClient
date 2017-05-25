package ua.bogdan_mikhalchenko.mvp_stepbystep.view.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Contributor;

/**
 * Created by Shipohvost on 16.05.2017.
 */

public class ContributorsAdapter extends BaseAdapter<Contributor> {

    public ContributorsAdapter(List<Contributor> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        String text = list.get(i).getName();
        viewHolder.text.setText(text);
    }
}