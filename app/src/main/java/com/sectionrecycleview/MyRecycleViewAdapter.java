package com.sectionrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int CHILD_VIEW = Integer.MIN_VALUE;
    private final int GROUP_VIEW = CHILD_VIEW + 1;
    private List<Object> mList;
    private Context mContext;

    public MyRecycleViewAdapter(Context context, List<GroupModel> data) {
        mContext = context;
        mList = getListDataFrom(data);
    }

    private List<Object> getListDataFrom(List<GroupModel> data) {
        List<Object> list = new ArrayList<Object>();
        for (int i=0;i<data.size();i++){
            GroupModel workshopsModel = data.get(i);
            list.add(data.get(i));
            List<ChildModel> workModel = workshopsModel.getWorkshops();
            for (int j=0;j<workModel.size();j++){
                list.add(workModel.get(j));
            }
        }
        return list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == CHILD_VIEW) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_child, parent, false);
            return new ChildViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_group, parent, false);
            return new GroupViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mList.get(position) instanceof GroupModel){
            populateGroupView(holder, position);
        }
        else {
            populateChildView(holder, position);
        }
    }

    private void populateChildView(RecyclerView.ViewHolder holder, int position) {
        ChildViewHolder childViewHolder = (ChildViewHolder) holder;
        ChildModel childModel = (ChildModel)mList.get(position);
        childViewHolder.textView.setText(childModel.getLocation());
    }

    private void populateGroupView(RecyclerView.ViewHolder holder, int position) {
        GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
        GroupModel groupModel = (GroupModel)mList.get(position);
        groupViewHolder.textView.setText(groupModel.getStartDate());
    }


    @Override
    public int getItemCount() {
        if (mList != null && mList.size() > 0)
            return mList.size();
        else
            return 0;
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public GroupViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewGroup);
        }
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ChildViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewChild);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof ChildModel) {
            return CHILD_VIEW;
        } else {
            return GROUP_VIEW;
        }
    }
}