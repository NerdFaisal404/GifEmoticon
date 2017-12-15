package com.hoanganhtuan95ptit.gifemoticon.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hoanganhtuan95ptit.emoticon.EmoticonTextView;
import com.hoanganhtuan95ptit.gifemoticon.R;
import com.hoanganhtuan95ptit.gifemoticon.model.Message;
import com.hoanganhtuan95ptit.gifemoticon.utils.GifEmoticonProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HoangAnhTuan on 10/7/2017.
 */

public class ChatAdapter extends BaseAdapter<Message> {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public ChatAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getSlide()) {
            case LEFT:
                return LEFT;
            default:
                return RIGHT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case LEFT:
                view = inflater.inflate(R.layout.item_chat_left, parent, false);
                break;
            case RIGHT:
                view = inflater.inflate(R.layout.item_chat_right, parent, false);
                break;
            default:
                view = inflater.inflate(R.layout.item_chat_left, parent, false);
                break;
        }
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvInfor.setEmoticonProvider(GifEmoticonProvider.create());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Message message = list.get(position);
        viewHolder.tvInfor.setText(message.getInfo());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_infor)
        EmoticonTextView tvInfor;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
