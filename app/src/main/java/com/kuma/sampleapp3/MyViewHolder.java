package com.kuma.sampleapp3;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    // ビューに配置されたウィジェットを保持しておくためのフィールド
    TextView title;
    TextView country;
    TextView name;

    // コンストラクター(ウィジェットへの参照を格納)
    MyViewHolder(View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.title);
        this.country = itemView.findViewById(R.id.country);
        this.name = itemView.findViewById(R.id.name);
    }

}
