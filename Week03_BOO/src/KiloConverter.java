import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiloConverter extends JFrame {
    private JTextField mileField;
    private JLabel resultLabel;

    public KiloConverter() {
        setTitle("마일을 킬로미터로 변환");
        setSize(500, 100);

        JPanel panel = new JPanel();

        JLabel promptLabel = new JLabel("마일을 입력하시오");
        mileField = new JTextField(10);
        JButton convertButton = new JButton("변환");
        resultLabel = new JLabel("");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double miles = Double.parseDouble(mileField.getText());
                double kilometers = miles * 1.60934;
                resultLabel.setText(kilometers + " km");
            }
        });

        panel.add(promptLabel);
        panel.add(mileField);
        panel.add(convertButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(resultLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                KiloConverter converter = new KiloConverter();
                converter.setVisible(true);
            }
        });
    }
}

