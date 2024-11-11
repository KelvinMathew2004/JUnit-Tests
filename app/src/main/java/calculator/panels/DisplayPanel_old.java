// package calculator.panels;

// import java.awt.*;
// import javax.swing.*;

// import calculator.Calculator;
// import calculator.utilities.UIColors;
// TODO : deprecated panel delete
// public class DisplayPanel extends JPanel {
//     private JTextField displayField;

//     // display panel layout
//     public DisplayPanel() {
//         setLayout(new BorderLayout(10, 10));
//         JPanel dpScreenPanel = new JPanel(new GridLayout(1, 1, 10, 10));// holds the screen

//         // call createDisplayField to build screen and add to panel on the west
//         displayField = createDisplayField();
//         // JTextField miniDisplayField = createMiniDisplayfield();

//         // dpScreenPanel.add(miniDisplayField, BorderLayout.CENTER);
//         dpScreenPanel.add(displayField, BorderLayout.CENTER);
//         add(dpScreenPanel);
        
//     }

//     // update what on the display
//     public void updateDisplay(String value) {
//         displayField.setText(value);

//     }

//     // code to create they look of the screen
//     private JTextField createDisplayField() {
//         JTextField display = new JTextField("0") { // adds an initial display value
//             @Override
//             protected void paintComponent(Graphics g) {
//                 Graphics2D g2 = (Graphics2D) g.create();
//                 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//                 g2.setColor(UIColors.displayColor);//fixed
//                 g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);// arc should be a cosntant
//                 g2.dispose();
//                 super.paintComponent(g);
//             }
//         };
//         display.setPreferredSize(new Dimension(500, 80));
//         display.setHorizontalAlignment(JTextField.RIGHT);// display text to the right of the display
//         display.setFont(new Font("Monospaced", Font.BOLD, 30));
//         display.setEditable(true);// true for debug
//         display.setOpaque(false);
//         display.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // adds padding to the inside of the field
//         return display;

//     }

//     // private JTextField createMiniDisplayfield(){
//     //     JTextField miniDisplay = new JTextField("0000");
//     //     miniDisplay.setPreferredSize(new Dimension(20,20));
//     //     miniDisplay.setHorizontalAlignment(JTextField.RIGHT);// display text to the right of the display
//     //     miniDisplay.setFont(new Font("Monospaced", Font.BOLD, 15));
//     //     miniDisplay.setEditable(false);// true for debug
//     //     miniDisplay.setOpaque(false);
//     //     return miniDisplay;
//     // }


// }


