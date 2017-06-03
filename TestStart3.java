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

        //Esimese Pealava võrgustik
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(5);
        grid.setGridLinesVisible(false); // ei näita võrgustikku
        //grid.setGridLinesVisible(true); // näitab ka võrgustikku

        grid.setPadding(new Insets(20, 10, 20, 10)); //Võrgustiku kaugus  servadest

        ColumnConstraints col1 = new ColumnConstraints();   //Võrgustiku veergude laiuste määramine
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        grid.getColumnConstraints().addAll(col1, col2);

        //sisuga täitmine
        Text tekst = new Text("Kontrolltöö variantide generaator");
        Text info = new Text("Projekti töökataloogis peab olema fail nimega 'nimekiri.txt'");
        //pealkirja sisestuse koha kohta info
        Text pealkiri = new Text("Kontrolltöö pealkiri");
        TextField sisestaPealkiri = new TextField();    //pealkirja sisestamise tekstiväli
        
        // vaja meelde jätta sisestatud pealkiri!

        //nupp Kontrolltöö loomiseks
        Button kontrolliNupp = new Button("Loo uus kontrolltöö");

        //kui vajutatakse nuppu, sulgub see pealava ja avaneb teine
        kontrolliNupp.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
            public void handle(ActionEvent event) {
                peaLava.hide();
            }
        });

        //osade lisamine ruudustikku
        grid.add(tekst, 0, 0);
        grid.add(info, 0, 1);
        grid.add(pealkiri, 0, 2);
        grid.add(sisestaPealkiri, 1, 2);
        grid.add(kontrolliNupp, 1, 3);

        Scene stseen1 = new Scene(grid, 600, 300, Color.SNOW);
        peaLava.setTitle("Generaator");
        peaLava.setResizable(true);
        peaLava.setScene(stseen1);
        peaLava.show();

        //vaja avada teine dialoogiaken e teine lava
        peaLava.setOnHiding(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent event) {
                Stage suurLava = new Stage();
                GridPane grid = new GridPane();
                grid.setPrefWidth(1100);
                grid.setHgap(2);
                grid.setVgap(5);                   //rea laius
                //grid.setGridLinesVisible(false); // ei näita võrgustikku
                grid.setGridLinesVisible(true); // näitab ka võrgustikku
                grid.setPadding(new Insets(20, 10, 20, 10)); //Võrgustiku kaugus  servadest

                //Võrgustiku veergude laiuste määramine
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setPercentWidth(50);
                ColumnConstraints col2 = new ColumnConstraints();
                col2.setPercentWidth(50);
                grid.getColumnConstraints().addAll(col1,col2);

                //sisuga täitmine
                Text tekst = new Text("Suur Arvestustöö");
                Text info = new Text("siia peab tekkima tekst, kui laadimine õnnestus");

                //osade lisamine ruudustikku
                grid.add(tekst,0,0);
                grid.add(info, 0, 1);
                Button nuppLõpeta = new Button("Lõpeta töö");
                grid.add(nuppLõpeta,1,4);
                //-------------------
                //Sisu võrgustik - Ülesannete haldamine
                GridPane grid1 = new GridPane();
                grid1.setHgap(2);
                grid1.setVgap(5);
                grid1.setPrefWidth(500);
                //grid1.setGridLinesVisible(false); // ei näita võrgustikku
                grid1.setGridLinesVisible(true); // näitab ka võrgustikku
                grid1.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col1_1 = new ColumnConstraints();
                //col1_1.setPercentWidth(60);
                col1_1.setPrefWidth(200.0);                         //määran eelistatavad laiused
                ColumnConstraints col1_2 = new ColumnConstraints();
                //col1_2.setPercentWidth(20);
                col1_2.setPrefWidth(100.0);
                ColumnConstraints col1_3 = new ColumnConstraints();
                //col1_3.setPercentWidth(20);
                col1_3.setPrefWidth(100.0);
                grid1.getColumnConstraints().addAll(col1_1,col1_2,col1_3);

                //sisuga täitmine
                Text tekst1 = new Text("Ülesannete haldamine");
                Text info1 = new Text("KT ülesannete laadimine failist.");
                Text pealkiri1 = new Text("Ülesannete faili nimi");
                TextField sisesta1 = new TextField();
                Text pealkiri2 = new Text("Ülesannete tüüp");
                ChoiceBox valik = new ChoiceBox();
                ObservableList<String> sisu = FXCollections.observableArrayList();
                sisu.addAll("Arvutusülesanne", "Tekstülesanne");
                valik.setItems(sisu);
                Button nupp1 = new Button("Failist laadimine");

                //osade lisamine ruudustikku
                grid1.add(tekst1,0,0);
                grid1.add(info1, 0, 1);
                grid1.add(pealkiri1,0,2);
                grid1.add(sisesta1,1,2);
                grid1.add(pealkiri2,0,3);
                grid1.add(valik,1,3);
                grid1.add(nupp1,2,4);

                //-------------------
                //Sisu võrgustik - Komplekteeri
                GridPane grid2 = new GridPane();
                grid2.setHgap(2);
                grid2.setVgap(5);                   //rea vahe laius
                grid2.setPrefWidth(500);
                //grid2.setGridLinesVisible(false); // ei näita võrgustikku
                grid2.setGridLinesVisible(true); // näitab ka võrgustikku
                grid2.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col2_1 = new ColumnConstraints();
                //col2_1.setPercentWidth(60);
                col2_1.setPrefWidth(200.0);
                ColumnConstraints col2_2 = new ColumnConstraints();
                //col2_2.setPercentWidth(20);
                col2_2.setPrefWidth(100.0);
                ColumnConstraints col2_3 = new ColumnConstraints();
                //col2_3.setPercentWidth(20);
                col2_3.setPrefWidth(100.0);
                grid2.getColumnConstraints().addAll(col2_1,col2_2,col2_3);

                //sisuga täitmine
                Text tekst2 = new Text("Komplekteeri");
                Text info2 = new Text("Ülesannete jagamine õpilastele");
                Text info3 = new Text("Uue komplekteerimise korral kirjutatakse andmed üle.");
                Text kiri1 = new Text("Ülesannete arv ühele õpilasele:");
                TextField sisse1 = new TextField();
                Text kiri2 = new Text("Vali algoritm");
                ChoiceBox valik2 = new ChoiceBox();
                ObservableList<String> sisu2 = FXCollections.observableArrayList();
                sisu2.addAll("JUHUSLIK", "KÕIK");
                valik2.setItems(sisu2);
                Button nupp2 = new Button("Genereeri");

                //osade lisamine ruudustikku
                grid2.add(tekst2,0,0);
                grid2.add(info2, 0, 1);
                grid2.add(info3,0,2);
                grid2.add(kiri1,0,3);
                grid2.add(sisse1,1,3);
                grid2.add(kiri2,0,4);
                grid2.add(valik2,1,4);
                grid2.add(nupp2,2,5);

                //-------------------
                //Sisu võrgustik - Tulem
                GridPane grid3 = new GridPane();
                grid3.setHgap(2);
                grid3.setVgap(5);                   //rea vahe laius
                grid3.setPrefWidth(500);
                //grid2.setGridLinesVisible(false); // ei näita võrgustikku
                grid3.setGridLinesVisible(true); // näitab ka võrgustikku
                grid3.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col3_1 = new ColumnConstraints();
                //col3_1.setPercentWidth(60);
                col3_1.setPrefWidth(150.0);
                ColumnConstraints col3_2 = new ColumnConstraints();
                //col3_2.setPercentWidth(20);
                col3_2.setPrefWidth(350.0);
                grid3.getColumnConstraints().addAll(col3_1,col3_2);

                //sisuga täitmine
                Text tekst3 = new Text("Tulemi vaatamine ja salvestamine");
                Text seletus1 = new Text("Variantide lehel on õpilaste nimed ja neile genereeritud ülesannete numbrid.");
                Button nupp3_1 = new Button("Salvesta 'variandid.txt'");
                Text seletus2 = new Text("Vastuste lehel on õpilaste loetelu ja nende ülesannete vastused");
                Button nupp3_2 = new Button("Salvesta 'vastused.txt'");
                Text seletus3 = new Text("Igale õpilasele tema nimeline fail, kus on ülesanded.");
                Button nupp3_3 = new Button("Salvesta õpilaste failid");

                //osade lisamine ruudustikku
                grid3.add(tekst3,0,0);
                grid3.add(nupp3_1, 0, 1);
                grid3.add(seletus1,1,1);
                grid3.add(nupp3_2,0,2);
                grid3.add(seletus2,1,2);
                grid3.add(nupp3_3,0,3);
                grid3.add(seletus3,1,3);

                //---------------------------
                //sisu võrgustikud üldisele võrgustikule
                grid.add(grid1,0,2);
                grid.add(grid2, 0, 3);
                grid.add(grid3,1,2);

                Scene stseen1 = new Scene(grid, 1100, 600, Color.SNOW);
                suurLava.setTitle("Generaator");
                suurLava.setResizable(true);
                suurLava.setScene(stseen1);
                suurLava.show();

            }
        });
    }
}
