package in.indianmeme.app;

import java.util.Map;

public interface InterfaceAdapterHome {

    void callBack(int userId);

    void likeInterface(String postId);

    void callBackVideo(String file, int pos);

    void deletePost(Map<String, Object> map, int pos);
}
