package profitcalculator.ui.button;

import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import profitcalculator.domain.Exchange;
import profitcalculator.domain.Rates;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecalculateButtonActionListener implements ActionListener {

    @Qualifier("dateChooser")
    @Autowired
    JDateChooser dateChooser;

    @Qualifier("amountField")
    @Autowired
    JFormattedTextField amountField;

    @Qualifier("resultField")
    @Autowired
    JTextField resultField;

    @Autowired
    RestTemplate restTemplate;

    @Value("${fixer.url}")
    private String url;

    public void actionPerformed(ActionEvent e) {
        Date date = dateChooser.getDate();
        BigDecimal amount = new BigDecimal((Integer) amountField.getValue());

        Exchange latest = restTemplate.getForObject(url, Exchange.class, "latest");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Exchange past = restTemplate.getForObject(url, Exchange.class, df.format(date));

        Rates latestRates = latest.getRates();
        BigDecimal latestRUB = new BigDecimal(latestRates.getRub());
        BigDecimal latestUSD = new BigDecimal(latestRates.getUsd());
        BigDecimal val1 = latestRUB.divide(latestUSD,6, RoundingMode.HALF_UP).multiply(amount);

        Rates pastRates = past.getRates();
        BigDecimal pastRUB = new BigDecimal(pastRates.getRub());
        BigDecimal pastUSD = new BigDecimal(pastRates.getUsd());
        BigDecimal val2 = pastRUB.divide(pastUSD, 6, RoundingMode.HALF_UP).multiply(amount);

        resultField.setText(val1.subtract(val2).toString());

        System.out.println(df.format(date));
        System.out.println(amount);
        System.out.println(val1);
        System.out.println(val2);
    }

}