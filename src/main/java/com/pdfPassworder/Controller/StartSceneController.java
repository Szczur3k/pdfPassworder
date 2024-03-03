package com.pdfPassworder.Controller;

import com.pdfPassworder.SecurePdf.SecurePdf;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class StartSceneController implements Initializable {

    @FXML
    private Label programName;

    @FXML
    private ToggleButton togglePassword;

    @FXML
    private Button loadPathButton;

    @FXML
    private Button savePathButton;

    @FXML
    private Button savePdfButton;

    @FXML
    private TextField pdfLoadPath;

    @FXML
    private TextField pdfSavePath;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordConfirm;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField passwordConfirmTextField;

    private SecurePdf securePdf;

    private String pdfName;

    private Alert alert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        programName.setText("Pdf Passworder");
        securePdf = new SecurePdf();
        alert = new Alert(Alert.AlertType.INFORMATION);
        passwordTextField.textProperty().bindBidirectional(password.textProperty());
        passwordConfirmTextField.textProperty().bindBidirectional(passwordConfirm.textProperty());
    }

    public void chooseLoadPdfPathAction() {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) loadPathButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile == null) {
            return;
        }
        pdfName = selectedFile.getName();
        pdfLoadPath.setText(selectedFile.getPath());
    }

    public void chooseSavePdfPathAction() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage stage = (Stage) savePathButton.getScene().getWindow();
        File selectedFile = directoryChooser.showDialog(stage);
        if (selectedFile == null) {
            return;
        }
        pdfSavePath.setText(selectedFile.getPath());
    }

    public void savePdf() {
        if (!checkCorrectPaths()) {
            alertConfirmation("ścieżki do plików są złe");
        } else if (!checkCorrectPassword()) {
            alertConfirmation("hasło nie jest takie samo");
        } else {
            securePdf.secure(pdfLoadPath.getText(), pdfSavePath.getText(), pdfName, password.getText());
        }
    }

    public void toggleVisiblePassword() {
        if (!passwordTextField.isVisible()) {
            password.setVisible(false);
            passwordConfirm.setVisible(false);
            passwordTextField.setVisible(true);
            passwordConfirmTextField.setVisible(true);
            togglePassword.setText("ukryj hasło");
        } else {
            password.setVisible(true);
            passwordConfirm.setVisible(true);
            passwordTextField.setVisible(false);
            passwordConfirmTextField.setVisible(false);
            togglePassword.setText("pokaż hasło");
        }
    }

    private void alertConfirmation(String headerNameError) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setHeaderText(headerNameError);
        alert.setContentText(null);
        alert.showAndWait();
    }

    private boolean checkCorrectPassword() {
        String passwordText = password.getText();
        String passwordConfirmText = passwordConfirm.getText();
        return passwordText != null && !passwordText.isEmpty() && passwordConfirmText != null && !passwordConfirmText.isEmpty() && passwordText.equals(passwordConfirmText);
    }

    private boolean checkCorrectPaths() {
        if (pdfLoadPath.getText() == null || pdfLoadPath.getText().isEmpty() || pdfSavePath.getText() == null || pdfSavePath.getText().isEmpty()) {
            return false;
        }
        return pdfLoadPath.getText().endsWith(".pdf");
    }
}
