package com.example.indiapm.sampledatademoapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.indiapm.sampledatademoapp.R;
import com.example.indiapm.sampledatademoapp.model.NotificationsData;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {
    private final Context mContext;
    private final List<NotificationsData.MemberNotification> listMemberNotifications;

    public DemoAdapter(Context mContext, List<NotificationsData.MemberNotification> memberNotifications) {
        this.mContext = mContext;
        this.listMemberNotifications = memberNotifications;
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final TextView tvDate;
        private final ImageView imageView;

        public DemoViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_person, parent, false);
        DemoViewHolder holder = new DemoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
        NotificationsData.MemberNotification notificationsData = listMemberNotifications.get(position);
        holder.tvTitle.setText(notificationsData.getDescription());
        holder.tvDate.setText(notificationsData.getOnDateTime());
        holder.imageView.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return listMemberNotifications.size();
    }

}
