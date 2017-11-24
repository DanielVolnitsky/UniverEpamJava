package tasks.task4_16_11_2017.entities.swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Графический интерфейс пользователя для отображения прогноза погоды
 */
public class DisplayingFrame extends JFrame {

    final private short frameWidth = 220;
    public JTextArea textArea;

    public DisplayingFrame(String topLabelText) {
        super("Wind state demonstrating");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel outerPanel = new JPanel(new BorderLayout());
        JPanel innerPanel = new JPanel(new BorderLayout());

        Border outsideBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border currTitledBorder = BorderFactory.createTitledBorder(topLabelText);

        Border currWeatherBorder = BorderFactory.createCompoundBorder(outsideBorder, currTitledBorder);

        innerPanel.setBorder(currWeatherBorder);

        outerPanel.add(innerPanel, BorderLayout.CENTER);

        textArea = new JTextArea(3, 5);

        innerPanel.add(textArea);

        this.setContentPane(outerPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(frameWidth, 160);
    }

    public void centerFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        this.setLocation(dx, dy);
    }

    public void leftyFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2 - frameWidth;
        int dy = centerPoint.y - windowSize.height / 2;
        this.setLocation(dx, dy);
    }

    public void rightyFrame() {

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2 + frameWidth;
        int dy = centerPoint.y - windowSize.height / 2;
        this.setLocation(dx, dy);
    }
}
