import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel singlylinkedlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		singlylinkedlist = new JPanel();
		singlylinkedlist.setForeground(Color.CYAN);
		singlylinkedlist.setBackground(Color.ORANGE);
		singlylinkedlist.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(singlylinkedlist);
		singlylinkedlist.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE A DATASTRUCTURE\r\n");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 16));
		lblNewLabel.setBounds(99, 10, 218, 22);
		singlylinkedlist.add(lblNewLabel);
		
		JButton array = new JButton("ARRAY\r\n");
		array.setBackground(Color.CYAN);
		array.setFont(new Font("Constantia", Font.BOLD, 12));
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE ARRAY WINDOW CODE HERE
				Array a=new Array();
				a.setVisible(true);
			}
		});
		array.setBounds(159, 50, 85, 21);
		singlylinkedlist.add(array);
		
		JButton stack = new JButton("STACK\r\n");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE STACK WINDOW CODE HERE
				new Stack().setVisible(true);
			}
		});
		stack.setFont(new Font("Constantia", Font.BOLD, 12));
		stack.setBounds(35, 94, 85, 21);
		singlylinkedlist.add(stack);
		
		JButton queue = new JButton("QUEUE\r\n");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE QUEUE WINDOW CODE HERE
				new queue().setVisible(true);
			}
		});
		queue.setFont(new Font("Constantia", Font.BOLD, 12));
		queue.setBounds(301, 92, 85, 21);
		singlylinkedlist.add(queue);
		
		JButton circularqueue = new JButton("CIRCULAR QUEUE");
		circularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE CIRCULAR QUEUE WINDOW CODE HERE
				new CircularQueue().setVisible(true);
				
			}
		});
		circularqueue.setFont(new Font("Constantia", Font.BOLD, 12));
		circularqueue.setBounds(10, 156, 149, 21);
		singlylinkedlist.add(circularqueue);
		
		JButton btnNewButton_4 = new JButton("SINGLY LINKED LIST");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE SINGLY LINKED LIST WINDOW CODE HERE
				new SinglyLinkedList().setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Constantia", Font.BOLD, 12));
		btnNewButton_4.setBounds(268, 154, 158, 21);
		singlylinkedlist.add(btnNewButton_4);
		
		JButton doublylinkedlist = new JButton("DOUBLY LINKED LIST");
		doublylinkedlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE DOUBLY LINKED LIST WINDOW CODE HERE
				new DoublyLinkedList().setVisible(true);
			}
		});
		doublylinkedlist.setFont(new Font("Constantia", Font.BOLD, 12));
		doublylinkedlist.setBounds(142, 213, 163, 23);
		singlylinkedlist.add(doublylinkedlist);
	}
}
