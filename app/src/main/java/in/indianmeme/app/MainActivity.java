package in.indianmeme.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import in.indianmeme.app.ModelApi.AddImz.AddPicModel;
import in.indianmeme.app.presenter.AddImzPresenter;
import in.indianmeme.app.presenter.AddVideoPresenter;
import in.indianmeme.app.views.AddImzContract;
import in.indianmeme.app.views.AddVideoContract;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements AddImzContract.AddImzView, AddVideoContract.AddVideoView {


    FragmentHomePage fragmentHomePage;
    FragmentLoginUserHome fragmentUserLoginHome;
    ImageView logout;
    ImageView home, perosn, add;
    AddImzPresenter addImzPresenter;
    AddVideoPresenter addVideoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logout = findViewById(R.id.massanger_imz);
        home = findViewById(R.id.home_imz);
        perosn = findViewById(R.id.person_image);
        add = findViewById(R.id.add_image);
        addImzPresenter = new AddImzPresenter(this);
        addVideoPresenter = new AddVideoPresenter(this);


        fragmentHomePage = new FragmentHomePage();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragmentHomePage)
                .commit();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("*/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constant.REQUEST_CODE_PICTURE);
            }
        });

        perosn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dddd", "fff");

                fragmentUserLoginHome = new FragmentLoginUserHome();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragmentUserLoginHome)
                        .addToBackStack("ggg")
                        .commit();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentHomePage = new FragmentHomePage();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, fragmentHomePage)
                        .commit();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constant.REQUEST_CODE_PICTURE) {
            Uri uri = data.getData();


            if (requestCode == Constant.REQUEST_CODE_PICTURE) {

                if (uri.toString().contains("jpg")) {
                    try {
                        String fileName = uri.getPath().split(":")[1];

                        InputStream is = getContentResolver().openInputStream(uri);
                        Bitmap bitmap = Constant.getScaledBitmap(BitmapFactory.decodeStream(is));
                        is.close();

                        File file = new File(getCacheDir() + File.separator + fileName + ".jpg");
                        OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, os);
                        os.close();

                        Log.e("data", Constant.getPath(this, data.getData()));
//                      RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
                        RequestBody requestBodyImage = RequestBody.create(MediaType.parse("*/*"), file);

                        MultipartBody.Part images = MultipartBody.Part.createFormData("images[]", file.getName(), requestBodyImage);
                        MultipartBody.Part server_key = MultipartBody.Part.createFormData("server_key", Constant.SERVER_KEY);
                        MultipartBody.Part access_token = MultipartBody.Part.createFormData("access_token", PrefUtils.getAccessToken());
                        MultipartBody.Part caption = MultipartBody.Part.createFormData("caption", "sd");
                        addImzPresenter.getData(images, server_key, access_token, caption);
                        Log.e("dddd", "image");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Glide.with(this)
                            .load(uri)
                            .addListener(new RequestListener<Drawable>() {
                                @Override
                                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                    return false;
                                }

                                @Override
                                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                    Bitmap bitmap1 = ((BitmapDrawable) resource).getBitmap();
                                    File file1 = new File(getCacheDir() + File.separator + "sds.jpg");
                                    File file = new File(getCacheDir() + File.separator + "ssvs`.mp4");

                                    try {
                                        FileOutputStream fos = new FileOutputStream(file1);
                                        bitmap1.compress(Bitmap.CompressFormat.JPEG, 90, fos);
                                        fos.flush();
                                        fos.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    RequestBody requestBodyThumb = RequestBody.create(MediaType.parse("*/*"), file1);

                                    MultipartBody.Part video = MultipartBody.Part.createFormData("video", file1.getName(), requestBodyThumb);
                                    MultipartBody.Part server_key = MultipartBody.Part.createFormData("server_key", Constant.SERVER_KEY);
                                    MultipartBody.Part access_token = MultipartBody.Part.createFormData("access_token", PrefUtils.getAccessToken());
                                    MultipartBody.Part caption = MultipartBody.Part.createFormData("caption", "sd");
                                    MultipartBody.Part thumb = MultipartBody.Part.createFormData("thumb", file1.getName(), requestBodyThumb);
                                    addVideoPresenter.getData(video, server_key, access_token, thumb, caption);
                                    Log.e("dddd", "video");

                                    return false;
                                }
                            })
                            .preload();
                }

            }
        }

    }

    @Override
    public void setLatestData(AddPicModel addPic) {
        Toast.makeText(getApplicationContext(), addPic.getMessage(), Toast.LENGTH_SHORT).show();
    }
}