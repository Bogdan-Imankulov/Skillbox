package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MainForm {
    private boolean isCollapse;
    private JPanel mainPanel;
    private JButton collapse;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JTextField secondNameField;
    private JTextField thirdNameField;
    private JTextField showTextField;
    private JTextField firstNameField;

    public MainForm() {
        isCollapse = true;
        showTextField.setEditable(false);
        outputPanel.setVisible(false);
        showTextField.setSize(new Dimension(100, 50));
        showTextField.setBackground(new Color(180, 180, 180));
        collapse.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String secondName = secondNameField.getText();
                String thirdName = thirdNameField.getText();
                if (isCollapse) {
                    if (firstName.isEmpty() || secondName.isEmpty()) {
                        JOptionPane.showConfirmDialog(mainPanel, "Please enter first and second name!", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    } else {
                        String withoutThirdName = "Full name: " + firstName + " " + secondName;
                        String withThirdName = withoutThirdName + " " + thirdName;
                        showTextField.setText((!Objects.equals(thirdName, "")) ? (withThirdName) : (withoutThirdName));
                        firstNameField.setText("");
                        secondNameField.setText("");
                        thirdNameField.setText("");
                        collapse.setText("Expand");
                        outputPanel.setVisible(true);
                        isCollapse = false;
                    }
                } else {
                    String textField = showTextField.getText().substring(showTextField.getText().indexOf(":"));
                    String matchWithoutThirdName = "\\s+[a-zA-Zа-яА-Я]+\\s+[a-zA-Zа-яА-Я]+";
                    String matchWithThirdName = matchWithoutThirdName + "\\s+[a-zA-Zа-яА-Я]+";
                    if (textField.matches(matchWithoutThirdName)) {
                        JOptionPane.showConfirmDialog(mainPanel, "You entered wrong text! It's not full name", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    } else if (textField.matches(matchWithThirdName)){
                        JOptionPane.showConfirmDialog(mainPanel, "You entered wrong text! It's not full name", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        String[] split = textField.split("\\s");
                        firstNameField.setText(split[1]);
                        secondNameField.setText(split[2]);
                        if (split.length > 3) {
                            thirdNameField.setText(split[3]);
                        } else {
                            thirdNameField.setText("");
                        }
                        collapse.setText("Collapse");
                        showTextField.setText("");
                        outputPanel.setVisible(false);
                        isCollapse = true;
                    }
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
