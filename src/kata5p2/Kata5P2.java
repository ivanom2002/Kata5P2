package kata5p2;

import Model.Histogram;
import Vista.HistogramDisplay;
import Vista.MailListReaderBD;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Kata5P2 {

    public static void main(String[] args) throws SQLException {
        List<String> emails = new MailListReaderBD(new File("KATA5.db")).read();
        Histogram<String> histogram = new Histogram<>();
        
        for (String email : emails)
            histogram.increment(email);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histogram"
                + " Display", histogram);
        histogramDisplay.execute();
    }
}
