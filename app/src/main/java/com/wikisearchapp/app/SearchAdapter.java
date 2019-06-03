package com.wikisearchapp.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

public class SearchAdapter  extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private Context context;
    private List<Pages> list;
    private OnclickListener onclickListener;

    public interface OnclickListener {

        void OnItemClick(Pages pageItem);
    }

    public SearchAdapter(Context baseContext, List<Pages> listItems, SearchResult searchResult) {

        this.context = baseContext;
        this.list = listItems;
        this.onclickListener = searchResult;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder viewHolder, int i) {

        Pages pageItem = list.get(i);
        viewHolder.setData(pageItem);
    }

    @Override
    public int getItemCount() {
        if(list == null){
            return 0;}
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView sourceImage;
        TextView title, descriptions;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sourceImage = itemView.findViewById(R.id.sourceImage);
            title = itemView.findViewById(R.id.title);
            descriptions = itemView.findViewById(R.id.description);


        }

        public void setData(Pages pageItem) {

            title.setText(pageItem.getTitle());
            descriptions.setText(pageItem.getTerms().getDescription().get(0));
            try {
                Glide.with(context)
                        .load(pageItem.getThumbnail().getSource())
                        .apply(centerCropTransform()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .placeholder(R.drawable.ic_launcher_background)
                                .error(R.drawable.ic_launcher_background)
                                .priority(Priority.HIGH))
                        .into(sourceImage);
            } catch (Exception e) {

            }

        }
    }

    public  void setList(List<Pages> list) {

        this.list = list;
        this.notifyDataSetChanged();
    }
}
