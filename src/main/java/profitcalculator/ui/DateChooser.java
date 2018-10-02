package profitcalculator.ui;

import com.toedter.calendar.JDateChooser;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class DateChooser extends JDateChooser {

    @PostConstruct
    public void init(){
        setMaxSelectableDate(new Date());
        setDateFormatString("dd-MM-yyyy");
        setDate(new Date());
    }
}
