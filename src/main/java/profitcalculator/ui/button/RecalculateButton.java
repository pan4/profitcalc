package profitcalculator.ui.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JButton;

@Component
public class RecalculateButton extends JButton {

    @Autowired
    RecalculateButtonActionListener recalculateButtonActionListener;

    @PostConstruct
    public void init(){
        addActionListener(recalculateButtonActionListener);
        setText("Recalculate");
    }
}
