/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.DetailsCommande;
import model.DetailsPaiement;
import model.Plat;

/**
 *
 * @author Vola
 */
public class main {
    public static void main(String[] args) throws Exception {
//        DetailsCommande dc = new DetailsCommande();
//        dc.setIdCommande("huhu1");
//        dc.valider();
        DetailsPaiement[] d = new DetailsPaiement().getPaiement("2022-04-05", "2022-04-10");
        for(DetailsPaiement det: d) {
            System.out.println(det.getDatePaiement() + " " + det.getNomTypePaiement() + " " + det.getSommePaiement());
        }
    }
}
