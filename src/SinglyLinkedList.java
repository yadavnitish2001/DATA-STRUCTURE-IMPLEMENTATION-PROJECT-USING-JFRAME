import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class SinglyLinkedList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField element;
    private JTextField elementfront;
    private JTextField displaybox;

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node first;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SinglyLinkedList frame = new SinglyLinkedList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SinglyLinkedList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 373);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        lblNewLabel.setBounds(129, 10, 340, 24);
        contentPane.add(lblNewLabel);

        JLabel lblEnterAnElement = new JLabel("ENTER THE ELEMENT :");
        lblEnterAnElement.setForeground(Color.BLUE);
        lblEnterAnElement.setFont(new Font("Constantia", Font.BOLD, 14));
        lblEnterAnElement.setBounds(40, 72, 159, 18);
        contentPane.add(lblEnterAnElement);

        element = new JTextField();
        element.setBounds(200, 70, 96, 19);
        contentPane.add(element);
        element.setColumns(10);

        JButton insert = new JButton("INSERT REAR");
        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertAtRear();
            }
        });
        insert.setForeground(Color.BLUE);
        insert.setFont(new Font("Constantia", Font.BOLD, 15));
        insert.setBounds(334, 69, 159, 27);
        contentPane.add(insert);

        JLabel lblEnterTheElement = new JLabel("ENTER THE ELEMENT :");
        lblEnterTheElement.setForeground(Color.BLUE);
        lblEnterTheElement.setFont(new Font("Constantia", Font.BOLD, 14));
        lblEnterTheElement.setBounds(40, 123, 159, 18);
        contentPane.add(lblEnterTheElement);

        elementfront = new JTextField();
        elementfront.setBounds(200, 121, 96, 19);
        contentPane.add(elementfront);
        elementfront.setColumns(10);

        JButton insertfront = new JButton("INSERT FRONT");
        insertfront.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertAtFront();
            }
        });
        insertfront.setFont(new Font("Tahoma", Font.PLAIN, 14));
        insertfront.setForeground(Color.BLUE);
        insertfront.setBounds(334, 120, 159, 25);
        contentPane.add(insertfront);

        JButton deleterear = new JButton("DELETE REAR");
        deleterear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAtRear();
            }
        });
        deleterear.setForeground(Color.BLUE);
        deleterear.setFont(new Font("Constantia", Font.BOLD, 14));
        deleterear.setBounds(245, 164, 159, 27);
        contentPane.add(deleterear);

        JButton deletefront = new JButton("DELETE FRONT");
        deletefront.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAtFront();
            }
        });
        deletefront.setForeground(Color.BLUE);
        deletefront.setFont(new Font("Constantia", Font.BOLD, 14));
        deletefront.setBounds(245, 201, 159, 27);
        contentPane.add(deletefront);

        JButton display = new JButton("DISPLAY");
        display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayElements();
            }
        });
        display.setForeground(Color.BLUE);
        display.setFont(new Font("Constantia", Font.BOLD, 14));
        display.setBounds(265, 238, 107, 27);
        contentPane.add(display);

        displaybox = new JTextField();
        displaybox.setBounds(200, 287, 232, 19);
        contentPane.add(displaybox);
        displaybox.setColumns(10);
    }

    private void insertAtRear() {
        try {
            int data = Integer.parseInt(element.getText());
            Node newNode = new Node(data);

            if (first == null) {
                first = newNode;
            } else {
                Node temp = first;
                while (temp.link != null) {
                    temp = temp.link;
                }
                temp.link = newNode;
            }
            element.setText("");
            JOptionPane.showMessageDialog(contentPane, "Element inserted at the rear successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid integer for the element.");
        }
    }

    private void insertAtFront() {
        try {
            int data = Integer.parseInt(elementfront.getText());
            Node newNode = new Node(data);
            newNode.link = first;
            first = newNode;
            elementfront.setText("");
            JOptionPane.showMessageDialog(contentPane, "Element inserted at the front successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid integer for the element.");
        }
    }

    private void deleteAtRear() {
        if (first == null) {
            JOptionPane.showMessageDialog(contentPane, "DELETION NOT POSSIBLE. Linked List is empty.");
        } else if (first.link == null) {
            first = null;
            JOptionPane.showMessageDialog(contentPane, "Element deleted at the rear successfully.");
        } else {
            Node temp = first;
            while (temp.link.link != null) {
                temp = temp.link;
            }
            temp.link = null;
            JOptionPane.showMessageDialog(contentPane, "Element deleted at the rear successfully.");
        }
    }

    private void deleteAtFront() {
        if (first == null) {
            JOptionPane.showMessageDialog(contentPane, "DELETION NOT POSSIBLE. Linked List is empty.");
        } else {
            first = first.link;
            JOptionPane.showMessageDialog(contentPane, "Element deleted at the front successfully.");
        }
    }

    private void displayElements() {
        if (first == null) {
            JOptionPane.showMessageDialog(contentPane, "Linked List is empty. Nothing to display.");
        } else {
            StringBuilder result = new StringBuilder();
            Node temp = first;
            while (temp != null) {
                result.append(temp.data).append(" ");
                temp = temp.link;
            }
            displaybox.setText(result.toString());
        }
    }

}
