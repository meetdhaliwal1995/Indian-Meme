package in.indianmeme.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentVideoView extends Fragment {
    String url;
    VideoView video;
    VideoCallBack videoCallBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_videoview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        video = view.findViewById(R.id.video_view);

        video.setVideoPath(url);
        video.start();
        video.setOnCompletionListener(mp ->
                videoCallBack.videoCompleted());
    }

    public void setVideoView(String file) {

        url = file;
    }

    public void setVideoCallBack(VideoCallBack videoCallBack) {
        this.videoCallBack = videoCallBack;
    }

    interface VideoCallBack {

        void videoCompleted();
    }
}
