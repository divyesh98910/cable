package com.example.cable.Model;

public class Common {
    public static final String BASE_URL = "http://cableapp.xtechsoftsolution.com/admin/api/";
    /**
        [It will display details of recipient]
    **/
    public static final String RECIPIENT = BASE_URL + "recipient.php";

    /**
    [It will display name of area]
    **/
    public static final String AREA = BASE_URL + "area.php";

    /**[It will display details of subscriber]**/
//    public static final String SUBSCRIBERS = BASE_URL + "subscriber.php";

    /**[It will display details of money which will collected by recipient]**/
    public static final String RECIPIENT_COLLECTED_MONEY = BASE_URL + "recipient_details1.php";

    /**[It will display all details of subscriber and amount which is remaining to pay]**/
    public static final String SUBSCRIBERS = BASE_URL + "subscriber_details.php";
    public static final String LOGIN = "http://cableapp.xtechsoftsolution.com/admin/api/login.php";
    public static final String IS_LOGIN = "isLogged";
    public static final String EXTRA_SUBSCRIBER = "subscriber";
}
