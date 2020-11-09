package bsu.rfe.java.group10.lab2.Osoprilko.varB2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainFrame extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    // Текстовые поля для считывания значений переменных X и Y,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    private JTextField textFieldMem1;
    private JTextField textFieldMem2;
    private JTextField textFieldMem3;
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioMemButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    // Идентификатор выбранной формулы
    private int formulaId = 1;
    private Box hboxMemType = Box.createHorizontalBox();
    private int MemId = 1;

    // Формула №1
    public Double calculate1(Double x, Double y, Double z) {
        return Math.pow((Math.log(z) + Math.sin(Math.PI * z * z)), 0.25) / Math.pow((y * y + Math.pow(Math.E, Math.cos(x)) + Math.sin(y)), Math.sin(x));
    }

    // Формула №2
    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(y, 0.5) * 3 * Math.pow(z, x) / Math.pow((1 + y * y * y), 0.5);
    }

    //--------------------------------------------------------------------------------------------------------

    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    //--------------------------------------------------------------------------------------------------------
    private void addRadioButtonMem(String buttonName, final int MemId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.MemId = MemId;
            }
        });
        radioMemButtons.add(button);
        hboxMemType.add(button);
    }

    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        // Задать рамку для коробки с помощью класса BorderFactory
        hboxFormulaType.setBorder( BorderFactory.createLineBorder(Color.YELLOW));
        // Создать область с полями ввода для X и Y, Z
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder( BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue()); //7
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());
        // Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0", 15);
        textFieldResult.setMaximumSize( textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));



        // Область для ячеек памяти
        JLabel labelForMem1 = new JLabel("Mem1:");
        textFieldMem1 = new JTextField("0", 15);
        textFieldMem1.setMaximumSize(textFieldMem1.getPreferredSize());
        JLabel labelForMem2 = new JLabel("Mem2:");
        textFieldMem2 = new JTextField("0", 15);
        textFieldMem2.setMaximumSize(textFieldMem2.getPreferredSize());
        JLabel labelForMem3 = new JLabel("Mem3:");
        textFieldMem3 = new JTextField("0", 15);
        textFieldMem3.setMaximumSize(textFieldMem3.getPreferredSize());
        Box hboxMemory = Box.createHorizontalBox();
        hboxMemory.setBorder(BorderFactory.createLineBorder(Color.PINK));
        hboxMemory.add(Box.createHorizontalGlue());
        hboxMemory.add(labelForMem1);
        hboxMemory.add(Box.createHorizontalStrut(10));
        hboxMemory.add(textFieldMem1);
        hboxMemory.add(Box.createHorizontalStrut(50));
        hboxMemory.add(labelForMem2);
        hboxMemory.add(Box.createHorizontalStrut(10));
        hboxMemory.add(textFieldMem2);
        hboxMemory.add(Box.createHorizontalStrut(50));
        hboxMemory.add(labelForMem3);
        hboxMemory.add(Box.createHorizontalStrut(10));
        hboxMemory.add(textFieldMem3);
        hboxMemory.add(Box.createHorizontalGlue());

        hboxMemType.add(Box.createHorizontalGlue());
        addRadioButtonMem("Mem1", 1);
        addRadioButtonMem("Mem2", 2);
        addRadioButtonMem("Mem3", 3);
        radioMemButtons.setSelected(radioMemButtons.getElements().nextElement().getModel(), true);
        hboxMemType.add(Box.createHorizontalGlue());
        hboxMemType.setBorder( BorderFactory.createLineBorder(Color.BLACK));

        //--------------------------------------------------------------------
        // Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                try
                {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldX.getText());
                    Double result;
                    if (formulaId == 1) result = calculate1(x, y, z);
                    else result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                textFieldX.setText("0"); textFieldY.setText("0"); textFieldZ.setText("0"); textFieldResult.setText("0");
            }
        });

        //-------------------------------------------------

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}