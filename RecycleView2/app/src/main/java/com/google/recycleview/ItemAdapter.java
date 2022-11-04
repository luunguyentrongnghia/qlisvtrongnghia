package com.google.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private Context mContext;
    private List<Item> mListItem;

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;

    }
    public void setData(List<Item> list) {
        this.mListItem= list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thietbi,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = mListItem.get(position);
        if (item == null) {
            return;
        }
        holder.img_Item.setImageResource(item.getResourceImage());
        holder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if (mListItem !=null){
            return mListItem.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_Item;
        private TextView tvName;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Item= itemView.findViewById(R.id.image_item);
            tvName= itemView.findViewById(R.id.tv_name );
        }
    }
}
