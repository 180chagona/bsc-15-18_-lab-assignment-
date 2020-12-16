import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
public class Calculator extends Application {

    
  

    @Override
    public void start(Stage stage) throws Exception {
        List<String>list=Arrays.asList("CE","C","Back","/","7","8","9","X","4" ,"5","6","-",
                "1","2","3","+","+/-","0",".","=");
        FlowPane root=new FlowPane(5,5);
        root.setPadding(new Insets(15,10,15,10));
        root.setMaxWidth(320);
        root.setMinWidth(320);
        root.setPrefWidth(320);
        
        TextField t=new TextField("0");
        t.setEditable(false);
         t.setMinSize(295,45);
         t.setAlignment(Pos.CENTER_RIGHT);
         root.getChildren().add(t);
        for(String s: list){
        
            Button b=new Button(s);
            b.setMinSize(70,70);
            root.getChildren().add(b);
            b.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent event) {
                    System.out.println(b.getText());
                    calculateOperations(b.getText());
                }

                private void calculateOperations(String text) {
                    String preData=t.getText().trim();
                    int x=validateInput(preData);
                    if(x>0){
                        t.appendText(String.valueOf(x));
                    }
                    else{
                        t.appendText(text);
                    }
                    
                   }

                private int validateInput(String data) {
                    try{
                        Integer.valueOf(data); 
                    }
                    catch(NumberFormatException e){
                        System.out.println(e.getMessage());
                    }
                    return 0;
                }
            
            });
            
        }
        
        
        
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        stage.show();
    }
    public static void main(String []args){
      launch(args);
  }
}
