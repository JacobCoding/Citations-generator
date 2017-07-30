package sample;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {

    // wszystkie buttony w środu importują fxml - imort na górze a ten poniżej bieże fxml
    //private java.awt.Button awtButton;

    @FXML
    private Button buttonHello;

    @FXML
    private Button buttonAdd;

    @FXML
    private Label labelText;

    @FXML
    private TextField textFieldInPut;

    private List<String> words = new ArrayList<String>();
    private List<String> randedWords = new ArrayList<String>();

    //private Set<String> randedWords = new HashSet<String>();

    private Random random;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        words = new ArrayList<String>();
        words.add("Życie jest piękne");
        words.add("Bez pracy nie ma kołaczy");
        words.add("Ciesz się z małych rzeczy");
        words.add("Nie oglądaj się z siebie bo Ci z przodu ktoś prz....");

        random = new Random();

        Utils.createDialog("Witaj","Nie zapomnij o koncie premium", "Dobre zabawy :)");


        buttonHello.setOnMouseClicked(event -> handleRandomSentence(event));

        buttonAdd.setOnMouseClicked(event -> handleButtonAdd(event));

        textFieldInPut.setOnKeyPressed(event -> handleKeyPressed(event));

    }

    private void handleKeyPressed(KeyEvent e) {
        if(e.getCode() == KeyCode.ENTER){
            words.add(textFieldInPut.getText());
            textFieldInPut.clear();
        }
    }


    private void handleButtonAdd(MouseEvent e){
        words.add(textFieldInPut.getText());
        textFieldInPut.clear();
//        System.out.println("Tescik);
    }


    private void handleRandomSentence(MouseEvent e){
        String randedWord = words.get(random.nextInt(words.size()));

        while(randedWords.contains(randedWord)){
            randedWord = words.get(random.nextInt(words.size()));

            if(randedWords.size() == words.size()){
                Utils.createDialog("Błąd", "", "Koniec sentencji :( ");
                return;
            }
        }
        labelText.setText(randedWord);
        randedWords.add(randedWord);
    }


    }

////////////////////////////////////////////////////////////////////////////////////////////