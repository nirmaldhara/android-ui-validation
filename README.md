Follow the below steps to do UI validations in Android. In this tutorial i will show how to do Input validation. Please download the code and run in in your system.
#Step 1
Make a blank android project. If you do not know how to make blank android project, please see my [previous post](http://javaant.com/hello-world-using-android-studio-1-0/#.Vki2PfkrK00).
#Step 2
Write a validation class.

```java
package javaant.com.android_ui_validation.util;

import android.text.TextUtils;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nirmal on 29/07/15.
 */
public class ValidationUtil {
    public static boolean emptyCheck(EditText editText,String message){
        if(TextUtils.isEmpty(editText.getText())){
            editText.setError(message);
            return false;
        }
        return true;
    }

    public static boolean emailValidator(EditText editText)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(editText.getText());
        if(!matcher.matches()){
            editText.setError("Email Id not valid");
            return false;
        }
        return true;
    }
}
```
##Note - 
This validation class can be reused for other activity.
#Step 4
Use the validation class on button click.
```java
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
```
