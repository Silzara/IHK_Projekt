package com.example.bildorganisator_ihk_projekt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String browse = Browse.selectFolder();
        GetImagesFromFolder test = new GetImagesFromFolder(browse);
        //
        welcomeText.setText(test.toString());
    }
}