package com.example.tablayoutsample;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private boolean isPlaying;
    Context context;
    ArrayList<VideoModel> videoModels;

    public VideoAdapter(Context context, ArrayList<VideoModel> videoModels) {
        this.context = context;
        this.videoModels = videoModels;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_video,parent,false);
        VideoAdapter.ViewHolder viewHolder = new VideoAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        VideoModel model=(VideoModel) videoModels.get(position);
        holder.videoView.setVideoPath(model.getVideourl());
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.video_view);

        }
    }
}
