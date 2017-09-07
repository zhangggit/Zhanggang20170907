package com.example.zhanggang.zhanggang20170907;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyAdapter.onClicklener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加分割线
        MyLine myLine = new MyLine(this, R.drawable.shape);
        recyclerView.addItemDecoration(myLine);
        //设置适配器
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);

        adapter.setOnClicklener(this);
    }
    //添加数据
    private void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("第" + i + "条");
        }
    }
    //点击
    @Override
    public void setonClick(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
    }
}
