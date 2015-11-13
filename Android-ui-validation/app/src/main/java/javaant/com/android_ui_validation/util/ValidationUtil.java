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
