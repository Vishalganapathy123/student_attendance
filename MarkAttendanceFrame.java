import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkAttendanceFrame extends JFrame {
    private JTable attendanceTable;
    private JButton saveButton;

    public MarkAttendanceFrame() {
        setTitle("Mark Attendance");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Dummy data for the table
        String[] columnNames = {"Student ID", "Name", "Present"};
        Object[][] data = {
            {"1", "John Doe", Boolean.FALSE},
            {"2", "Jane Smith", Boolean.FALSE},
            {"3", "Michael Johnson", Boolean.FALSE}
        };

        attendanceTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(attendanceTable);

        saveButton = new JButton("Save Attendance");

        add(scrollPane, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save the attendance to the database
                for (int i = 0; i < attendanceTable.getRowCount(); i++) {
                    Boolean isPresent = (Boolean) attendanceTable.getValueAt(i, 2);
                    String studentId = (String) attendanceTable.getValueAt(i, 0);
                    // Store the data in the database (JDBC code can go here)
                }
                JOptionPane.showMessageDialog(null, "Attendance marked successfully!");
                dispose();
            }
        });
    }
}
