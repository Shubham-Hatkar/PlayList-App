import javax.swing.*;

public class GUI
{
    GUI()
    {
        JFrame frame = new JFrame();


        JTextArea txtarea = new JTextArea("");
        txtarea.setBounds(20, 50, 100, 100);
        frame.add(txtarea);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 570);
    }

}
