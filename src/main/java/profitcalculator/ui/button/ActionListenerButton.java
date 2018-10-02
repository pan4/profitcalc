package profitcalculator.ui.button;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class ActionListenerButton extends JButton {
    private ActionListener actionListener;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @PostConstruct
    public void init() {
        this.addActionListener(actionListener);
    }
}