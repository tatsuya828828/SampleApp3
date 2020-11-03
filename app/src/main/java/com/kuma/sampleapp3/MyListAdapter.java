package com.kuma.sampleapp3;

import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// RecyclerView.Adapter派生クラスを定義する場合は、RecyclerView.Adapter<MyViewHolder>のように
// まずは型パラメーターとしてアダプターで利用するビューホルダーを割り当てておく必要がある
// これは、MyListAdapterアダプターでは、MyViewHolderクラスを利用してビューを処理するという意味になる
public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<ListItem> data;

    // コンストラクター(データソースを準備)
    // リスト表示に必要な情報をArrayist<ListItem>型として受け取っている
    // ListItemクラスは、アダプターに引き渡すデータ一項目を表すデータオブジェクトである
    public MyListAdapter(ArrayList<ListItem> data) {
        this.data = data;
    }

    // onCreateViewHolder、onVindViewHolder、getItemCountは、
    // アダプターで最低限オーバーライドしなければならないメソッド

    // ビューホルダーを生成
    // onCreateViewHolderは、レイアウトマネージャーによって呼び出され、新たなビューホルダーを生成する
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // レイアウトファイルからViewオブジェクトを生成するには、LayoutInflater.inflateメソッドを利用する
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // 生成されたViewオブジェクトを元に、
        // ビューホルダー(MyViewHolderオブジェクト)をインスタンス化して、戻り値として返す。
        return new MyViewHolder(view);
    }

    // ビューにデータを割り当て、リスト項目を生成
    // onBindViewHolderは、リストないの個々の項目を生成する際に呼び出される、
    // 今回は既にonCreateViewHolderで用意されているため、データソースの値を、
    // 個々のプロパティ(holder.title、holder.tag、holder.desc)に個々の項目を割り当てるだけでよい
    // onBindViewHolderには引数にpositionとして、現在処理しているリスト項目のインデックス番号が渡されているため、
    // 個々の値には、hits.data.get(position)でアクセスできる
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(this.data.get(position).getTitle());
        holder.tag.setText(this.data.get(position).getTag());
        holder.desc.setText(this.data.get(position).getDesc());
    }

    // データの項目数を取得
    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
