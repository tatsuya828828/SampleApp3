package com.kuma.sampleapp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リストに表示するデータを準備
        String[] titles = {"pagan", "Silence Speaks", "DOWN", "Player Position", "蛍"};
        String[] tags = {"Vitalism", "While She Sleeps", "Destine", "Periphery", "THE BACK HORN"};
        String[] descs = {"ブラジルのバンドの曲です", "イギリスのバンドの曲です", "オランダのバンドの曲です",
                        "アメリカのバンドの曲です", "日本のバンドの曲です"};
        // 配列の内容をListItemオブジェクトに詰め替え
        ArrayList<ListItem> data = new ArrayList<>();
        for(int i = 0; i < titles.length; i++) {
            ListItem item = new ListItem();
            item.setId((new Random()).nextLong());
            item.setTitle(titles[i]);
            item.setTag(tags[i]);
            item.setDesc(descs[i]);
            data.add(item);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 固定サイズの場合にパフォーマンスを向上
        // setHasFixedSizeはRecyclerViewのサイズが固定であることを宣言する
        // あらかじめ宣言しておくことでパフォーマンスが向上する
        recyclerView.setHasFixedSize(true);
        // レイアウトマネージャーの準備&設定
        // レイアウトを制御するためのレイアウトマネージャーを準備
        // LinearLayoutManagerオブジェクトは、縦並び/横並びのリストを生成するためのレイアウトマネージャー
        // 最低限、setOrientationでリストのスクロール方向を決定しておく必要がある
        // VERTICALで縦、HORIZONTALで横にスクロールする
        // 生成したレイアウトマネージャーは、RecyclerManager.setLayoutManagerでRecyclerViewに設定できる
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        // アダプターをRecyclerManagerに設定
        // アダプター(今回は、MyListAdapter)を生成し、setAdapterでRecyclerViewに割り当てる
        RecyclerView.Adapter adapter = new MyListAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}