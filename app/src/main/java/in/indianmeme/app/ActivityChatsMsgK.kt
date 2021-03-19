package `in`.indianmeme.app

import `in`.indianmeme.app.Adapters.AdapterGetChat
import `in`.indianmeme.app.ModelApi.GetUserMsg.GetUserMsgModel
import `in`.indianmeme.app.ModelApi.GetUserMsg.MessagesItem
import `in`.indianmeme.app.ModelApi.ProfileModel.Data
import `in`.indianmeme.app.presenter.PostPresenter
import `in`.indianmeme.app.views.PostContract
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.HashMap

class ActivityChatsMsgK : AppCompatActivity(), PostContract.PostView {
    var userImage: ImageView? = null
    var userProfile: ImageView? = null
    var userName: TextView? = null
    var username: TextView? = null
    var followers: TextView? = null
    var post: TextView? = null
    var recyclerView: RecyclerView? = null
    var postPresenter: PostPresenter? = null
    var map: HashMap<String, Any> = HashMap()
    var adapterChat: AdapterGetChat? = null
    var data: Data? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats_msg)
        recyclerView = findViewById(R.id.recycler_chat)
        userImage = findViewById(R.id.user_profile_pic_chat)
        userProfile = findViewById(R.id.profile_dp_chat)
        userName = findViewById(R.id.username_topbar)
        username = findViewById(R.id.username_chat)
        followers = findViewById(R.id.followers_chat)
        post = findViewById(R.id.post_chat)
        data = intent.getParcelableExtra("data")
        postPresenter = PostPresenter(this)
        recyclerView?.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true))
        adapterChat = AdapterGetChat(this, ArrayList<MessagesItem>(),null)
        recyclerView?.setAdapter(adapterChat)
        val into = Glide.with(applicationContext).load(data!!.userData.avatar).circleCrop().into(userImage!!)
        username?.setText(data?.userData?.username)
        Glide.with(applicationContext).load(data!!.userData.avatar).circleCrop().into(userProfile!!)
        userName?.setText(data?.userData?.username)
        followers?.setText(data?.userData?.followers.toString() + "  followers   " + ":  Total Post  " + data!!.userData.postsCount)
        post?.setText(data?.userData?.name)

        map["access_token"] = PrefUtils.getAccessToken()
        map["server_key"] = Constant.SERVER_KEY
        map["user_id"] = data!!.userData.userId
        map["limit"] = 200
        postPresenter?.getUserMsg(map)
        Log.e("dddd", "map")
    }

    override fun setUserMsg(getUserMsgModel: GetUserMsgModel) {
        Log.e("check", "adapter")
        adapterChat?.addMessage(getUserMsgModel.getData().getMessages())
    }
}