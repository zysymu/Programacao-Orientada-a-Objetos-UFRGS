import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class GUI extends JFrame {
    private JPanel panelNorth, panelWest, panelCenter, panelEast, panelSouth;
    private JButton buttonConvert, buttonReset;
    private JLabel labelInput, labelOutput, labelImg;
    private JTextField fieldInput, fieldOutput;
    private JRadioButton rButtonFromCelsius, rButtonFromFahrenheit, rButtonFromKelvin, rButtonToCelsius, rButtonToFahrenheit, rButtonToKelvin;

    public GUI () {
        super("Conversor de Temperatura");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // north
        panelNorth = new JPanel();

        labelInput = new JLabel("Entrada");
        fieldInput = new JTextField(15);

        panelNorth.add(labelInput);
        panelNorth.add(fieldInput);

        // west
        panelWest = new JPanel();

        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));

        TitledBorder borderWest = BorderFactory.createTitledBorder("Entrada: ");
        panelWest.setBorder(borderWest);

        rButtonFromCelsius = new JRadioButton("Celsius");
        rButtonFromFahrenheit = new JRadioButton("Fahrenheit");
        rButtonFromKelvin = new JRadioButton("Kelvin");

        ButtonGroup groupFrom = new ButtonGroup();

        groupFrom.add(rButtonFromCelsius);
        groupFrom.add(rButtonFromFahrenheit);
        groupFrom.add(rButtonFromKelvin);

        panelWest.add(rButtonFromCelsius);
        panelWest.add(rButtonFromFahrenheit);
        panelWest.add(rButtonFromKelvin);

        // center
        panelCenter = new JPanel();

        try {
            BufferedImage image = ImageIO.read(new File("thermometer-1917500_640.png"));
            labelImg = new JLabel(new ImageIcon(image));
            panelCenter.add(labelImg);
        } catch (IOException e) {
            System.out.println("imagem nao acessivel :(");
        }

        // east
        panelEast = new JPanel();

        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));

        TitledBorder borderEast = BorderFactory.createTitledBorder("Saida");
        panelEast.setBorder(borderEast);

        rButtonToCelsius = new JRadioButton("Celsius");
        rButtonToFahrenheit = new JRadioButton("Fahrenheit");
        rButtonToKelvin = new JRadioButton("Kelvin");

        ButtonGroup groupTo = new ButtonGroup();

        groupTo.add(rButtonToCelsius);
        groupTo.add(rButtonToFahrenheit);
        groupTo.add(rButtonToKelvin);

        panelEast.add(rButtonToCelsius);
        panelEast.add(rButtonToFahrenheit);
        panelEast.add(rButtonToKelvin);

        // south
        panelSouth = new JPanel();

        buttonConvert = new JButton("Converter");
        buttonReset = new JButton("Resetar");

        panelSouth.add(buttonConvert);
        panelSouth.add(buttonReset);

        labelOutput = new JLabel("Saida: ");
        fieldOutput = new JTextField(15);
        fieldOutput.setEditable(false);

        panelSouth.add(labelOutput);
        panelSouth.add(fieldOutput);

        // final touches
        container.add(panelNorth, BorderLayout.NORTH);
        container.add(panelWest, BorderLayout.WEST);
        container.add(panelCenter, BorderLayout.CENTER);
        container.add(panelEast, BorderLayout.EAST);
        container.add(panelSouth, BorderLayout.SOUTH);

        //this.setPreferredSize(new Dimension(400, 200));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
