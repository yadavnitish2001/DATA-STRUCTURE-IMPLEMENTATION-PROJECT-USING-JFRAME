import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel displaybox;
	private JTextField length;
	private JTextField element;
	private JTextField textField;
	private int s[];
	private int size;
	private int top=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 392);
		displaybox = new JPanel();
		displaybox.setBackground(new Color(255, 218, 185));
		displaybox.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(displaybox);
		displaybox.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STACK DATA STRUCTURE");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(199, 10, 225, 24);
		displaybox.add(lblNewLabel);
		
		JLabel lblEnterStackSize = new JLabel("ENTER THE STACK SIZE :");
		lblEnterStackSize.setForeground(new Color(255, 0, 255));
		lblEnterStackSize.setFont(new Font("Constantia", Font.BOLD, 14));
		lblEnterStackSize.setBounds(56, 66, 172, 18);
		displaybox.add(lblEnterStackSize);
		
		length = new JTextField();
		length.setBounds(224, 64, 96, 19);
		displaybox.add(length);
		length.setColumns(10);
		
		JButton create = new JButton("CREATE STACK");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//STACK CREATION CODE
//				size=Integer.valueOf(length.getText());
//				s=new int[size];
//				String message="SIZE OF STACK "+size+" CREATED";
//      			JOptionPane.showMessageDialog(getContentPane(), message);
//				
				try {
				    size = Integer.parseInt(length.getText());
				    if (size <= 0) {
				        JOptionPane.showMessageDialog(Stack.this.getContentPane(), "Please enter a positive integer for the stack size.");
				    } else {
				        s = new int[size];
				        String message = "Size of stack " + size + " created.";
				        JOptionPane.showMessageDialog(Stack.this.getContentPane(), message);
				        length.setText("");
				        top = -1; // Reset top when creating a new stack
				    }
				} catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(Stack.this.getContentPane(), "Please enter a valid integer for the stack size.");
				}
				
			}
		});
		create.setForeground(new Color(255, 0, 255));
		create.setFont(new Font("Constantia", Font.BOLD, 14));
		create.setBounds(224, 110, 157, 27);
		displaybox.add(create);
		
		JLabel lblelement = new JLabel("ENTER AN ELEMENT :");
		lblelement.setForeground(new Color(255, 0, 255));
		lblelement.setFont(new Font("Constantia", Font.BOLD, 14));
		lblelement.setBounds(56, 161, 150, 18);
		displaybox.add(lblelement);
		
		element = new JTextField();
		element.setBounds(224, 159, 96, 19);
		displaybox.add(element);
		element.setColumns(10);
		
		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PUSH THE ELEMENTS
//				int elem;
//				if(top==size-1) {
//					JOptionPane.showMessageDialog(getContentPane(), "PUSH NOT POSSIBLE");	                        
//				}
//				else {
//					elem=Integer.valueOf(element.getText());
//					++top;
//					s[top]=elem;
//					JOptionPane.showMessageDialog(getContentPane(), "PUSH SUCCESSFULL");
//					element.setText("");
//				}
				
				int elem;
				try {
				    if (top == size - 1) {
				        JOptionPane.showMessageDialog(Stack.this.getContentPane(), "PUSH NOT POSSIBLE. Stack is full.");
				    } else {
				        elem = Integer.parseInt(element.getText());
				        ++top;
				        s[top] = elem;
				        JOptionPane.showMessageDialog(Stack.this.getContentPane(), "PUSH SUCCESSFUL");
				        element.setText("");
				    }
				} catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(Stack.this.getContentPane(), "Please enter a valid integer for the element.");
				}
			}
		});
		push.setForeground(new Color(255, 0, 255));
		push.setFont(new Font("Constantia", Font.BOLD, 14));
		push.setBounds(352, 160, 85, 21);
		displaybox.add(push);
		
		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DELETE THE ELEMENTS
				if(top==-1) {
					JOptionPane.showMessageDialog(getContentPane(), "POP NOT POSSIBLE");
				}
				else {
					String message="ELEMENT DELETED IS "+s[top];
					JOptionPane.showMessageDialog(getContentPane(), "message");
					--top;
				}
			}
		});
		pop.setForeground(new Color(255, 0, 255));
		pop.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 14));
		pop.setBounds(235, 205, 85, 21);
		displaybox.add(pop);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Display the elements
				String msg="";
				if(top==-1) {
					JOptionPane.showMessageDialog(getContentPane(), "DISPLAY NOT POSSIBLE");
				}else {
					for(int i=top;i>=0;i--) {
						msg=msg+" "+s[i];
					}
					textField.setText(msg);
				}
			}
		});
		display.setForeground(new Color(255, 0, 255));
		display.setFont(new Font("Constantia", Font.BOLD, 14));
		display.setBounds(227, 250, 107, 27);
		displaybox.add(display);
		
		textField = new JTextField();
		textField.setBounds(170, 291, 211, 19);
		displaybox.add(textField);
		textField.setColumns(10);
	}

}
