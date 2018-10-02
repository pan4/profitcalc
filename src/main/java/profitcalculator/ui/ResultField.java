package profitcalculator.ui;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JTextField;

@Component
public class ResultField extends JTextField {

    @PostConstruct
    public void init(){
        setEditable(false);
    }
}
