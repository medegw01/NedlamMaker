package com.example.user.nedlamworkshop.IdeaBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.nedlamworkshop.R;

import java.util.ArrayList;

/**
 * Created by Michael on 8/2/2016.
 */
public class viewIdeaAdapter extends BaseAdapter {
    Context context;
    ArrayList<ideasStore> ideasStores;


    public viewIdeaAdapter(Context context, ArrayList<ideasStore> ideasStores) {
        this.context = context;
        this.ideasStores = ideasStores;

    }

    @Override
    public int getCount() {
        return ideasStores.size();
    }

    @Override
    public Object getItem(int position) {
        return ideasStores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.model, parent, false);
        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.model_imageview);
        TextView title = (TextView)convertView.findViewById(R.id.model_title);
        TextView des = (TextView)convertView.findViewById(R.id.model_des);
       // imageView.setImageResource(ideasStores.get(position).getImg());
        imageView.setImageBitmap(ideasStores.get(position).getImg());
        title.setText(ideasStores.get(position).getTitle());
        des.setText(ideasStores.get(position).getDescription());

        return convertView;
    }
}
