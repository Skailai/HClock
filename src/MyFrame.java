import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyFrame extends JFrame{
    String time;
    JLabel timeLabel;
    DateTimeFormatter dtf;
    MyFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300,150);
        this.setTitle("HClock");
        this.setResizable(false);
        this.setLayout(new FlowLayout());


        dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        time = getTime();
        timeLabel = new JLabel(time);
        timeLabel.setForeground(Color.green);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 65));

        this.add(timeLabel);
        this.setVisible(true);

        this.setTime();
    }
    private String getTime(){
        return dtf.format(LocalDateTime.now());
    }
    public void setTime ()  {
        while (true){
            LocalDateTime now = LocalDateTime.now();
            time = getTime();
            timeLabel.setText(getTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
