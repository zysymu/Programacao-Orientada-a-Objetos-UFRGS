import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class GUI extends JFrame implements ActionListener {
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

            Image resultingImage = image.getScaledInstance(320, 128, Image.SCALE_DEFAULT);
            BufferedImage resizedImage = new BufferedImage(320, 128, BufferedImage.TYPE_INT_ARGB);
            resizedImage.getGraphics().drawImage(resultingImage, 0, 0, null);

            labelImg = new JLabel(new ImageIcon(resizedImage));
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

        buttonConvert.setActionCommand("convert");
        buttonReset.setActionCommand("reset");

        buttonConvert.addActionListener(this);
        buttonReset.addActionListener(this);

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

    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand().equals("convert")) {
            trataConversao();
        }

        else {
            fieldInput.setText("");
            fieldOutput.setText("");
        }
    }

    private void trataConversao () {
        try {
            double input = Double.parseDouble(fieldInput.getText());
            String output = "";

            if (rButtonFromCelsius.isSelected()) {
                if (rButtonToCelsius.isSelected())
                    output = String.format("%.2f", input);
                    fieldOutput.setText(output);

                if (rButtonToFahrenheit.isSelected())
                    output = String.format("%.2f", (1.8*input) + 32);
                    fieldOutput.setText(output);

                if (rButtonToKelvin.isSelected())
                    output = String.format("%.2f", input + 273.15);
                    fieldOutput.setText(output);
            }

            if (rButtonFromFahrenheit.isSelected()) {
                if (rButtonToCelsius.isSelected())
                    output = String.format("%.2f", (input - 32) * 1.8);
                    fieldOutput.setText(output);

                if (rButtonToFahrenheit.isSelected())
                    output = String.format("%.2f", input);
                    fieldOutput.setText(output);

                if (rButtonToKelvin.isSelected())
                    output = String.format("%.2f", input + 457.87);
                    fieldOutput.setText(output);
            }

            if (rButtonFromKelvin.isSelected()) {
                if (rButtonToCelsius.isSelected())
                    output = String.format("%.2f", input - 273.15);
                    fieldOutput.setText(output);

                if (rButtonToFahrenheit.isSelected())
                    output = String.format("%.2f", input - 457.87);
                    fieldOutput.setText(output);

                if (rButtonToKelvin.isSelected())
                    output = String.format("%.2f", input);
                    fieldOutput.setText(output);
            }
    
            fieldOutput.setForeground(Color.black);

        } catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(null, "Por favor digite um número");
            fieldOutput.setText("Valor invalido");
            fieldOutput.setForeground(Color.red);
        }
    }
}
