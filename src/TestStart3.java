import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;

/**
 * Created by kersti on 03.06.17.
 */
public class TestStart3 extends Application{
    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
    @Override
    public void start(Stage peaLava) {

        //-------Esimene pealava--------

        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(5);
        grid.setGridLinesVisible(false); // ei näita võrgustikku
        grid.setPadding(new Insets(20, 10, 20, 10));    //Võrgustiku kaugus  servadest

        //Võrgustiku veergude laiused protsentides
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        grid.getColumnConstraints().addAll(col1, col2);

        //võrgustiku sisu
        Text tekst = new Text("Kontrolltöö variantide generaator");
        Text info = new Text("Projekti töökataloogis peab olema fail nimega 'nimekiri.txt'");
        Text pealkiri = new Text("Kontrolltöö pealkiri (sisesta ja vajuta ENTER)");
        TextField sisestaPealkiri = new TextField();    //pealkirja sisestamise tekstiväli
        Text jätaMeelde = new Text("");     //siia jäetakse meelde sisestatud pealkiri
        jätaMeelde.setVisible(false);

        //vajutatada ENTER
        sisestaPealkiri.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    jätaMeelde.setText("Pealkiri: " + sisestaPealkiri.getText());
                }
            }
        });

        //nupp Kontrolltöö loomiseks
        Button nupp0 = new Button("Loo uus kontrolltöö");

        //kui vajutatakse nuppu 'nupp0', sulgub see pealava ja avaneb teine
        nupp0.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
            public void handle(ActionEvent event) {
                peaLava.hide();
            }
        });

        //osade lisamine ruudustikku
        grid.add(tekst, 0, 0);
        grid.add(info, 0, 1);
        grid.add(pealkiri, 0, 2);
        grid.add(sisestaPealkiri, 1, 2);
        grid.add(nupp0, 1, 3);
        grid.add(jätaMeelde,0,3);   //algul on tühi

        Scene stseen1 = new Scene(grid, 600, 300, Color.SNOW);
        peaLava.setTitle("Generaator");
        peaLava.setResizable(true);
        peaLava.setScene(stseen1);
        peaLava.show();

        //-------Teine pealava------

        peaLava.setOnHiding(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent event) {

                //uus lava uue kujundusega
                Stage suurLava = new Stage();
                GridPane grid = new GridPane();
                grid.setPrefWidth(1100);
                grid.setHgap(2);
                grid.setVgap(5);
                grid.setGridLinesVisible(false); //võrgustikku ei näita
                grid.setPadding(new Insets(20, 10, 20, 10)); //Võrgustiku kaugus  servadest

                //Võrgustiku veergude laiuste määramine
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setPercentWidth(50);
                ColumnConstraints col2 = new ColumnConstraints();
                col2.setPercentWidth(50);
                grid.getColumnConstraints().addAll(col1, col2);

                //ümbritseva sisuga täitmine
                Text tekst = new Text("Suur Arvestustöö");
                Text info = new Text("Siia tekst, kui laadimine õnnestus!");    //muutmine puudu!
                Button nuppLõpeta = new Button("Lõpeta töö");

                //osade lisamine ruudustikku
                grid.add(tekst, 0, 0);
                grid.add(info, 0, 1);
                grid.add(nuppLõpeta, 1, 4);

                //kui vajutatakse lõpetamise nuppu, sulgub ka see pealava
                nuppLõpeta.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {
                        suurLava.hide();
                        //ja vaja veel, et mingi tagasiside oleks ka shell aknas!
                    }
                });

                //---------Sisemine ruudustik----------
                //Sisu võrgustik - Ülesannete haldamise osa

                GridPane grid1 = new GridPane();
                grid1.setHgap(2);
                grid1.setVgap(5);
                grid1.setPrefWidth(500);
                grid1.setGridLinesVisible(false); //ei näita võrgustikku
                grid1.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col1_1 = new ColumnConstraints();
                col1_1.setPrefWidth(200.0);                         //määran eelistatavad laiused
                ColumnConstraints col1_2 = new ColumnConstraints();
                col1_2.setPrefWidth(100.0);
                ColumnConstraints col1_3 = new ColumnConstraints();
                col1_3.setPrefWidth(100.0);
                grid1.getColumnConstraints().addAll(col1_1, col1_2, col1_3);

                //sisuga täitmine
                Text tekst1 = new Text("Ülesannete haldamine");
                Text info1 = new Text("Kontrolltöö ülesannete laadimine failist.");
                Text pealkiri1 = new Text("Ülesannete faili nimi (vajuta Enter)");
                TextField sisesta1 = new TextField();

                Text jätaMeelde1 = new Text("");     //siia tuleb sisestatud pealkiri
                jätaMeelde1.setVisible(false);

                // vaja meelde jätta sisestatud pealkiri! Vajutatakse ENTER
                sisesta1.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.ENTER) {
                            jätaMeelde1.setText(sisesta1.getText());
                            //jätaMeelde1.setVisible(true);
                        }
                    }
                });

                //valikuvariant ülesannete tüübiks
                Text pealkiri2 = new Text("Ülesannete tüüp");
                ChoiceBox valik = new ChoiceBox();
                ObservableList<String> sisu = FXCollections.observableArrayList();
                sisu.addAll("arvutusülesanne", "tekstülesanne");
                valik.setItems(sisu);

                Label tagasiside = new Label("");      //valiku meeldejätmiseks
                tagasiside.setVisible(false);               //algul pole nähtav, ainult kontrollimise eesmärgil praegu

                valik.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        tagasiside.setText(newValue);
                    }
                });

                //nupu vajutamise tegevus
                Button nupp1 = new Button("Failist laadimine");

                nupp1.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            Kontrolltöö kt = new Kontrolltöö();
                            kt.lisaFailistÜlesanded(String.valueOf(jätaMeelde1.getText()),tagasiside.getText().toString());
                        } catch (FileNotFoundException e) {
                            System.out.println("Sellist faili ei ole: " + String.valueOf(jätaMeelde1.getText()));
                        }
                    }
                });

                //osade lisamine ruudustikku
                grid1.add(tekst1,0,0);
                grid1.add(info1, 0, 1);
                grid1.add(pealkiri1,0,2);
                grid1.add(sisesta1,1,2);
                grid1.add(pealkiri2,0,3);
                grid1.add(valik,1,3);
                grid1.add(tagasiside,0,4);
                grid1.add(jätaMeelde1,1,4);
                grid1.add(nupp1,2,4);

                //---------Sisemine ruudustik----------
                //Sisu võrgustik - Komplekteeri
                GridPane grid2 = new GridPane();
                grid2.setHgap(2);
                grid2.setVgap(5);
                grid2.setPrefWidth(500);
                grid2.setGridLinesVisible(false); //ei näita võrgustikku
                grid2.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col2_1 = new ColumnConstraints();
                col2_1.setPrefWidth(200.0);
                ColumnConstraints col2_2 = new ColumnConstraints();
                col2_2.setPrefWidth(100.0);
                ColumnConstraints col2_3 = new ColumnConstraints();
                col2_3.setPrefWidth(100.0);
                grid2.getColumnConstraints().addAll(col2_1,col2_2,col2_3);

                //sisuga täitmine
                Text tekst2 = new Text("Komplekteeri");
                Text info2 = new Text("Ülesannete jagamine õpilastele");
                Text info3 = new Text("Uue komplekteerimise korral kirjutatakse andmed üle.");
                Text kiri1 = new Text("Ülesannete arv ühele õpilasele (vajuta ENTER): ");
                TextField sisse1 = new TextField();
                Text jätaMeelde2 = new Text("");     //siia tuleb sisestatud arv
                jätaMeelde2.setVisible(false);

                // vaja meelde jätta sisestatud arv! Vajutatakse ENTER
                sisse1.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.ENTER) {
                            jätaMeelde2.setText(sisse1.getText());
                        }
                    }
                });

                //valiku tegemine
                Text kiri2 = new Text("Vali algoritm");
                ChoiceBox valik2 = new ChoiceBox();
                ObservableList<String> sisu2 = FXCollections.observableArrayList();
                sisu2.addAll("JUHUSLIK", "KÕIK");
                valik2.setItems(sisu2);

                Label tagasiside2 = new Label("");      //see jätab meelde valiku
                tagasiside2.setVisible(false);

                valik2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        tagasiside2.setText(newValue);
                    }
                });

                Button nupp2 = new Button("Genereeri");

                //nupu 'genereeri' vajutamise tegevus
                nupp2.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            Kontrolltöö kt1 = new Kontrolltöö();
                            kt1.lisaFailistÜlesanded(String.valueOf(jätaMeelde1.getText()), tagasiside.getText().toString());
                            Variandid klass7a = new Variandid(String.valueOf(jätaMeelde.getText()));
                            klass7a.loeNimekiri();
                            klass7a.genereeriKõigile(kt1, String.valueOf(tagasiside2.getText()), Integer.parseInt(String.valueOf(jätaMeelde2.getText())));

                        } catch (FileNotFoundException e) {
                            System.out.println("Sellist faili ei ole: " + String.valueOf(jätaMeelde1.getText()));
                        }
                    }
                });

                //osade lisamine ruudustikku
                grid2.add(tekst2,0,0);
                grid2.add(info2, 0, 1);
                grid2.add(info3,0,2);
                grid2.add(kiri1,0,3);
                grid2.add(sisse1,1,3);
                grid2.add(kiri2,0,4);
                grid2.add(valik2,1,4);
                grid2.add(tagasiside2, 0, 5);
                grid2.add(jätaMeelde2,1,5);
                grid2.add(nupp2,2,5);

                //----------Sisemine võrgustik---------
                //Sisu võrgustik - Tulem

                GridPane grid3 = new GridPane();
                grid3.setHgap(2);
                grid3.setVgap(5);
                grid3.setPrefWidth(500);
                grid3.setGridLinesVisible(false); //ei näita võrgustikku
                grid3.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col3_1 = new ColumnConstraints();
                col3_1.setPrefWidth(150.0);
                ColumnConstraints col3_2 = new ColumnConstraints();
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

                nupp3_1.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            Kontrolltöö kt1 = new Kontrolltöö();
                            kt1.lisaFailistÜlesanded(String.valueOf(jätaMeelde1.getText()), tagasiside.getText().toString());
                            Variandid klass7a = new Variandid(String.valueOf(jätaMeelde.getText()));
                            klass7a.loeNimekiri();
                            klass7a.genereeriKõigile(kt1, String.valueOf(tagasiside2.getText()), Integer.parseInt(String.valueOf(jätaMeelde2.getText())));
                            klass7a.failidKõigile();
                            klass7a.failVariandid();
                            //shell aknasse veel vaja panna?

                        } catch (FileNotFoundException e) {
                            System.out.println("Sellist faili ei ole: " + String.valueOf(jätaMeelde1.getText()));
                        }
                    }
                });

                nupp3_2.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            Kontrolltöö kt1 = new Kontrolltöö();
                            kt1.lisaFailistÜlesanded(String.valueOf(jätaMeelde1.getText()), tagasiside.getText().toString());
                            Variandid klass7a = new Variandid(String.valueOf(jätaMeelde.getText()));
                            klass7a.loeNimekiri();
                            klass7a.genereeriKõigile(kt1, String.valueOf(tagasiside2.getText()), Integer.parseInt(String.valueOf(jätaMeelde2.getText())));
                            klass7a.failVastused();
                            //shell aknasse veel vaja panna?

                        } catch (FileNotFoundException e) {
                            System.out.println("Sellist faili ei ole: " + String.valueOf(jätaMeelde1.getText()));
                        }
                    }
                });

                nupp3_3.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            Kontrolltöö kt1 = new Kontrolltöö();
                            kt1.lisaFailistÜlesanded(String.valueOf(jätaMeelde1.getText()), tagasiside.getText().toString());
                            Variandid klass7a = new Variandid(String.valueOf(jätaMeelde.getText()));
                            klass7a.loeNimekiri();
                            klass7a.genereeriKõigile(kt1, String.valueOf(tagasiside2.getText()), Integer.parseInt(String.valueOf(jätaMeelde2.getText())));
                            klass7a.failidKõigile();
                            //shell aknasse veel vaja panna?

                        } catch (FileNotFoundException e) {
                            System.out.println("Sellist faili ei ole: " + String.valueOf(jätaMeelde1.getText()));
                        }
                    }
                });

                //osade lisamine ruudustikku
                grid3.add(tekst3,0,0);
                grid3.add(nupp3_1, 0, 1);
                grid3.add(seletus1,1,1);
                grid3.add(nupp3_2,0,2);
                grid3.add(seletus2,1,2);
                grid3.add(nupp3_3,0,3);
                grid3.add(seletus3,1,3);


                //------------Sisemiste võrgustike lisamine suurele võrgustikule---------------
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

