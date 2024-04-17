package com.example.thirest01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.net.CookieHandler;
import java.util.List;

import retrofit2.Retrofit;

public class XeMayAdapter extends BaseAdapter {

    private List<XeMayModel> xeMayList;

    private Context context;
    private APIservice apIservice;

    public XeMayAdapter(List<XeMayModel> xeMayList, Context context) {
        this.xeMayList = xeMayList;
        this.context = context;

        this.apIservice = APIservice.apIservice;
    }

    @Override
    public int getCount() {
        return xeMayList.size();
    }

    @Override
    public Object getItem(int position) {
        return xeMayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_xe_may,parent,false);
        }

        ImageView img = convertView.findViewById(R.id.img_Xe);

        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_mau = convertView.findViewById(R.id.tv_color);
        TextView tv_gia = convertView.findViewById(R.id.tv_price);
        TextView tv_mo_ta = convertView.findViewById(R.id.tv_note);
        XeMayModel xeMayModel = xeMayList.get(position);

        Picasso.get()
                .load(xeMayModel.getHinh_anh_ph33179())
                .into(img);
        tv_name.setText(xeMayModel.getTen_xe_ph33179());
        tv_mau.setText(xeMayModel.getMau_sac_ph33179());
        tv_gia.setText(String.valueOf(xeMayModel.getGia_ban_ph33179()));
        tv_mo_ta.setText(xeMayModel.getMo_ta_ph33179());

        return convertView;
    }
}
