import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;

/**
 * Created by kersti on 03.06.17.
 */
public class StartUI extends Application{
    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
    @Override
    public void start(Stage peaLava) {
        // loome üldised klasssi, millele töö käigus andmeid lisatakse
        Kontrolltöö ktÜlesanded = new Kontrolltöö();
        Variandid klass = new Variandid();

        //-------Esimene pealava--------


        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(10);
        grid.setGridLinesVisible(false); // ei näita võrgustikku
        grid.setPadding(new Insets(30, 30, 20, 30));    //Võrgustiku kaugus  servadest

        //Võrgustiku veergude laiused protsentides
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1, col2);

        //võrgustiku sisu
        Text tekst = new Text("Kontrolltöö variantide generaator");
        tekst.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        Text info = new Text("Projekti töökataloogis peab olema fail nimega 'nimekiri.txt'");
        Text pealkiri = new Text("Sisesta kontrolltöö pealkiri (vajuta ENTER):");
        TextField sisestaPealkiri = new TextField();    //pealkirja sisestamise tekstiväli
        Text jätaMeelde = new Text("");     //siia jäetakse meelde sisestatud pealkiri
        jätaMeelde.setVisible(true);

        //vajutatada ENTER see on endale kontrolliks.
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
        grid.add(tekst, 0, 0, 2,1);
        grid.setHalignment(tekst, HPos.CENTER);
        grid.add(info, 0, 1,2,1);
        grid.setHalignment(info, HPos.CENTER);
        grid.add(pealkiri, 0, 3);
        grid.setHalignment(pealkiri, HPos.RIGHT);
        grid.add(sisestaPealkiri, 1, 3);
        grid.setHalignment(sisestaPealkiri, HPos.LEFT);
        grid.add(nupp0, 1, 4);
        grid.add(jätaMeelde,0,4);   //algul on tühi

        Scene stseen1 = new Scene(grid, 600, 300, Color.SNOW);
        peaLava.setTitle("Generaator");
        peaLava.setResizable(true);
        peaLava.setScene(stseen1);
        peaLava.show();

        //-------Teine pealava------

        peaLava.setOnHiding(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent event) {

                // alustame sellest, et loome klassi, eelmisel lehel antud nimega
                Variandid klass = new Variandid(sisestaPealkiri.getText());
                try {
                    klass.loeNimekiri();
                    System.out.println("Imporditud: " + klass);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                //uus lava uue kujundusega
                Stage suurLava = new Stage();
                GridPane grid = new GridPane();
                grid.setPrefWidth(1050);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setGridLinesVisible(false); //võrgustikku ei näita
                grid.setPadding(new Insets(20, 20, 20, 20)); //Võrgustiku kaugus  servadest

                //Võrgustiku veergude laiuste määramine
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setPercentWidth(50);
                ColumnConstraints col2 = new ColumnConstraints();
                col2.setPercentWidth(50);
                grid.getColumnConstraints().addAll(col1, col2);

                //ümbritseva sisuga täitmine
                Text tekst = new Text(sisestaPealkiri.getText());
                tekst.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                Text info = new Text("Siia tekst, kui laadimine õnnestus!");    //muutmine puudu!
                Button nuppLõpeta = new Button("Lõpeta töö");

                //osade lisamine ruudustikku
                grid.add(tekst, 0, 0, 2,1);
                grid.setHalignment(tekst, HPos.CENTER);
                grid.add(info, 0, 1, 2,1 );
                grid.setHalignment(info, HPos.CENTER);
                grid.add(nuppLõpeta, 1, 4);
                grid.setHalignment(nuppLõpeta, HPos.RIGHT);

                //kui vajutatakse lõpetamise nuppu, sulgub ka see pealava
                nuppLõpeta.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {
                        suurLava.hide();
                        System.out.println("Head päeva");
                    }
                });

                //---------Sisemine ruudustik----------
                //Sisu võrgustik - Ülesannete haldamise osa

