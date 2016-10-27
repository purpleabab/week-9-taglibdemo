package rahmeier.karen.taglibdemo;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by karen.rahmeier on 10/27/2016.
 */
public class TimeOfDayTag extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();
        out.println("Welcome, loyal fan!  Today's date and time: " + getCurrentDateAndTime());
        out.println();
        out.println("The time is: " + getCurrentTime());
        out.println();
        out.println("The time-based welcome message is: " + getTimeBasedMessage());
        out.println();
        if (isHalloween()) {
            out.println("HAPPY HALLOWEEN !!!");
        }
        out.println();
        if (is1027()) {
            out.println("HAPPY 1027 !!!");
        }
    }

    private String getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today = new Date();
        return dateFormat.format(today);
    }

    public String getCurrentDate() {
        DateFormat timeFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        String formattedDate = timeFormat.format(today);
        return formattedDate;
    }

    public String getCurrentTime() {
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date today = new Date();
        String formattedTime = timeFormat.format(today);
        return formattedTime;
    }

    public String getTimeBasedMessage() {
        String message = "something here";
        String currentTime = getCurrentTime();
        String currentHour = currentTime.substring(0, 1);
        if (currentHour.equalsIgnoreCase("0")) {
            message = "Good morning!  The time is something before 10am ";
        } else if ((currentHour.equalsIgnoreCase("1"))) {
            message = "Good day!  The time is something between 10 am and 19:59:00";
        } else if ((currentHour.equalsIgnoreCase("2"))) {
            message = "Good night!  The time is some time between 8 pm and midnight.";
        } else {
            message = "Hello.  I didn't expect to reach this time, but anyway, it is currently: " + currentHour;
        }
        return message;
    }

    public boolean isHalloween() {
        boolean isHalloween = false;
        if (getCurrentDate().substring(0, 5).equalsIgnoreCase("10/31")) {
            isHalloween = true;
        }
        return isHalloween;
    }

    /**
     *  Sample method, used for testing that the correct message prints on the date 10/27.
     */
    public boolean is1027() {
        boolean is1027 = false;
        if (getCurrentDate().substring(0, 5).equalsIgnoreCase("10/27")) {
            is1027 = true;
        }
        return is1027;
    }


}
