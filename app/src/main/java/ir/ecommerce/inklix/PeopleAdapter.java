package ir.ecommerce.inklix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>  {
    private Context context;
    private String[] publisherName;
    private String[] publisherBio;
    private int[] images;

    public PeopleAdapter(Context context, String[] publisherName, String[] publisherBio, int[] images) {
        this.context = context;
        this.publisherBio = publisherBio;
        this.publisherName = publisherName;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_publisher,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.publisherName.setText(publisherName[position]);
        holder.publisherBio.setText(publisherBio[position]);
        holder.publisher_photo.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return publisherName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView publisherName , publisherBio;
        public ImageView publisher_photo;


        public ViewHolder(View itemView) {
            super(itemView);
            publisherName = (TextView) itemView.findViewById(R.id.publisher_name);
            publisherBio = (TextView) itemView.findViewById(R.id.publisher_bio);
            publisher_photo = (ImageView) itemView.findViewById(R.id.publisher_img);

        }
    }
}
