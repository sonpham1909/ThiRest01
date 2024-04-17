package com.example.thirest01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView ls_v;
    List<XeMayModel> list;
    XeMayModel xeMayModel;
    APIservice apIservice;

    XeMayAdapter xeMayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ls_v = findViewById(R.id.listView);
        FloatingActionButton btnAdd = findViewById(R.id.btnadd);


        list = new ArrayList<>();
        xeMayAdapter = new XeMayAdapter(list,this);
        ls_v.setAdapter(xeMayAdapter);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIservice.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apIservice = retrofit.create(APIservice.class);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themXE();
            }
        });

        getXefromServer();

    }

    private void getXefromServer() {
        Call<List<XeMayModel>> call = apIservice.getXe();

        call.enqueue(new Callback<List<XeMayModel>>() {
            @Override
            public void onResponse(Call<List<XeMayModel>> call, Response<List<XeMayModel>> response) {
                if ((response.isSuccessful())){
                    list.clear();
                    list.addAll(response.body());
                    xeMayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<XeMayModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Looi goi du lieu", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void themXE() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view  = LayoutInflater.from(this).inflate(R.layout.add_xe,null);
        EditText edtName = view.findViewById(R.id.Edt_ten_xe);
        EditText edtMau = view.findViewById(R.id.Edt_mau_xe);
        EditText edtGia = view.findViewById(R.id.Edt_gia_xe);
        EditText edtMota = view.findViewById(R.id.Edt_mo_ta_xe);
        EditText edtHinh = view.findViewById(R.id.Edt_hinh_anh);
        builder.setView(view);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name  = edtName.getText().toString();
                String mau  = edtMau.getText().toString();

                String mota  = edtMota.getText().toString();
                String hinhanh  = edtHinh.getText().toString();

                if (!name.isEmpty()||!mau.isEmpty()||!edtGia.getText().toString().isEmpty()||!mota.isEmpty()||!hinhanh.isEmpty()){
                    double gia  = Double.parseDouble(edtGia.getText().toString());
                    XeMayModel newXe = new XeMayModel(name,mau,gia,mota,hinhanh);

                    Call<Void> call =APIservice.apIservice.addXe(newXe);

                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                           if (response.isSuccessful()){
                               getXefromServer();
                               Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                           }else{
                               Toast.makeText(MainActivity.this, "Loi khi them xe moi", Toast.LENGTH_SHORT).show();

                           }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Loi khi gui yru cau them xe moi", Toast.LENGTH_SHORT).show();

                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this, "Nhap day du thong tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }



}