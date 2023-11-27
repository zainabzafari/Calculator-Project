package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField txtfield;
	JButton[] numberbuttons = new JButton[10];
	JButton[] functionbuttons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, clrButton, equButton, delButton, negButton;
	JPanel panel;
	
	Font font = new Font("Ink Free", Font.BOLD, 30);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		txtfield = new JTextField();
		txtfield.setBounds(50, 25, 300, 50);
		txtfield.setFont(font);
		txtfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		clrButton = new JButton("Clear");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		negButton = new JButton("(-)");
		
		functionbuttons[0] = addButton;
		functionbuttons[1] = subButton;
		functionbuttons[2] = mulButton;
		functionbuttons[3] = divButton;
		functionbuttons[4] = decButton;
		functionbuttons[5] = clrButton;
		functionbuttons[6] = equButton;
		functionbuttons[7] = delButton;
		functionbuttons[8] = negButton;
		
		for(int i=0; i<9; i++) {
			functionbuttons[i].addActionListener(this);
			functionbuttons[i].setFont(font);
			functionbuttons[i].setFocusable(false);
			
		}
		
		for(int i=0; i<10; i++) {
			numberbuttons[i] = new JButton(String.valueOf(i));
			numberbuttons[i].addActionListener(this);
			numberbuttons[i].setFont(font);
			numberbuttons[i].setFocusable(false);
			
		}
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberbuttons[1]);
		panel.add(numberbuttons[2]);
		panel.add(numberbuttons[3]);
		panel.add(addButton);
		
		panel.add(numberbuttons[4]);
		panel.add(numberbuttons[5]);
		panel.add(numberbuttons[6]);
		panel.add(subButton);
		panel.add(numberbuttons[7]);
		panel.add(numberbuttons[8]);
		panel.add(numberbuttons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberbuttons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(negButton);
		frame.add(txtfield);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i =0; i<10; i++) {
			if(e.getSource()==numberbuttons[i]) {
				txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decButton) {
			txtfield.setText(txtfield.getText().concat("."));
		}
		
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(txtfield.getText());

			operator = '+';
			txtfield.setText("");
		}
		
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(txtfield.getText());

			operator = '-';
			txtfield.setText("");
		
	}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(txtfield.getText());

			operator = '÷';
			txtfield.setText("");
		
	}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(txtfield.getText());
			operator = '*';
			txtfield.setText("");
		
	}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(txtfield.getText());
			temp*=-1;
			txtfield.setText(String.valueOf(temp));
		
	}
		
		if(e.getSource()==equButton) {


			num2 = Double.parseDouble(txtfield.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
				
			case '-':
				result = num1-num2;
				break;
				
			case '*':
				result = num1*num2;
				break;
				
			case '÷':
				result = num1/num2;
				break;
				
				
			}
			
			txtfield.setText(String.valueOf(result));
			num1=result;
			
		}
		
		if(e.getSource()==clrButton) {
			txtfield.setText("");
		}

		if(e.getSource()==delButton) {
			String string = txtfield.getText();
			txtfield.setText("");
			for(int i=0; i<string.length()-1; i++) {
				txtfield.setText(txtfield.getText()+string.charAt(i));
			}
		}
}
}
