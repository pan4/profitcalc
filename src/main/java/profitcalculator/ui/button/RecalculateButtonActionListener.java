package profitcalculator.ui.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import profitcalculator.service.RecalculationService;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class RecalculateButtonActionListener implements ActionListener {

    @Autowired
    RecalculationService recalculationService;

    @Autowired
    JTextField resultField;

    public void actionPerformed(ActionEvent e) {
        resultField.setText(new Double(recalculationService.recalculate()).toString());
    }

}