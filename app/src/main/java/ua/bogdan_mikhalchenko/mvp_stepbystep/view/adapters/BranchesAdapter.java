package ua.bogdan_mikhalchenko.mvp_stepbystep.view.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo.Branch;

/**
 * Created by Shipohvost on 16.05.2017.
 */

public class BranchesAdapter extends BaseAdapter<Branch> {

    public BranchesAdapter(List<Branch> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder holder, int position) {
        String text = list.get(position).getName();
        holder.text.setText(text);
    }
}
