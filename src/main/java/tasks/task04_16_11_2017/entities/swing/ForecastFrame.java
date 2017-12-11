package tasks.task04_16_11_2017.entities.swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Графический интерфейс пользователя для отображения прогноза погоды
 */
public class ForecastFrame extends JFrame {

    final private short frameWidth = 220;
    public JTextArea textHolder;

    public ForecastFrame(String topLabelText, PositionType positionType) {
        super("Forecast");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outerPanel = new JPanel(new BorderLayout());
        JPanel innerPanel = new JPanel(new BorderLayout());

        Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border currTitledBorder = BorderFactory.createTitledBorder(topLabelText);

        Border currWeatherBorder = BorderFactory.createCompoundBorder(outsideBorder, currTitledBorder);

        innerPanel.setBorder(currWeatherBorder);

        outerPanel.add(innerPanel, BorderLayout.CENTER);

        textHolder = new JTextArea(3, 5);

        innerPanel.add(textHolder);

        this.setContentPane(outerPanel);
        this.pack();
        this.setFrameLocation(positionType);
        this.setSize(frameWidth, 160);
        //this.setVisible(true);
    }

    private void setFrameLocation(PositionType positionType){
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;

        switch (positionType){
            case LEFTY:
                dx -= frameWidth;
                break;
            case RIGHTY:
                dx += frameWidth;
                break;
            case CENTER:
            default:
                break;
        }
        this.setLocation(dx, dy);
    }

    public enum PositionType {
        LEFTY, CENTER, RIGHTY
    }
}
