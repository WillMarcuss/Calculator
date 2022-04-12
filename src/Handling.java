import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Handling extends Application {
    private double firstNum;
    private double secondNum;
    private String whichCalculation;
    public void start(Stage primaryStage){
    Pane aPane = new Pane();
    aPane.setStyle("-fx-base: rgb(50,50,50);");

    View view = new View();
    aPane.getChildren().add(view);
    view.update();

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 4; col++) {
                int finalRow = row;
                int finalCol = col;

                    view.buttons[row][col].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                                Button b = (Button)actionEvent.getSource();
                                if(b == view.buttons[1][0]||b == view.buttons[1][1]||b == view.buttons[1][2]||b == view.buttons[2][0]||b == view.buttons[2][1]||b == view.buttons[2][2]||b == view.buttons[3][0]||b == view.buttons[3][1]||b == view.buttons[3][2]||b == view.buttons[4][0]){
                                    view.getBox().appendText(view.buttons[finalRow][finalCol].getText());
                                    view.undoUpdate();
                                }
                                if(b == view.buttons[0][0]){ //Clear button
                                    view.getBox().clear();
                                    view.buttons[4][1].setDisable(false);
                                    view.update();
                                }
                                if(b == view.buttons[0][1]){ //Percent button
                                    view.getBox().setText(""+(Double.parseDouble(view.getBox().getText()))/100);
                                }
                                if(b == view.buttons[0][3]){ //Square root button
                                    if(Double.parseDouble(view.getBox().getText())>0) {
                                        view.getBox().setText("" + (Math.sqrt(Double.parseDouble(view.getBox().getText()))));
                                    }
                                    else{
                                        view.getBox().setText("Error");
                                    }
                                }
                                if(b == view.buttons[0][2]){ //Divide button
                                    firstNum = Double.parseDouble(view.getBox().getText());
                                    whichCalculation = "divide";
                                    view.getBox().clear();
                                    view.buttons[4][1].setDisable(false);

                                }
                                if(b == view.buttons[4][3]){ //Equals button
                                    secondNum = Double.parseDouble(view.getBox().getText());
                                    view.getBox().setText(doCalculation(whichCalculation));
                                }
                                if(b == view.buttons[1][3]){ //Multiplication button
                                    firstNum = Double.parseDouble(view.getBox().getText());
                                    whichCalculation = "multiply";
                                    view.getBox().clear();
                                    view.buttons[4][1].setDisable(false);
                                }

                                if(b == view.buttons[2][3]){ //Minus button
                                    firstNum = Double.parseDouble(view.getBox().getText());
                                    whichCalculation = "minus";
                                    view.getBox().clear();
                                    view.buttons[4][1].setDisable(false);
                                }
                                if(b == view.buttons[3][3]){
                                    firstNum = Double.parseDouble(view.getBox().getText());
                                    whichCalculation = "plus";
                                    view.getBox().clear();
                                    view.buttons[4][1].setDisable(false);
                                }
                                if(b == view.buttons[4][1]){
                                    view.getBox().appendText(".");
                                    view.buttons[4][1].setDisable(true);
                                }

                                if(b == view.buttons[4][2]){
                                    view.getBox().setText(""+(Double.parseDouble(view.getBox().getText()))*-1);
                                }

                            }
                    });
                }

        }

    primaryStage.setTitle("Calculator");
    primaryStage.setResizable(false);
    primaryStage.setScene(new Scene(aPane, 295,425));
    primaryStage.show();
    }

    public String doCalculation(String unit){
        double x = 0;
        if(unit == "divide"){
            x = firstNum/secondNum;
        }
        else if(unit == "multiply"){
            x = firstNum*secondNum;
        }
        else if(unit == "minus"){
            x = firstNum-secondNum;
        }
        else if(unit == "plus"){
            x = firstNum+secondNum;
        }
        return " "+x;
    }

        public static void main(String[] args) {
            launch(args);
        }
    }
