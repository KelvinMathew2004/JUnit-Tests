package calculator.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import calculator.Calculator;
import calculator.utilities.CustomButton;
import calculator.utilities.OperatorHandler;
import calculator.utilities.UIColors;

// this class has the C and f(x) operator Misc. removed from displaypanel
public class MiscOpPanel extends JPanel {
    private Calculator calculator;
    private DisplayPanel displayPanel;
    private OperatorHandler operatorHandler; //my ref to op handler
    
    // private JTextField displayField;
    
    // JPanel dpRightPanel = new JPanel(new GridLayout(1, 1, 10, 10));
    
    public MiscOpPanel(Calculator calculator, DisplayPanel displayPanel,OperatorHandler operatorHandler) {
        this.calculator = calculator;
        this.displayPanel = displayPanel;
        this.operatorHandler = operatorHandler; // Initialize OperatorHandler
        
        setLayout(new GridLayout(1, 1, 10, 10));
        String[] displayOps = {"C"};//"f(x)" to render graph
        
        
        for (String op : displayOps) {
            CustomButton button = new CustomButton(op, UIColors.miscColor, UIColors.displayColor);
            button.setPreferredSize(new Dimension(190, 60));
            /////////////test changes
            button.setActionCommand(op); // Set the action command to the operation name
            button.addActionListener(operatorHandler);// Add the same OperatorHandler to handle all button presses
            this.add(button);
        }
    }
}
