import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class View extends Pane {
    public Button[][] buttons;
    private TextField box;
    public View(){

        box = new TextField();
        box.setEditable(false);
        box.relocate(10,10);
        box.setPrefSize(250,50);
        getChildren().add(box);

        buttons = new Button[5][4];
        String[] buttonLabels = {"C", "%", "÷", "√", "7", "8", "9", "x", "4", "5", "6", "-","1","2","3","+","0",".","±","="};
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new Button(buttonLabels[row * 4 + col]);
                buttons[row][col].relocate(10 + col * 70, 75 + row * 70);
                buttons[row][col].setPrefSize(65, 65);
                buttons[row][col].setStyle("-fx-base: rgb(0,0,50);");
                getChildren().add(buttons[row][col]);
            }
        }
    }
    public TextField getBox(){
        return box;
    }

    public void update(){
        buttons[0][1].setDisable(true);
        buttons[0][2].setDisable(true);
        buttons[0][3].setDisable(true);
        buttons[1][3].setDisable(true);
        buttons[2][3].setDisable(true);
        buttons[3][3].setDisable(true);
        buttons[4][3].setDisable(true);
    }

    public void undoUpdate(){
        buttons[0][1].setDisable(false);
        buttons[0][2].setDisable(false);
        buttons[0][3].setDisable(false);
        buttons[1][3].setDisable(false);
        buttons[2][3].setDisable(false);
        buttons[3][3].setDisable(false);
        buttons[4][3].setDisable(false);
    }
}
