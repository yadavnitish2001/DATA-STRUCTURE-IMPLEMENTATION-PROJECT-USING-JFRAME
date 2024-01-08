import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoublyLinkedList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField element;
    private JTextField elementfront;
    private JTextArea displayBox;
    private JLabel messageLabel;

    class Node {
        int data;
        Node next;
        Node prev;
    }

    private Node head;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoublyLinkedList frame = new DoublyLinkedList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DoublyLinkedList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("DOUBLY LINKED LIST DATA STRUCTURE");
        lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
        lblNewLabel.setBounds(100, 10, 400, 24);
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
        insert.setBounds(334, 69, 131, 27);
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
        insertfront.setBounds(334, 120, 131, 25);
        contentPane.add(insertfront);

        JButton deleterear = new JButton("DELETE REAR");
        deleterear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAtRear();
            }
        });
        deleterear.setForeground(Color.BLUE);
        deleterear.setFont(new Font("Constantia", Font.BOLD, 14));
        deleterear.setBounds(245, 164, 129, 27);
        contentPane.add(deleterear);

        JButton deletefront = new JButton("DELETE FRONT");
        deletefront.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAtFront();
            }
        });
        deletefront.setForeground(Color.BLUE);
        deletefront.setFont(new Font("Constantia", Font.BOLD, 14));
        deletefront.setBounds(245, 201, 141, 27);
        contentPane.add(deletefront);

        JButton displayFront = new JButton("DISPLAY FRONT");
        displayFront.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFrontElements();
            }
        });
        displayFront.setForeground(Color.BLUE);
        displayFront.setFont(new Font("Constantia", Font.BOLD, 14));
        displayFront.setBounds(80, 238, 150, 27);
        contentPane.add(displayFront);

        JButton displayRear = new JButton("DISPLAY REAR");
        displayRear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayRearElements();
            }
        });
        displayRear.setForeground(Color.BLUE);
        displayRear.setFont(new Font("Constantia", Font.BOLD, 14));
        displayRear.setBounds(290, 238, 150, 27);
        contentPane.add(displayRear);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 300, 500, 120);
        contentPane.add(scrollPane);

        displayBox = new JTextArea();
        scrollPane.setViewportView(displayBox);

        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(new Font("Constantia", Font.BOLD, 14));
        messageLabel.setBounds(40, 440, 500, 18);
        contentPane.add(messageLabel);
    }

    private void insertAtRear() {
        try {
            int data = Integer.parseInt(element.getText());
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = null;

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }

            showMessage("Element " + data + " inserted at the rear.");
            displayElements();
            clearInputFields();
        } catch (NumberFormatException ex) {
            showMessage("Please enter a valid integer for the element.");
        }
    }

    private void insertAtFront() {
        try {
            int data = Integer.parseInt(elementfront.getText());
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            newNode.prev = null;

            if (head != null) {
                head.prev = newNode;
            }

            head = newNode;

            showMessage("Element " + data + " inserted at the front.");
            displayElements();
            clearInputFields();
        } catch (NumberFormatException ex) {
            showMessage("Please enter a valid integer for the element.");
        }
    }

    private void deleteAtRear() {
        if (head == null) {
            showMessage("Cannot delete from an empty list.");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        if (temp.prev != null) {
            temp.prev.next = null;
            showMessage("Element " + temp.data + " deleted from the rear.");
        } else {
            head = null;
            showMessage("Element " + temp.data + " deleted from the rear.");
        }

        displayElements();
        clearInputFields();
    }

    private void deleteAtFront() {
        if (head == null) {
            showMessage("Cannot delete from an empty list.");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
            showMessage("Element deleted from the front.");
        } else {
            showMessage("Element deleted from the front.");
        }

        displayElements();
        clearInputFields();
    }

    private void displayFrontElements() {
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            result.append(temp.data).append(" ");
            temp = temp.next;
        }
        showMessage("Front Elements: " + result.toString());
    }

    private void displayRearElements() {
        if (head == null) {
            showMessage("List is empty.");
            return;
        }

        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            result.append(temp.data).append(" ");
            temp = temp.prev;
        }

        showMessage("Rear Elements: " + result.toString());
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    private void displayElements() {
        StringBuilder result = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            result.append(temp.data).append(" ");
            temp = temp.next;
        }
        displayBox.setText(result.toString());
    }

    private void clearInputFields() {
        element.setText("");
        elementfront.setText("");
    }
}
