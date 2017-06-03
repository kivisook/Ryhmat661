import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by kersti on 03.06.17.
 */
public class TestStart3 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage peaLava) {

            //Võrgustik
        GridPane grid = new GridPane();
        grid.setVgap(20);                   //rea laius
        grid.setGridLinesVisible(false); // ei näita võrgustikku
        //grid.setGridLinesVisible(true); // näitab ka võrgustikku

            //Võrgustiku kaugus  servadest
        grid.setPadding(new Insets(20, 10, 20, 10));

            //Võrgustiku veergude laiuste määramine
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        grid.getColumnConstraints().addAll(col1,col2);

            //sisuga täitmine
        Text tekst = new Text("Kontrolltöö variantide generaator");
        Text info = new Text("Projekti töökataloogis peab olema fail nimega 'nimekiri.txt'");
            //pealkirja sisestuse koha kohta info
        Text pealkiri = new Text("Kontrolltöö pealkiri");
            //pealkirja sisestamise tekstiväli
        TextField sisestaPealkiri = new TextField();
            //nupp Kontrolltöö loomiseks
        Button kontrolliNupp = new Button("Loo uus kontrolltöö");

            //osade lisamine ruudustikku
        grid.add(tekst,0,0);
        grid.add(info, 0, 1);
        grid.add(pealkiri, 0,2);
        grid.add(sisestaPealkiri,1,2);
        grid.add(kontrolliNupp, 1, 3);

        Scene stseen1 = new Scene(grid, 600, 300, Color.SNOW);
        peaLava.setTitle("Generaator");
        peaLava.setResizable(true);
        peaLava.setScene(stseen1);
        peaLava.show();
    }

}
