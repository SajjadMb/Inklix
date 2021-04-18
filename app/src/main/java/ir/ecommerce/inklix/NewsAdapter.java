package ir.ecommerce.inklix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>  {
    private Context context;
    private String[] titles;
    private String[] captions;
    private String[] dates;
    private String[] publishers;
    private int[] images;

    public NewsAdapter(Context context, String[] titles, String[] captions, String[] dates, String[] publishers, int[] images) {
        this.context = context;
        this.titles = titles;
        this.captions = captions;
        this.dates = dates;
        this.publishers = publishers;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_news,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.caption.setText(captions[position]);
        holder.date.setText(dates[position]);
        holder.publisher.setText(publishers[position]);
        holder.post_photo.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title , caption , date , publisher;
        public ImageView btn_trust , btn_scepticism;
        public ImageView post_photo;

        public int trust_flag=0 , scepticism_flag=0;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.post_title);
            caption = (TextView) itemView.findViewById(R.id.post_caption);
            date = (TextView) itemView.findViewById(R.id.post_date);
            publisher = (TextView) itemView.findViewById(R.id.lbl_publisher);
            btn_scepticism = (ImageView) itemView.findViewById(R.id.btn_scepticism);
            btn_trust = (ImageView) itemView.findViewById(R.id.btn_trust);
            post_photo = (ImageView) itemView.findViewById(R.id.post_img);

            btn_trust.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( trust_flag == 0){
                        btn_trust.setImageResource(R.drawable.ic_trust);
                        trust_flag = 1;
                    }else
                    {
                        btn_trust.setImageResource(R.drawable.ic_trust);
                        trust_flag = 0;
                    }

                }
            });


            btn_scepticism.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( trust_flag == 0){
                        btn_scepticism.setImageResource(R.drawable.ic_scepticism);
                        scepticism_flag = 1;
                    }else
                    {
                        btn_scepticism.setImageResource(R.drawable.ic_scepticism);
                        scepticism_flag = 0;
                    }
                }
            });

        }
    }
}
