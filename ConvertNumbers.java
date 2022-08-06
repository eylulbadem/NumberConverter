import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * A class that convert binary, hex and decimal numbers to each other with gui
 * @author Eylul Badem
 * @version 1.0, 31.03.2021
*/ 
public class ConvertNumbers extends JFrame implements ActionListener {

private JPanel panel;
private JLabel label1;
private JLabel label2;
private JLabel label3;
private JTextField textField1;
private JTextField textField2;
private JTextField textField3;
private String text;
private int num;
final int ROW = 3;
final int COLUMN = 2;

  //Main method
  public static void main(String[] args) { 
    
    ConvertNumbers frame = new ConvertNumbers();
    frame.setVisible(true);
    
  }
  
  public ConvertNumbers() {
    
    setTitle("Convert Numbers");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 300, 300);

    panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    panel.setBackground(Color.WHITE);
    getContentPane().add(panel);
    
    label1 = new JLabel("    Decimal    ");
    label2 = new JLabel("    Hex    ");
    label3 = new JLabel("    Binary    ");
    textField1 = new JTextField(20);
    textField1.addActionListener(this);
    textField2 = new JTextField(20);
    textField2.addActionListener(this);
    textField3 = new JTextField(20);
    textField3.addActionListener(this);
    
    GridBagConstraints left = new GridBagConstraints();
    left.anchor = GridBagConstraints.WEST;
    GridBagConstraints right = new GridBagConstraints();
    right.weightx = 2.0;
    right.anchor = GridBagConstraints.WEST;
    right.fill = GridBagConstraints.VERTICAL;
    right.gridwidth = GridBagConstraints.REMAINDER;
    panel.add(label1, left);
    panel.add(textField1, right);
    panel.add(label2, left);
    panel.add(textField2, right);
    panel.add(label3, left);
    panel.add(textField3, right);
  }
    
    /**
     * This method controls what will happen when an action is perceived
     * @param event any action perceived
     */
    @Override
    public void actionPerformed(ActionEvent event) {
      if ( event.getSource() == textField1 ) {
        text = textField1.getText();
        num = Integer.parseInt(text);
        System.out.println(text);
        textField2.setText( decimalToHex( num ));
        textField3.setText( decimalToBinary( num ));
      }
      else if ( event.getSource() == textField2 ) {
        text = textField2.getText();
        System.out.println(text);
        textField1.setText( hexToDecimal( text ));
        textField3.setText( hexToBinary( text ));
      }
      else if ( event.getSource() == textField3 ) {
        text = textField3.getText();
        num = Integer.parseInt(text);
        System.out.println(text);
        textField1.setText( binaryToDecimal( text ));
        textField2.setText( binaryToHex( num ));
      }
    }

    public String hexToDecimal( String hex ) {
      int decimal = Integer.parseInt(hex, 16);
      return decimal + "";
    }
    
    public String binaryToDecimal( String s ) {
      int temp = Integer.parseInt(s,2);
      return temp + "";
    }
    
    public String decimalToHex( int num ) {
      return Integer.toHexString(num).toUpperCase();
    }
    
    public String binaryToHex( int num ) {
      return Integer.toHexString(num).toUpperCase();
    }
    
    public String decimalToBinary( int num ) {
      return Integer.toBinaryString(num);
    }
    
    public String hexToBinary(String hex)
    {
      int i = Integer.parseInt(hex,16);    
      return (Integer.toBinaryString(i));
    }
  
}