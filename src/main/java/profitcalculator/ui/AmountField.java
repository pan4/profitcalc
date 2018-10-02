package profitcalculator.ui;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

@Component
public class AmountField extends JFormattedTextField {

    @PostConstruct
    public void init(){
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        setFormatter(formatter);
        setValue(0);
    }
}
