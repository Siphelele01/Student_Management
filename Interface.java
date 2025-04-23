import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface extends JFrame{

        private JLabel name, surname, rollNumber, course, mark, appTitle;
        private JPanel topPanel, middlePanel, bottomPanel;
        private JTextField nametxt, surnametxt, rollNumbertxt, coursetxt, marktxt;
        private JButton submit, exit, clear, view, update, delete, search;
       // ArrayList to hold students
        private ArrayList<Student> studentList;

        public Interface() {
            // Initialize the ArrayList
            studentList = new ArrayList<>();

            setTitle("Student Management System");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            topPanel = new JPanel();
            middlePanel = new JPanel(new GridLayout(6, 2, 8, 50));
            bottomPanel = new JPanel(new GridLayout(2, 4));

            appTitle = new JLabel("Welcome to Student Management", JLabel.CENTER);
            name = new JLabel("Name:");
            surname = new JLabel("Surname:");
            rollNumber = new JLabel("Roll Number:");
            course = new JLabel("Course:");
            mark = new JLabel("Mark:");

            nametxt = new JTextField(10);
            surnametxt = new JTextField(15);
            rollNumbertxt = new JTextField(15);
            coursetxt = new JTextField(15);
            marktxt = new JTextField(15);

            clear = new JButton("Clear");
            exit = new JButton("Exit");
            submit = new JButton("Submit");
            search = new JButton("Search");
            view = new JButton("View");
            update = new JButton("Update");
            delete = new JButton("Delete");

            topPanel.add(appTitle);
            middlePanel.add(name);
            middlePanel.add(nametxt);
            middlePanel.add(surname);
            middlePanel.add(surnametxt);
            middlePanel.add(rollNumber);
            middlePanel.add(rollNumbertxt);
            middlePanel.add(course);
            middlePanel.add(coursetxt);
            middlePanel.add(mark);
            middlePanel.add(marktxt);

            bottomPanel.add(submit);
            bottomPanel.add(clear);
            bottomPanel.add(exit);
            bottomPanel.add(search);
            bottomPanel.add(view);
            bottomPanel.add(update);
            bottomPanel.add(delete);

            // Action listeners
            submit.addActionListener(new Submit());
            clear.addActionListener(new Clear());
            exit.addActionListener(new Exit());
            search.addActionListener(new Search());
            view.addActionListener(new View());
            update.addActionListener(new Update());
            delete.addActionListener(new Delete());
       // Setting Interface Border Layouts
            add(topPanel, BorderLayout.NORTH);
            add(middlePanel, BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);
            //Setting interface size
            setSize(700, 600);
            setVisible(true);
        }
          // Clearing all the Text Fields
        private class Clear implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                nametxt.setText("");
                surnametxt.setText("");
                rollNumbertxt.setText("");
                coursetxt.setText("");
                marktxt.setText("");
            }
        }
             // Executing Button Submit Including Exception
        private class Submit implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumbertxt.getText());
                    String name = nametxt.getText();
                    String surname = surnametxt.getText();
                    String course = coursetxt.getText();
                    int mark = Integer.parseInt(marktxt.getText());

                    Student student = new Student(rollNumber, surname, name, course, mark);
                    studentList.add(student); // Add student to the list
                    JOptionPane.showMessageDialog(null, "Student submitted: " + student.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for Roll Number and Mark.");
                }
            }
        }
    // Executing  Button Exit  Including Exception
        private class Exit implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
    // Executing  Button Search  Including Exception
        private class Search implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumbertxt.getText());
                    boolean found = false;

                    for (Student student : studentList) {
                        if (student.getRollNumber() == rollNumber) {
                            JOptionPane.showMessageDialog(null, "Student found: " + student.toString());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No student found with Roll Number: " + rollNumber);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Roll Number.");
                }
            }
        }
     // Executing  Button View  Including Exception
        private class View implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No students to display.");
                } else {
                    StringBuilder display = new StringBuilder("Students List:\n");
                    for (Student student : studentList) {
                        display.append(student.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, display.toString());
                }
            }
        }
      // Executing  Button Update  Including Exception
        private class Update implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumbertxt.getText());
                    boolean found = false;

                    for (Student student : studentList) {
                        if (student.getRollNumber() == rollNumber) {
                            String newName = nametxt.getText();
                            String newSurname = surnametxt.getText();
                            String newCourse = coursetxt.getText();
                            int newMark = Integer.parseInt(marktxt.getText());

                            // Create updated student
                            studentList.remove(student); // Remove old student
                            Student updatedStudent = new Student(rollNumber, newSurname, newName, newCourse, newMark);
                            studentList.add(updatedStudent); // Add updated student
                            JOptionPane.showMessageDialog(null, "Student updated: " + updatedStudent.toString());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No student found with Roll Number: " + rollNumber);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for Roll Number and Mark.");
                }
            }
        }
    // Executing  Button Delete  Including Exception
        private class Delete implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumbertxt.getText());
                    boolean found = false;

                    for (Student student : studentList) {
                        if (student.getRollNumber() == rollNumber) {
                            studentList.remove(student); // Remove the student
                            JOptionPane.showMessageDialog(null, "Student deleted: " + student.toString());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No student found with Roll Number: " + rollNumber);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Roll Number.");
                }
            }
        }
}