                GridPane grid1 = new GridPane();
                grid1.setHgap(10);
                grid1.setVgap(10);
                grid1.setPrefWidth(500.0);
                grid1.setGridLinesVisible(false); //ei näita võrgustikku
                grid1.setPadding(new Insets(10, 0, 10, 0)); //Võrgustiku kaugus  servadest

                ColumnConstraints col1_1 = new ColumnConstraints();
                col1_1.setPrefWidth(290.0);                         //määran eelistatavad laiused
                ColumnConstraints col1_2 = new ColumnConstraints();
                col1_2.setPrefWidth(200.0);
//                ColumnConstraints col1_3 = new ColumnConstraints();
//                col1_3.setPrefWidth(100.0);
                grid1.getColumnConstraints().addAll(col1_1, col1_2);

                //sisuga täitmine
                Text tekst1 = new Text("Ülesannete haldamine");
                tekst1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                Text info1 = new Text("Kontrolltöö ülesannete laadimine failist.");
                Text pealkiri1 = new Text("Ülesannete faili nimi (vajuta Enter)");
                TextField sisesta1 = new TextField();

                Text jätaMeelde1 = new Text("");     //siia tuleb sisestatud pealkiri
                jätaMeelde1.setVisible(true);

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
                tagasiside.setVisible(true);               //algul pole nähtav, ainult kontrollimise eesmärgil praegu

                valik.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        tagasiside.setText(newValue);
                    }
                });
                //nupu vajutamise tegevus
                Button nupp1 = new Button("Failist laadimine");
                // ---- nupu 1 lõpp
                 nupp1.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            // siin on ainult failide lisamine. ktÜlesanded on loodud rakenduse avamisel
                            ktÜlesanded.lisaFailistÜlesanded(String.valueOf(jätaMeelde1.getText()),tagasiside.getText().toString());
                            System.out.println("Lisasin ülesandeid juurde failist "+ String.valueOf(jätaMeelde1.getText()));
                            System.out.println(ktÜlesanded);
                        } catch (FileNotFoundException e) {
                            System.out.println("Sellist faili ei ole: " + String.valueOf(jätaMeelde1.getText()));
                        }
                    }
                });

                //osade lisamine ruudustikku
                grid1.add(tekst1,0,0,2,1 );
                //info1.setFill(Color.DARKSLATEBLUE);
                grid1.add(info1, 0, 1, 2,1 );
                grid1.add(pealkiri1,0,2);
                grid1.setHalignment(pealkiri1, HPos.RIGHT);
                grid1.add(sisesta1,1,2);
                grid1.add(pealkiri2,0,3);
                grid1.setHalignment(pealkiri2, HPos.RIGHT);
                grid1.add(valik,1,3);
                grid1.add(tagasiside,0,4);
                grid1.add(jätaMeelde1,0,5);
                grid1.add(nupp1,1,4);
                grid1.setHalignment(nupp1, HPos.RIGHT);


                //---------Sisemine ruudustik----------
                //Sisu võrgustik - Komplekteeri
                GridPane grid2 = new GridPane();
                grid2.setHgap(10);
                grid2.setVgap(10);
                grid2.setPrefWidth(500);
                grid2.setGridLinesVisible(false); //ei näita võrgustikku
                grid2.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col2_1 = new ColumnConstraints();
                col2_1.setPrefWidth(290.0);
                ColumnConstraints col2_2 = new ColumnConstraints();
                col2_2.setPrefWidth(200.0);
