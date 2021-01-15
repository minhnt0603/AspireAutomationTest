package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonFunctions {

    public String generateRandomEmail() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = new Date();
        String random_value = sdf.format(date);
        String email = "aspire_test_" + random_value + "@gmail.com";
        return email;
    }

    public String generateRandomPhoneNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMHHmmss");
        Date date = new Date();
        String phone_no = sdf.format(date);
        return phone_no;
    }
}
