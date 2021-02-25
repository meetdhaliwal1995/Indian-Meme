package in.indianmeme.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import in.indianmeme.app.ModelApi.UserRegisterModel.UserRegisterModel;
import in.indianmeme.app.presenter.RegisterUserPresenter;
import in.indianmeme.app.views.UserRegisterContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRegister extends AppCompatActivity implements UserRegisterContract.UserView {

    public static final String Mypre = "Mypres";
    ImageView back;
    EditText email, username, password, confirm;
    Button createAccount;
    TextView signIN;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back = findViewById(R.id.back_imz);
        email = findViewById(R.id.text_email);
        username = findViewById(R.id.text_username);
        password = findViewById(R.id.text_password);
        confirm = findViewById(R.id.text_confirmpassword);
        createAccount = findViewById(R.id.text_createaccount);
        signIN = findViewById(R.id.text_signin);
        final RegisterUserPresenter presenter = new RegisterUserPresenter(this);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRegister.this, ActivityFront.class);
                startActivity(intent);
            }
        });

        signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                startActivity(intent);
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = email.getText().toString();
                String userName = username.getText().toString();
                String passWord = password.getText().toString();
                String confirmPassword = confirm.getText().toString();

                if (userEmail.isEmpty()) {
                    Toast.makeText(ActivityRegister.this, "field can't empty", Toast.LENGTH_SHORT).show();
                } else if (userName.isEmpty()) {
                    Toast.makeText(ActivityRegister.this, "field can't empty", Toast.LENGTH_SHORT).show();
                } else if (passWord.isEmpty()) {
                    Toast.makeText(ActivityRegister.this, "field can't empty", Toast.LENGTH_SHORT).show();
                } else if (confirmPassword.isEmpty()) {
                    Toast.makeText(ActivityRegister.this, "field can't empty", Toast.LENGTH_SHORT).show();
                } else if (!(passWord.equals(confirmPassword))) {
                    Toast.makeText(ActivityRegister.this, "password not match", Toast.LENGTH_SHORT).show();

                } else {
                    Map<String, Object> map = new HashMap<>();

                    map.put("server_key", Constant.SERVER_KEY);
                    map.put("email", userEmail);
                    map.put("username", userName);
                    map.put("password", passWord);
                    map.put("conf_password", confirmPassword);

                    presenter.getData(map);
                }
            }
        });


    }

    public void retrofit(Map<String, Object> map) {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);


        networkInterface.registerUser(map).enqueue(new Callback<UserRegisterModel>() {
            @Override
            public void onResponse(Call<UserRegisterModel> call, Response<UserRegisterModel> response) {
                Log.e("data", response.toString());
                if (response.body().getStatus().equals("ok")) {
                    String accesstoken = response.body().getData().getAccessToken();
                    saveData(Constant.ACCESS_TOKEN, accesstoken);
                }
            }

            @Override
            public void onFailure(Call<UserRegisterModel> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }

    public void saveData(String key, String value) {
        sharedPreferences = getSharedPreferences(Mypre, MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(key, value)
                .apply();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setLatestData(UserRegisterModel userRegister) {
        if (userRegister.getCode().equals(Constant.OK)) {
            String accesstoken = userRegister.getData().getAccessToken();
            saveData(Constant.ACCESS_TOKEN, accesstoken);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
