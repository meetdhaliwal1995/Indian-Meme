package in.indianmeme.app;

import java.util.Map;

public interface InterfaceComment {


    void callBackRply(int commentId, int pos);


    void callUserReply(int commentId);


    void deleteComment(Map<String, Object> map, int adapterPosition);

    void deleteReply(Map<String, Object> map, int adapterPosition);
}
