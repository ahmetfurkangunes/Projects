import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMarks {
    private JTextField txtName;
    private JTextField txtTotal;
    private JTextField txtAvg;
    private JTextField txtGrade;
    private JButton calcButton;

    private JPanel Main;
    private JTextField txtMid;
    private JTextField txtFinal;

    public static void main(String[] args) {
        JFrame frame = new JFrame("StudentMarks");
        frame.setContentPane(new StudentMarks().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public StudentMarks() {
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int midterm,fin,total;
                double avg;

                midterm = Integer.parseInt(txtMid.getText());
                fin = Integer.parseInt(txtFinal.getText());

                total = midterm + fin;

                txtTotal.setText(String.valueOf(total));

                avg = total/3;

                txtAvg.setText(String.valueOf(avg));

                if (avg > 50) {
                    txtGrade.setText("Pass");
                }
                else {
                    txtGrade.setText("Fail");
                }

            }
        });
    }
}
