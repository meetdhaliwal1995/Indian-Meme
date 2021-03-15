package `in`.indianmeme.app

import `in`.indianmeme.app.Adapters.AdapterHome
import `in`.indianmeme.app.Adapters.AdapterStory
import `in`.indianmeme.app.ModelApi.AddLike.LikesUnlikeModel
import `in`.indianmeme.app.ModelApi.AddStory.AddStoryUser
import `in`.indianmeme.app.ModelApi.Delete.DeletePostModel
import `in`.indianmeme.app.ModelApi.HomePage.Datum
import `in`.indianmeme.app.ModelApi.HomePage.HomePageDataModel
import `in`.indianmeme.app.ModelApi.Logout.LogoutUserModel
import `in`.indianmeme.app.ModelApi.Story.StoryFetchModel
import `in`.indianmeme.app.presenter.PostPresenter
import `in`.indianmeme.app.views.PostContract
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import kotlinx.android.synthetic.main.fragment_home_page.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.*
import java.util.*
import kotlin.collections.HashMap

class FragmentHomePageK : Fragment(), OnRefreshListener,
        InterfaceAdapterHome, FragmentVideoView.VideoCallBack, PostContract.PostView {

    var fragmentUserHome: FragmentUserHome? = null
    var postid: String? = null
    var adapterHome: AdapterHome? = null
    var map1: MutableMap<String, Any?> = HashMap();
    var mapStory: MutableMap<String, Any> = HashMap()
    var mapHome: MutableMap<String, Any> = HashMap();
    var fragmentLoginUserHome: FragmentLoginUserHome? = null
    var adapterStory: AdapterStory? = null
    var postPresenter: PostPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scroll_refresh.setOnRefreshListener(this)
        recycler_2.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
        recycler_2.setLayoutManager(LinearLayoutManager(context))
        adapterHome = AdapterHome(context, ArrayList<Datum>(), this)
        recycler_2.setAdapter(adapterHome)
        adapterStory = AdapterStory(context, ArrayList<`in`.indianmeme.app.ModelApi.Story.Datum>())
        recycler_2.setAdapter(adapterStory)
        recycler_2.addOnChildAttachStateChangeListener(object : OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
                Log.e("dddd", "aaaa")
            }

            override fun onChildViewDetachedFromWindow(view: View) {
                Log.e("ddd", "bbb")
            }
        })
        postPresenter = PostPresenter(this)
        pixel_imz.setOnClickListener(View.OnClickListener { v: View? ->
            val intent = Intent()
            intent.type = "*/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constant.REQUEST_CODE_PICTURE)
        })
        massanger_imz.setOnClickListener(View.OnClickListener { v: View? -> menuPopUp() })

        mapStory["access_token"] = PrefUtils.getAccessToken()
        mapStory["server_key"] = Constant.SERVER_KEY
        //        map.put("limit", 50);
