package ayaseruri.x.twittersearch.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ayaseruri.x.twittersearch.R;
import ayaseruri.x.twittersearch.objectholder.SearchResultInfo;

/**
 * Created by ayaseruri on 15/12/19.
 */
public class SearchListAdaptar extends RecyclerView.Adapter<SearchListAdaptar.ViewHolder> {

    private SearchResultInfo searchResultInfo;
    private Context mContext;
    private ItemClick itemClick;

    public SearchListAdaptar(Context mContext, SearchResultInfo searchResultInfo, ItemClick itemClick) {
        this.searchResultInfo = searchResultInfo;
        this.mContext = mContext;
        this.itemClick = itemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.search_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SimpleDraweeView userAvatar = (SimpleDraweeView)holder.itemView.findViewById(R.id.user_avatar);
        TextView content = (TextView)holder.itemView.findViewById(R.id.content);

        final SearchResultInfo.StatusesEntity statusesEntity = searchResultInfo.getStatuses().get(position);
        String avatarUrl = statusesEntity.getUser().getProfile_image_url();
        if(null != avatarUrl){
            userAvatar.setImageURI(Uri.parse(avatarUrl));
        }
        content.setText(statusesEntity.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onSearchItemClick(position, statusesEntity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchResultInfo.getStatuses().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface ItemClick{
        void onSearchItemClick(int postion, SearchResultInfo.StatusesEntity statusesEntity);
    }
}
