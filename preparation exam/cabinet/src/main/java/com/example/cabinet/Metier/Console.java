package com.example.cabinet.Metier;

import com.example.cabinet.Model.Medecin;
import com.example.cabinet.Model.Patient;
import com.example.cabinet.Singleton.SingletonConnexionDb;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Console {
    public static void main(String[] args) throws ParseException {
        Connection connection=  SingletonConnexionDb.getConnexion();
        ICabinetMetier metier= new CabinetMetierImpl();
        System.out.println(metier.getMedecins());








    }


}
