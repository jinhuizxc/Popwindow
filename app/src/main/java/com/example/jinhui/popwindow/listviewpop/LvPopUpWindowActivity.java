package com.example.jinhui.popwindow.listviewpop;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.jinhui.popwindow.MainActivity;
import com.example.jinhui.popwindow.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/23.
 */
public class LvPopUpWindowActivity extends AppCompatActivity {

    @BindView(R.id.bt_click)
    Button btClick;
    @BindView(R.id.bt_lvPopUp2)
    Button btLvPopUp2;

    private String[] tv_state_value = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "ListViewPopUpWindow"};


    // 方式2
    private ListViewAdapter mListViewAdapter;
    private ListView mPopListView;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvpop);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {
        for (int i = 1; i <= 50; i++) {
            mData.add("Hello Android " + i);
        }
    }


    @OnClick({R.id.bt_click, R.id.bt_lvPopUp2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_click:
                showListPopupWindow();
                break;
            case R.id.bt_lvPopUp2:
                showPopupWindow();
                break;
            default:
                break;
        }

    }

    private void showPopupWindow() {
        View view = View.inflate(LvPopUpWindowActivity.this, R.layout.popup_window, null);
        mPopListView = (ListView) view.findViewById(R.id.pop_list_view);

        PopupWindow popupWindow = new PopupWindow(view, DisplayUtils.dp2px(this, 200),
                DisplayUtils.dp2px(this, 240), true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.update();
        popupWindow.showAsDropDown(btLvPopUp2, DisplayUtils.dp2px(this, 200), 80);  // 设置偏移量

        mListViewAdapter = new ListViewAdapter(this, mData, popupWindow);
        mPopListView.setAdapter(mListViewAdapter);

    }

    private void showListPopupWindow() {
        int[] location = new int[2];
        btClick.getLocationOnScreen(location);

        final ListViewPopUpWindow popUpWindow = new ListViewPopUpWindow(
                this, tv_state_value, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 0); //这里的最后一个参数是popupWindow的背景

        popUpWindow.setOnMyItemClickListener(new ListViewPopUpWindow.MyClickListener() {
            @Override
            public void ItemClick(int index, String str) {
                btClick.setText(str);
                popUpWindow.dismiss();
            }
        });


        popUpWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //处理popupWindow消失时处理的事情
                Toast.makeText(LvPopUpWindowActivity.this, "popupWindow消失", Toast.LENGTH_SHORT).show();
            }
        });

        popUpWindow.showAtLocation(btClick, Gravity.NO_GRAVITY, location[0], location[1] + btClick.getHeight());


    }
}