//        homePresenter.getData(map);
//        storyPresenter.getData(mapStory);
        postPresenter?.getStory(mapStory)
        mapHome = HashMap()
        mapHome["access_token"] = PrefUtils.getAccessToken()
        mapHome["server_key"] = Constant.SERVER_KEY
        //        homePresenter.getData(mapHome);
        postPresenter?.getPostHome(mapHome)
        map1 = HashMap()
        map1["access_token"] = PrefUtils.getAccessToken()
        map1["server_key"] = Constant.SERVER_KEY
        map1["post_id"] = postid
        //        likePresenter.getData(map1);
        postPresenter?.getLike(map1)
    }

    override fun callBack(userId: Int) {
        if (userId == PrefUtils.getUserId()) {
            fragmentLoginUserHome = FragmentLoginUserHome()
            fragmentManager!!.beginTransaction()
                    .replace(R.id.container_layout, fragmentLoginUserHome!!)
                    .addToBackStack("ddd")
                    .commit()
            Log.e("ddd", "dddd")
        } else {
            fragmentUserHome = FragmentUserHome()
            fragmentUserHome!!.setid(userId)
            fragmentManager!!.beginTransaction()
                    .replace(R.id.container_layout, fragmentUserHome!!)
                    .addToBackStack("fd")
                    .commit()
            Log.e("ddd", "ffff")
        }
    }

    override fun likeInterface(postId: String) {
        postid = postId
        val mapLike: MutableMap<String, Any> = HashMap()
        mapLike["server_key"] = Constant.SERVER_KEY
        mapLike["access_token"] = PrefUtils.getAccessToken()
        mapLike["post_id"] = postId
        //        likePresenter.getData(mapLike);
        postPresenter?.getLike(mapLike)
    }

    override fun callBackVideo(file: String, pos: Int) {}
    override fun showProgress() {}
    override fun hideProgress() {}
    override fun setHomePagePost(homePageDataModel: HomePageDataModel) {
        scroll_refresh!!.isRefreshing = false
        adapterHome?.addPost(homePageDataModel.getData())
    }

    override fun setStory(storyFetch: StoryFetchModel) {
        Log.e("check", "story add")
        if (!storyFetch.getData().isEmpty()) {
            adapterStory?.addPost(storyFetch.getData())
            Log.e("checkk", "story add")
        } else {
            scroll_refresh!!.visibility = View.GONE
        }
    }

    override fun showError(error: String) {}
    override fun onRefresh() {
        adapterHome?.clearPost()
        adapterStory?.clearStory()
        //        storyPresenter.getData(mapStory);
//        homePresenter.getData(mapHome);
        postPresenter?.getStory(mapStory)
        postPresenter?.getPostHome(mapHome)
    }

    override fun setLike(likesUnlike: LikesUnlikeModel) {}
    override fun setLogoutUser(logoutUser: LogoutUserModel) {
        PrefUtils.setAccessToken(null)
        Toast.makeText(context, logoutUser.getMessage(), Toast.LENGTH_SHORT).show()
        val intent = Intent(activity, ActivityLogin::class.java)
        startActivity(intent)
    }

    override fun deletePost(map: Map<String, Any>, pos: Int) {
//        deletePresenter.getData(map);
        postPresenter?.getDeletePost(map)
        adapterHome?.updateList(pos)
    }

    override fun setDeletePost(deletePost: DeletePostModel) {
        Toast.makeText(context, deletePost.message, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constant.REQUEST_CODE_PICTURE) {
            val uri = data!!.data
            if (requestCode == Constant.REQUEST_CODE_PICTURE) {

//                if (uri.toString().contains("jpg")) {
                try {
                    val fileName = uri!!.path!!.split(":".toRegex()).toTypedArray()[1]
                    val `is` = context!!.contentResolver.openInputStream(uri)
                    val bitmap = Constant.getScaledBitmap(BitmapFactory.decodeStream(`is`))
                    `is`!!.close()
                    val file = File(context!!.cacheDir.toString() + File.separator + fileName + ".jpg")
                    val os: OutputStream = BufferedOutputStream(FileOutputStream(file))
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, os)
                    os.close()
                    Log.e("data", Constant.getPath(context, data.data))
                    //                      RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
                    val requestBodyImage = RequestBody.create("*/*".toMediaTypeOrNull(), file)
                    val story: MultipartBody.Part = MultipartBody.Part.createFormData("file", file.name, requestBodyImage)
                    val server_key: MultipartBody.Part = MultipartBody.Part.createFormData("server_key", Constant.SERVER_KEY)
                    val access_token: MultipartBody.Part = MultipartBody.Part.createFormData("access_token", PrefUtils.getAccessToken())
                    val caption: MultipartBody.Part = MultipartBody.Part.createFormData("caption", "sd")
                    //                    addStoryPresenter.getData(story, server_key, access_token);
                    postPresenter?.getAddStory(story, server_key, access_token)
                    Log.e("dddd", "image")
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun setAddStory(addStoryUser: AddStoryUser) {
        Toast.makeText(context, addStoryUser.data.message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("RestrictedApi")
    private fun menuPopUp() {
        val popupMenu = PopupMenu(context!!, massanger_imz)
        popupMenu.menuInflater
                .inflate(R.menu.menu_popup, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.memu_1 -> {
                    val map1: MutableMap<String, Any> = HashMap()
                    map1["access_token"] = PrefUtils.getAccessToken()
                    map1["server_key"] = Constant.SERVER_KEY
                    postPresenter?.getLogout(map1)
                    Toast.makeText(context, "logout", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_2 -> {
                    val intent = Intent(context, ActivityAllChats::class.java)
                    startActivity(intent)
                }
            }
            false
        }
        val menuHelper = MenuPopupHelper(context!!, (popupMenu.menu as MenuBuilder), massanger_imz)
        menuHelper.setForceShowIcon(true)
        menuHelper.show()

//        popupMenu.show();
    }

    override fun videoCompleted() {}
}