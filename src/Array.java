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

public class Array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField insertposition;
	private JTextField deleteposition;
	private JTextField displaybox;
	private int arr[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ARRAY DATA STRUCTURE\r\n");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 18));
		lblNewLabel.setBounds(211, 20, 280, 20);
		contentPane.add(lblNewLabel);

		JLabel lblEnterArrayLength = new JLabel("ENTER ARRAY LENGTH:");
		lblEnterArrayLength.setFont(new Font("Constantia", Font.BOLD, 12));
		lblEnterArrayLength.setBounds(60, 64, 169, 36);
		contentPane.add(lblEnterArrayLength);

		length = new JTextField();
		length.setBounds(203, 71, 96, 19);
		contentPane.add(length);
		length.setColumns(10);

		JButton create = new JButton("CREATE ARRAY");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CREATE AN ARRAY
				//String len=length.getText();
				int len=Integer.valueOf(length.getText());
				arr=new int[len];
				String message="ARRAY OF LENGTH "+len+" CREATED";
				JOptionPane.showMessageDialog(contentPane, message);

			}
		});
		create.setFont(new Font("Constantia", Font.BOLD, 12));
		create.setBounds(261, 111, 123, 23);
		contentPane.add(create);

		JLabel lblinsertAnInteger = new JLabel("INSERT AN INTEGER:\r\n");
		lblinsertAnInteger.setFont(new Font("Constantia", Font.BOLD, 11));
		lblinsertAnInteger.setBounds(60, 158, 113, 15);
		contentPane.add(lblinsertAnInteger);

		element = new JTextField();
		element.setBounds(183, 154, 96, 19);
		contentPane.add(element);
		element.setColumns(10);

		JLabel lblposition = new JLabel("POSITION");
		lblposition.setFont(new Font("Constantia", Font.BOLD, 12));
		lblposition.setBounds(304, 158, 59, 15);
		contentPane.add(lblposition);

		insertposition = new JTextField();
		insertposition.setBounds(384, 154, 96, 19);
		contentPane.add(insertposition);
		insertposition.setColumns(10);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//INSERT AN INTEGER
//				int elem=Integer.valueOf(element.getText());
//				int pos=Integer.valueOf(insertposition.getText());
//				arr[pos]=elem;
//				String message="Element "+elem+" Inserted @ position "+pos;
//				JOptionPane.showMessageDialog(contentPane, message);
//				element.setText("");
//				insertposition.setText("");
				// INSERT AN INTEGER
				try {
				    int elem = Integer.valueOf(element.getText()); 
				    int pos = Integer.valueOf(insertposition.getText()); 
				    if (pos < 0 || pos >= arr.length) {
				        JOptionPane.showMessageDialog(contentPane, "Invalid position. Please enter a position within the array bounds.");
				    } else {
				        arr[pos] = elem;
				        String message = "Element " + elem + " Inserted @ position " + pos;
				        JOptionPane.showMessageDialog(contentPane, message);
				        element.setText(""); 
				        insertposition.setText(""); 				    }
				} catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(contentPane, "Please enter valid integer values for element and position.");
				}

			}
		});
		insert.setFont(new Font("Constantia", Font.BOLD, 12));
		insert.setBounds(542, 153, 85, 21);
		contentPane.add(insert);

		JLabel lblDeletePosition = new JLabel("DELETE POSITION :");
		lblDeletePosition.setFont(new Font("Constantia", Font.BOLD, 12));
		lblDeletePosition.setBounds(60, 215, 114, 15);
		contentPane.add(lblDeletePosition);

		deleteposition = new JTextField();
		deleteposition.setBounds(183, 211, 96, 19);
		contentPane.add(deleteposition);
		deleteposition.setColumns(10);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DELETE THE POSITION
				int pos=Integer.valueOf(deleteposition.getText());
				arr[pos]=0;
				String message="Element Deleted @ position "+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				deleteposition.setText("");

			}
		});
		delete.setFont(new Font("Constantia", Font.BOLD, 12));
		delete.setBounds(334, 210, 85, 21);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPLAY ELEMENTS
				String msg="";
				for(int i=0;i<=arr.length-1;i++) {
					msg=msg+" "+arr[i];
				}
				displaybox.setText(msg);
			}
		});
		display.setFont(new Font("Constantia", Font.BOLD, 12));
		display.setBounds(261, 270, 85, 21);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBounds(147, 323, 357, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}
}
