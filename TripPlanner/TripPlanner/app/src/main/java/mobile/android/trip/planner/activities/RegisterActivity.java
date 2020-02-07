package mobile.android.trip.planner.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import mobile.android.trip.planner.R;
import mobile.android.trip.planner.model.UserBean;

public class RegisterActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    EditText edtUsername, edtName, edtEmail, edtPhone, edtLocation, edtCountry, edtState, edtPass, edtConfPass;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtUsername = findViewById(R.id.edtUsername);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtLocation = findViewById(R.id.edtLocation);
        edtCountry = findViewById(R.id.edtCountry);
        edtState = findViewById(R.id.edtState);
        edtPass = findViewById(R.id.edtPass);
        edtConfPass = findViewById(R.id.edtConfPass);
        btnRegister = findViewById(R.id.btnRegister);
        databaseReference = FirebaseDatabase.getInstance().getReference("user_data");
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        changeStatusBarColor();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidate()) {
                    String country = edtCountry.getText().toString().trim();
                    String emailId = edtEmail.getText().toString().trim();
                    String location = edtLocation.getText().toString().trim();
                    String name = edtName.getText().toString().trim();
                    String password = edtPass.getText().toString().trim();
                    String phone = edtPass.getText().toString().trim();
                    String state = edtState.getText().toString().trim();
                    String username = edtUsername.getText().toString().trim();
                    UserBean userBean = new UserBean(country, emailId, location, name, password, phone, state, username);
                    registerUser(userBean);
                    Toast.makeText(RegisterActivity.this, "User register successfully", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    private void registerUser(UserBean userBean) {
        databaseReference.push().setValue(userBean);
    }

    private boolean isValidate() {
        if (edtUsername.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
            edtUsername.requestFocus();
            return false;
        } else if (edtName.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            edtName.requestFocus();
            return false;

        } else if (edtEmail.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            edtEmail.requestFocus();
            return false;

        } else if (edtPhone.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter phone", Toast.LENGTH_SHORT).show();
            edtPhone.requestFocus();
            return false;

        } else if (edtLocation.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter location", Toast.LENGTH_SHORT).show();
            edtLocation.requestFocus();
            return false;

        } else if (edtCountry.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter country", Toast.LENGTH_SHORT).show();
            edtCountry.requestFocus();
            return false;

        } else if (edtState.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter state", Toast.LENGTH_SHORT).show();
            edtState.requestFocus();
            return false;

        } else if (edtPass.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            edtPass.requestFocus();
            return false;

        } else if (edtConfPass.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
            edtConfPass.requestFocus();
            return false;

        } else if (!edtPass.getText().toString().trim().equals(edtConfPass.getText().toString().trim())) {
            Toast.makeText(this, "Password and confirm password should be same", Toast.LENGTH_SHORT).show();
            edtPass.requestFocus();
            return false;
        }
        return true;
    }
}
