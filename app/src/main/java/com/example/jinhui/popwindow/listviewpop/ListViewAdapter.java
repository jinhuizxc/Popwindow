package com.example.jinhui.popwindow.listviewpop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jinhui.popwindow.R;

import java.util.List;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/23.
 */
public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mData;
    private PopupWindow mPopupWindow;

    public ListViewAdapter(Context context, List<String> data, PopupWindow popupWindow) {
        mContext = context;
        mData = data;
        mPopupWindow = popupWindow;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(mContext, R.layout.adapter_popup_list_view, null);
            holder = new ViewHolder();

            holder.mTextView = (TextView) convertView.findViewById(R.id.tv_item);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(mData.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showToast(mContext, mData.get(position));
                mPopupWindow.dismiss();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView mTextView;
    }

}
