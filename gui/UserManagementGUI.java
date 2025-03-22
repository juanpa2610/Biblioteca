package com.example.gui;

import com.example.manager.UserManager;
import com.example.model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagementGUI {
    private UserManager userManager;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField ageField;
    private JTextArea userListArea;

    public UserManagementGUI() {
        userManager = new UserManager();
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("User  Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Campos de entrada
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        phoneField = new JTextField(10);
        emailField = new JTextField(10);
        ageField = new JTextField(3);

        // Botones
        JButton addButton = new JButton("Agregar Usuario");
        JButton removeButton = new JButton("Eliminar Usuario");
        JButton listButton = new JButton("Listar Usuarios");

        // Área de texto para mostrar la lista de usuarios
        userListArea = new JTextArea(10, 30);
        userListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userListArea);

        // Agregar componentes al marco
        frame.add(new JLabel("Nombre:"));
        frame.add(firstNameField);
        frame.add(new JLabel("Apellido:"));
        frame.add(lastNameField);
        frame.add(new JLabel("Teléfono:"));
        frame.add(phoneField);
        frame.add(new JLabel("Correo:"));
        frame.add(emailField);
        frame.add(new JLabel("Edad:"));
        frame.add(ageField);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(listButton);
        frame.add(scrollPane);

        // Acción para agregar usuario
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                int age = Integer.parseInt(ageField.getText());

                User user = new User(firstName, lastName, phone, email, age);
                userManager.addUser (user);
                clearFields();
                JOptionPane.showMessageDialog(frame, "Usuario agregado.");
            }
        });

        // Acción para eliminar usuario
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                userManager.removeUser (email);
                clearFields();
                JOptionPane.showMessageDialog(frame, "Usuario eliminado.");
            }
        });

        // Acción para listar usuarios
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userListArea.setText(""); // Limpiar el área de texto
                for (User  user : userManager.listUsers()) {
                    userListArea.append("Nombre: " + user.getFirstName() + " " + user.getLastName() + "\n");
                    userListArea.append("Teléfono: " + user.getPhone() + "\n");
                    userListArea.append("Correo: " + user.getEmail() + "\n");
                    userListArea.append("Edad: " + user.getAge() + "\n");
                    userListArea.append("-------------------------\n");
                }
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        ageField.setText("");
    }

    public static void main(String[] args) {
        new UserManagementGUI();
    }
}