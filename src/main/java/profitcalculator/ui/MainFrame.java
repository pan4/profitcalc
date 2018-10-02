package profitcalculator.ui;

import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

/**
 * Created by Александр on 01.10.2018.
 */
@Component
public class MainFrame extends JFrame {

    @Value("${app.title}")
    private String title;

    @Value("${app.width}")
    private int width;

    @Value("${app.height}")
    private int height;

    @Qualifier("dateChooser")
    @Autowired
    JDateChooser dateChooser;

    @Qualifier("amountField")
    @Autowired
    JFormattedTextField amountField;

    @Qualifier("recalculateButton")
    @Autowired
    JButton recalculateButton;

    @Qualifier("resultField")
    @Autowired
    JTextField resultField;


    @PostConstruct
    public void init() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(width, height);
        setTitle(title);

        JPanel mainGrid = new JPanel();
        mainGrid.setLayout(new GridLayout(3, 2, 5, 5));
        mainGrid.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel dateLable = new JLabel("Date:");
        JLabel amountLable = new JLabel("Amount:");

        mainGrid.add(dateLable);
        mainGrid.add(amountLable);
        mainGrid.add(dateChooser);
        mainGrid.add(amountField);
        mainGrid.add(recalculateButton);
        mainGrid.add(resultField);

        add(mainGrid);

        setVisible(true);
    }

}
