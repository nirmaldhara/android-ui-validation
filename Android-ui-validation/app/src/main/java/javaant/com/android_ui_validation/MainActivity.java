package javaant.com.android_ui_validation;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javaant.com.android_ui_validation.util.ValidationUtil;

public class MainActivity extends Activity implements  View.OnClickListener {
    EditText txtName;
    EditText txtEmail;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName= (EditText) findViewById(R.id.txtName);
        txtEmail= (EditText) findViewById(R.id.txtEmail);
        txtPassword= (EditText) findViewById(R.id.txtPassword);

    }
@Override
public void onClick(View v){

        boolean flag= ValidationUtil.emptyCheck(txtName, "Name Can not be blank");
        boolean flag2=ValidationUtil.emptyCheck(txtEmail, "Email Id Can not be blank");
        boolean flag3=ValidationUtil.emptyCheck(txtPassword, "Password  Can not be blank");
        boolean flag4=ValidationUtil.emailValidator(txtEmail);
        }
}
