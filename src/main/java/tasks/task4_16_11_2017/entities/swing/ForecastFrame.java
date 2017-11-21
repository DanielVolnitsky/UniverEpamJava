package tasks.task4_16_11_2017.entities.swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Графический интерфейс пользователя для отображения прогноза погоды
 */
public class ForecastFrame extends JFrame {

    public JTextArea currWeatherArea;
    public JTextArea prevWeatherArea;
    private JLabel topLabel;

    public ForecastFrame(String topLabelText) {
        super("Forecast conditions demonstrating");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outerPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel currWeatherPanel = new JPanel(new BorderLayout());
        JPanel prevWeatherPanel = new JPanel(new BorderLayout());

        Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border currTitledBorder = BorderFactory.createTitledBorder("Current weather state:");
        Border yestTitledBorder = BorderFactory.createTitledBorder("Previous day weather state at this hour:");

        Border currWeatherBorder = BorderFactory.createCompoundBorder(outsideBorder, currTitledBorder);
        Border yestWeatherBorder = BorderFactory.createCompoundBorder(outsideBorder, yestTitledBorder);

        currWeatherPanel.setBorder(currWeatherBorder);
        prevWeatherPanel.setBorder(yestWeatherBorder);

        outerPanel.add(topPanel, BorderLayout.NORTH);
        outerPanel.add(prevWeatherPanel, BorderLayout.SOUTH);
        outerPanel.add(currWeatherPanel, BorderLayout.CENTER);

        topLabel = new JLabel(topLabelText, JLabel.CENTER);
        currWeatherArea = new JTextArea(3, 10);
        prevWeatherArea = new JTextArea(3, 10);

        topPanel.add(topLabel, BorderLayout.NORTH);
        currWeatherPanel.add(currWeatherArea);
        prevWeatherPanel.add(prevWeatherArea);

        this.setContentPane(outerPanel);
        this.pack();
        this.setSize(500, 230);
    }
}
