package com.pdfPassworder.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

public class StartSceneController implements Initializable {

    @FXML
    private Label programName;

//    @FXML
//    private ToggleButton togglePassword;
//
//    @FXML
//    private Button choosePath;
//
//    @FXML
//    private Button savePath;
//
//    @FXML
//    private TextField pdfLoadPath;
//
//    @FXML
//    private TextField pdfSavePath;
//
//    @FXML
//    private TextField password;
//
//    @FXML
//    private TextField passwordConfirm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String projectName = System.getProperty("project.name");
        programName.setText(projectName);

    }
}
