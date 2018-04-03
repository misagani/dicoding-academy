// by MisaGani 2018
// Tesla Showcase

package com.misagani.teslashowcase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rvCategory;
    private ArrayList<Tesla> list;
    private ArrayList<Tesla> listSortir;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(TeslaData.getListData());
        listSortir = new ArrayList<>();

        showCardView();
    }

    private void showCardView()
    {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(this);
        cardViewAdapter.setListTesla(list);
        rvCategory.setAdapter(cardViewAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener()
        {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v)
            {
                showDetail(position);
            }
        });
    }

    private void showDetail(int position)
    {
        listSortir.removeAll(TeslaData.getListData());
        listSortir.addAll(TeslaData.getListData().subList(position,position + 1));

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        DetailsActivity detailActivity = new DetailsActivity(this);
        detailActivity.setDetailTesla(listSortir);
        rvCategory.setAdapter(detailActivity);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener()
        {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v)
            {
                showCardView();
            }
        });
    }
}