package profitcalculator.configuration;

import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Date;

/**
 * Created by Александр on 01.10.2018.
 */
@Configuration
public class ProfitCalculatorConfiguration {

//    @Bean
//    public MainFrame mainFrame(){
//        return new MainFrame("ProfitCalculator");
//    }

    @Value("${app.width:}")
    private int width;

    @Bean
    public JDateChooser dateChooser(){
        JDateChooser chooser = new JDateChooser();
        chooser.setMaxSelectableDate(new Date());
        chooser.setDateFormatString("dd-MM-yyyy");
        chooser.setDate(new Date());
        return chooser;
    }

    @Bean JFormattedTextField amountField(){
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField field = new JFormattedTextField(formatter);
        return field;
    }

//    @Bean
//    public BoxLayoutPanel dateAndAmountBox(){
//        BoxLayoutPanel panel = new BoxLayoutPanel();
//        List<JComponent> list = new ArrayList<JComponent>();
//        list.add(dateChooser());
//        list.add(amountField());
//        panel.setPanelComponents(list);
//        panel.setAxis(0);
//        panel.setMinimumSize(new Dimension(width,40));
//        return panel;
//    }

    @Bean
    public JButton recalculateButton(){
        JButton button = new JButton();
        button.setText("Recalculate");
        return button;
    }

    @Bean
    public JTextField resultField(){
        JTextField field = new JTextField();
        field.setEditable(false);
        field.setMinimumSize(new Dimension(width/2,40));
        return field;
    }

//    @Bean
//    public BoxLayoutPanel reculcAndResultBox(){
//        BoxLayoutPanel panel = new BoxLayoutPanel();
//        List<JComponent> list = new ArrayList<JComponent>();
//        list.add(recalculateButton());
//        list.add(resultLable());
//        panel.setPanelComponents(list);
//        panel.setAxis(0);
//        panel.setMinimumSize(new Dimension(width,40));
//        return panel;
//    }

//    @Bean
//    public BoxLayoutPanel rootBox(){
//        BoxLayoutPanel panel = new BoxLayoutPanel();
//        List<JComponent> list = new ArrayList<JComponent>();
//        list.add(dateAndAmountBox());
//        list.add(reculcAndResultBox());
//        panel.setPanelComponents(list);
//        panel.setAxis(1);
//        return panel;
//    }

}
