package in.indianmeme.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.ModelApi.Login.LoginModel;
import in.indianmeme.app.ModelApi.UserData.UserDataModel;
import in.indianmeme.app.presenter.LoginPresenter;
import in.indianmeme.app.presenter.UserDataPresenter;
import in.indianmeme.app.views.UserDataContract;
import in.indianmeme.app.views.UserLoginContract;

public class ActivityLogin extends AppCompatActivity implements UserLoginContract.LoginView, UserDataContract.UserView {
    TextView register;
    EditText email, password;
    Button signIn;
    LoginModel loginModel;
    UserDataPresenter userDataPresenter;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.text_register);
        email = findViewById(R.id.text_emaillogin);
        password = findViewById(R.id.text_passwordlogin);
        signIn = findViewById(R.id.btn_signin);

        loginPresenter = new LoginPresenter(this);
        userDataPresenter = new UserDataPresenter(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                Map<String, Object> map = new HashMap<>();
                map.put("server_key", Constant.SERVER_KEY);
                map.put("username", mail);
                map.put("password", pass);

                loginPresenter.getData(map);


            }

        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setLatestData(LoginModel loginModel) {

        String accessToken = loginModel.getData().getAccessToken();
        int getid = loginModel.getData().getUserId();
//        saveData(Constant.ACCESS_TOKEN, accessToken);
//        saveData(Constant.USER_ID, getid);
//        PrefUtils prefUtils = new PrefUtils(this);
        PrefUtils.setAccessToken(accessToken);
        PrefUtils.setUserId(getid);
        Map<String, Object> map = new HashMap<>();
        map.put("server_key", Constant.SERVER_KEY);
        map.put("access_token", PrefUtils.getAccessToken());
        map.put("user_id", PrefUtils.getUserId());
        userDataPresenter.getData(map);


    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLatestData(UserDataModel userDataModel) {
        String avatar = userDataModel.getData().getAvatar();
        PrefUtils.setAvatar(avatar);
        Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
        startActivity(intent);

    }
}
