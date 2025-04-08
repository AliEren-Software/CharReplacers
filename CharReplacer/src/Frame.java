import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    JButton button = new JButton();
    JTextField text = new JTextField();
    JTextField text2 = new JTextField();
    Frame(){
        this.setTitle("CharReplacer");

        this.setLayout(new FlowLayout());

        JLabel label = new JLabel();
        label.setText("Enter a restricted word: ");
        this.add(label);

        text.setPreferredSize(new Dimension(100,50));
        this.add(text);

        JLabel label2 = new JLabel();
        label2.setText("Enter a text: ");
        this.add(label2);


        text2.setPreferredSize(new Dimension(100,50));
        this.add(text2);


        button.setText("Send");
        button.setPreferredSize(new Dimension(70,50));
        button.addActionListener(this);
        this.add(button);


        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            replacerv2 replace = new replacerv2(text.getText());
            String newText = replace.replacer(text2.getText());
            JOptionPane.showMessageDialog(null,newText);
        }
    }
}
