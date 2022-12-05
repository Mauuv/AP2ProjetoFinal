//Maurício Log em pdf
//Alysson fez a tela inicial

package com.example.demo;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import com.itextpdf.text.DocumentException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class BigBomAplication extends Application {

    private static Document document;
    @Override
    public void start(Stage st) throws IOException {
        try{
            FXMLLoader fx = new FXMLLoader(BigBomAplication.class.getResource("InitView.fxml"));
            Scene scene = new Scene(fx.load());
            st.setTitle("BIG BOM!");
            st.setScene(scene);
            st.show();
        } catch (IOException e) {
            addLog(e.getMessage());
        }
    }

    public static boolean addLog(String log) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            document.add(new Paragraph("Momento do erro: "  + formatter.format(calendar.getTime()) + System.lineSeparator() + log));
            return true;
        } catch (DocumentException e) {
            e.printStackTrace();
            addLog(e.getMessage());
            return false;
        } catch (NullPointerException e) {
            e.getMessage();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            document = new Document();
            FileOutputStream os = new FileOutputStream("Log.pdf");
            PdfWriter.getInstance(document, os);
            document.open();
            launch(args);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            addLog(e.getMessage());
        } catch (DocumentException e) {
            e.printStackTrace();
            addLog(e.getMessage());
        }
        try {
            document.add(new Paragraph("Fim"));
            document.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
