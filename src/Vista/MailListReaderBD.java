package Vista;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    private final File file;
    private final Connection connection;

    public MailListReaderBD(File file) throws SQLException {
        this.file = file;
        this.connection = connect();
    }

    public List<String> read() {
        List<String> emails = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT"
                    + " Mail FROM EMAIL");
            while (rs.next()) {
                emails.add(rs.getString("Mail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emails;
    }
    
    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" +
                    file.getAbsolutePath());
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
