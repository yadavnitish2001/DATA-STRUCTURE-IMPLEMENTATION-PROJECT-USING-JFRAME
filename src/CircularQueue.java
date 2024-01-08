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

public class CircularQueue extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField length;
    private JTextField element;
    private JTextField displaybox;
    private int cq[];
    private int size;
    private int rear = -1;
    private int front = -1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CircularQueue frame = new CircularQueue();
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
    public CircularQueue() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 574, 416);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 204, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("CIRCULAR QUEUE DATA STRUCTURE");
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        lblNewLabel.setBounds(90, 22, 400, 24);
        contentPane.add(lblNewLabel);

        JLabel lblEnterQueueSize = new JLabel("ENTER QUEUE SIZE :");
        lblEnterQueueSize.setForeground(new Color(0, 0, 51));
        lblEnterQueueSize.setFont(new Font("Constantia", Font.BOLD, 14));
        lblEnterQueueSize.setBounds(38, 89, 145, 18);
        contentPane.add(lblEnterQueueSize);

        length = new JTextField();
        length.setBounds(184, 87, 96, 19);
        contentPane.add(length);
        length.setColumns(10);

        JButton create = new JButton("CREATE CIRCULAR QUEUE\r\n");
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CREATE CIRCULAR QUEUE
                try {
                    size = Integer.parseInt(length.getText());
                    if (size <= 0) {
                        JOptionPane.showMessageDialog(contentPane, "Please enter a positive integer for the queue size.");
                    } else {
                        cq = new int[size];
                        String message = "Circular Queue of size " + size + " created.";
                        JOptionPane.showMessageDialog(contentPane, message);
                        front = rear = -1;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Please enter a valid integer for the queue size.");
                }
            }
        });
        create.setForeground(new Color(0, 0, 51));
        create.setFont(new Font("Constantia", Font.BOLD, 14));
        create.setBounds(178, 131, 221, 27);
        contentPane.add(create);

        JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT :");
        lblEnterAnElement.setFont(new Font("Constantia", Font.BOLD, 14));
        lblEnterAnElement.setForeground(new Color(0, 0, 51));
        lblEnterAnElement.setBounds(38, 176, 150, 18);
        contentPane.add(lblEnterAnElement);

        element = new JTextField();
        element.setBounds(184, 174, 96, 19);
        contentPane.add(element);
        element.setColumns(10);

        JButton insert = new JButton("INSERT");
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // INSERT AN ELEMENT
                int elem;
                try {
                    if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
                        JOptionPane.showMessageDialog(contentPane, "INSERTION NOT POSSIBLE. Circular Queue is full.");
                    } else if (front == -1) {
                        front = rear = 0;
                        elem = Integer.parseInt(element.getText());
                        cq[rear] = elem;
                        JOptionPane.showMessageDialog(contentPane, "INSERT SUCCESSFULLY");
                        element.setText("");
                    } else if (rear == size - 1 && front != 0) {
                        rear = 0;
                        elem = Integer.parseInt(element.getText());
                        cq[rear] = elem;
                        JOptionPane.showMessageDialog(contentPane, "INSERT SUCCESSFULLY");
                        element.setText("");
                    } else {
                        rear++;
                        elem = Integer.parseInt(element.getText());
                        cq[rear] = elem;
                        JOptionPane.showMessageDialog(contentPane, "INSERT SUCCESSFULLY");
                        element.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Please enter a valid integer for the element.");
                }
            }
        });
        insert.setFont(new Font("Constantia", Font.BOLD, 14));
        insert.setBounds(321, 173, 109, 21);
        contentPane.add(insert);

        JButton delete = new JButton("DELETE");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // DELETE THE ELEMENTS
                if (front == -1) {
                    JOptionPane.showMessageDialog(contentPane, "DELETION NOT POSSIBLE. Circular Queue is empty.");
                } else if (front == rear) {
                    String message = "ELEMENT DELETED IS: " + cq[front];
                    JOptionPane.showMessageDialog(contentPane, message);
                    front = rear = -1;
                } else {
                    String message = "ELEMENT DELETED IS: " + cq[front];
                    JOptionPane.showMessageDialog(contentPane, message);
                    if (front == size - 1)
                        front = 0;
                    else
                        front++;
                }
            }
        });
        delete.setFont(new Font("Constantia", Font.BOLD, 14));
        delete.setBounds(236, 226, 109, 27);
        contentPane.add(delete);

        JButton display = new JButton("DISPLAY");
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // DISPLAY THE ELEMENTS
                String msg = "";
                if (front == -1) {
                    JOptionPane.showMessageDialog(contentPane, "DISPLAY NOT POSSIBLE. Circular Queue is empty.");
                } else if (rear >= front) {
                    for (int i = front; i <= rear; i++) {
                        msg = msg + " " + cq[i];
                    }
                } else {
                    for (int i = front; i < size; i++) {
                        msg = msg + " " + cq[i];
                    }
                    for (int i = 0; i <= rear; i++) {
                        msg = msg + " " + cq[i];
                    }
                }
                displaybox.setText(msg);
            }
        });
        display.setFont(new Font("Constantia", Font.BOLD, 14));
        display.setBounds(236, 279, 109, 27);
        contentPane.add(display);

        displaybox = new JTextField();
        displaybox.setBounds(166, 332, 240, 19);
        contentPane.add(displaybox);
        displaybox.setColumns(10);
    }
}
