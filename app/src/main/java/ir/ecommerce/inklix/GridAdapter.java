package ir.ecommerce.inklix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder>  {
    private Context context;
    private int[] imageResource;

    public GridAdapter(Context context , int[] imageResource) {
        this.context = context;
        this.imageResource = imageResource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.post_photo.setImageResource(imageResource[position]);//specify image
    }

    @Override
    public int getItemCount() {
        return imageResource.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView post_photo;

        public ViewHolder(View itemView) {
            super(itemView);
            post_photo = (ImageView) itemView.findViewById(R.id.post_img);

        }
    }
}
