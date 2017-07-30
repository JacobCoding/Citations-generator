package sample;

import javafx.scene.control.Alert;

/**
 * Created by Qbala on 2017-07-17.
 */
public class Utils {

    public static void createDialog(String title, String header, String content){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(header);
        alert.show();

    }



}