//                ColumnConstraints col2_3 = new ColumnConstraints();
//                col2_3.setPrefWidth(100.0);
                grid2.getColumnConstraints().addAll(col2_1,col2_2);

                //sisuga täitmine
                Text tekst2 = new Text("Komplekteeri");
                tekst2.setFont(Font.font("Arial", FontWeight.BOLD, 16));

                Text info2 = new Text("Ülesannete jagamine õpilastele");
                Text info3 = new Text("Uue komplekteerimise korral kirjutatakse andmed üle.");
                Text kiri1 = new Text("Ülesannete arv ühele õpilasele(vajuta ENTER): ");
                TextField sisse1 = new TextField();
                Text jätaMeelde2 = new Text("");     //siia tuleb sisestatud arv
                jätaMeelde2.setVisible(true);

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
                valik2.setPrefWidth(120.0);

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
                        klass.genereeriKõigile(ktÜlesanded, String.valueOf(tagasiside2.getText()), Integer.parseInt(String.valueOf(jätaMeelde2.getText())));
                        klass.kuvaVariandid();
                        System.out.println("Genereerisin eespool toodud variandid");

                    }
                });

                //osade lisamine ruudustikku
                grid2.add(tekst2,0,0);
                grid2.add(info2, 0, 1);
                grid2.add(info3,0,2);
                grid2.add(kiri1,0,3);
                grid2.add(sisse1,1,3);
                grid2.add(kiri2,0,4);
                grid2.setHalignment(kiri2, HPos.RIGHT);
                grid2.add(valik2,1,4);
                grid2.add(tagasiside2, 0, 5);
                grid2.add(jätaMeelde2,1,5);
                grid2.add(nupp2,1,5);
                grid2.setHalignment(nupp2, HPos.RIGHT);

                //----------Sisemine võrgustik---------
                //Sisu võrgustik - Tulem

                GridPane grid3 = new GridPane();
                grid3.setHgap(10);
                grid3.setVgap(10);
                grid3.setPrefWidth(500);
                grid3.setGridLinesVisible(false); //ei näita võrgustikku
                grid3.setPadding(new Insets(10, 10, 10, 10)); //Võrgustiku kaugus  servadest

                ColumnConstraints col3_1 = new ColumnConstraints();
                col3_1.setPrefWidth(120.0);
                ColumnConstraints col3_2 = new ColumnConstraints();
                col3_2.setPrefWidth(370.0);
                grid3.getColumnConstraints().addAll(col3_1,col3_2);

                //sisuga täitmine
                Text tekst3 = new Text("Tulemi vaatamine ja salvestamine");
                tekst3.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                Label seletus1 = new Label("Variantide lehel on õpilaste nimed ja neile genereeritud ülesannete numbrid.");
                seletus1.setWrapText(true);
                Button nupp3_1 = new Button("Salvesta \nvariandid.txt'");
                //nupp3_1.setWrapText(true);
                Label seletus2 = new Label("Vastuste lehel on õpilaste loetelu ja nende ülesannete vastused");
                seletus2.setWrapText(true);
                Button nupp3_2 = new Button("Salvesta \n'vastused.txt'");
                //nupp3_2.setWrapText(true);
                Label seletus3 = new Label("Igale õpilasele tema nimeline fail, kus on ülesanded.");
                seletus3.setWrapText(true);
                Button nupp3_3 = new Button("Salvesta \nõpilaste failid");
                //nupp3_3.setWrapText(true);

                nupp3_1.setOnAction(new EventHandler<ActionEvent>() {     //variantide trükkimine
                    public void handle(ActionEvent event) {

                        try {
                            klass.failVariandid();
                            klass.kuvaVariandid();
                            System.out.println("Salvestasin eespool toodud variandid");
                        } catch (FileNotFoundException e) {
                            System.out.println("Faili viga variantide kirjutamisel");
                        }
                    }
                });

                nupp3_2.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {

                        try {
                            klass.failVastused();
                            klass.kuvaVastused();
                            System.out.println("Salvestasin eespool toodud vastused");
                        } catch (FileNotFoundException e) {
                            System.out.println("Faili viga vastuste kirjutamisel");
                        }
                    }
                });

                nupp3_3.setOnAction(new EventHandler<ActionEvent>() {     //kui vajutatakse nuppu, läheb pealava peitu
                    public void handle(ActionEvent event) {
                        try {
                            klass.failidKõigile();
                            System.out.println("Trükkisin kõigle failid kataloogi 'koostatud'");
                        } catch (FileNotFoundException e) {
                            System.out.println("Faili viga õpilaste failide kirjutamisel");
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

