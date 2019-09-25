package onebyte.com.colortabs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import onebyte.com.colortabs.model.Menu;


public class ListItemAdapter extends  RecyclerView.Adapter<ListItemAdapter.MyHolder> {

    private Context context;
    private List<Menu> list;

    public ListItemAdapter(Context context, List<Menu> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyHolder holder = new MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Menu menu = list.get(position);
        holder.picture.setImageDrawable(context.getResources().getDrawable(menu.getPicture()));
        holder.nameOfDish.setText(menu.getDishName());
        holder.restaurantName.setText(menu.getCafeName());
        holder.review.setText(menu.getReviewAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView nameOfDish, restaurantName, review;

        public MyHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            nameOfDish = (TextView) itemView.findViewById(R.id.nameOfDish);
            restaurantName = (TextView) itemView.findViewById(R.id.restaurantName);
            review = (TextView) itemView.findViewById(R.id.review);
        }
    }
}
