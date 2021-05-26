/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramenta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author melil
 */
public class Ferramenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
    Archivio archivio;
    archivio = new Archivio();
    Scanner tastiera;
    tastiera = new Scanner(System.in);
    int menù;
    menù = 0;
    do
        {
        System.out.println("=======================");
        System.out.println("***Archivio Attrezzi***");
        System.out.println("1) Visualizza elenco articoli");
        System.out.println("2) Inserisci articolo");
        System.out.println("3) Elimina articolo");
        System.out.println("4) Cerca articolo in base al prezzo");
        System.out.println("5) Cerca articolo in base al nome");
        System.out.println("6) Modifica articolo");
        System.out.println("7) Esci");
        menù  = Integer.parseInt(tastiera.nextLine());
        
        switch(menù)
            {
        case 1:
            ArrayList<Attrezzo> elencoAttrezzi;
            elencoAttrezzi = archivio.elencoAttrezzi();
            
            visualizzaElencoAttrezzi(elencoAttrezzi);
        break;
        case 2:
            /*System.out.print("Inserisci il codice: ");
            String codice = tastiera.nextLine();
            System.out.print("Inseresci se alimentato a batteria(scrivi true o false):");
            String batteriaString = "";
            boolean batteria = Boolean.parseBoolean(batteriaString);
            System.out.print("Inseresci se alimentato a corrente(scrivi true o false):");
            String correnteString = "";
            boolean corrente = Boolean.parseBoolean(correnteString);
            System.out.print("Inseresci se manuale(scrivi true o false):");
            String manualeString = "";
            boolean manuale = Boolean.parseBoolean(manualeString);
            System.out.print("Inserisci la nome: ");
            String nome = tastiera.nextLine();
            System.out.print("Inserisci il prezzo: ");
            int prezzo = Integer.parseInt(tastiera.nextLine());*/
            
            System.out.print("Inserisci il codice: ");
            String codice = tastiera.nextLine();
            System.out.print("Inseresci se alimentato a batteria(scrivi true o false):");
            boolean batteria = tastiera.nextBoolean(); //Boolean.parseBoolean(batteriaString);
            System.out.print("Inseresci se alimentato a corrente(scrivi true o false):");
            boolean corrente = tastiera.nextBoolean();//Boolean.parseBoolean(correnteString);
            System.out.print("Inseresci se manuale(scrivi true o false):");
            boolean manuale = tastiera.nextBoolean();//Boolean.parseBoolean(manualeString);
            System.out.print("Inserisci la nome: ");
            String nome = tastiera.nextLine();
            System.out.print("Inserisci il prezzo: ");
            int prezzo = tastiera.nextInt();//Integer.parseInt(tastiera.nextLine());
            
            Attrezzo attrezzo = new Attrezzo(codice, batteria, corrente, manuale, nome, prezzo);
            if (archivio.aggiungi(attrezzo)) {
            System.out.print("Articolo inserito correttamente");
            } else {
            System.out.print("Esiste gia un articolo con lo stesso codice !");
            }
        break;
        case 3:      
            System.out.print("Inserisci il codice: ");
            codice = tastiera.nextLine();        
            if (archivio.elimina(codice)) {
            System.out.println("Articolo eliminato correttamente.");
            } else {
            System.out.println("Eliminazione non riuscita.");
            }
        break;
        case 4:
            System.out.print("Inserisci il prezzo minimo: ");
            int prezzoMinimo = Integer.parseInt(tastiera.nextLine());
            System.out.print("Inserisci il prezzo massimo: ");
            int prezzoMassimo = Integer.parseInt(tastiera.nextLine());
            elencoAttrezzi = archivio.cercaArticolo(prezzoMinimo, prezzoMassimo);
            visualizzaElencoAttrezzi(elencoAttrezzi);
        break;
        case 5:
            System.out.print("Inserisci il nome: ");
            nome = tastiera.nextLine();
            elencoAttrezzi = archivio.cercaAttrezzoPerNome(nome);
            visualizzaElencoAttrezzi(elencoAttrezzi);
        break;
        case 6:
            System.out.print("Inserisci il codice: ");
            codice = tastiera.nextLine();
            System.out.print("Inseresci se alimentato a batteria(scrivi true o false):");
            batteria = tastiera.nextBoolean();
            System.out.print("Inseresci se alimentato a corrente(scrivi true o false):");
            corrente = tastiera.nextBoolean();
            System.out.print("Inseresci se manuale(scrivi true o false):");
            manuale = tastiera.nextBoolean();
            System.out.print("Inserisci la nome: ");
            nome = tastiera.nextLine();
            System.out.print("Inserisci il prezzo: ");
            prezzo = tastiera.nextInt();
            if (archivio.modificaAttrezzo(codice, batteria, corrente, manuale, nome, prezzo)) {
                System.out.println("Modifica moto avvenuta correttamente.");
            } else {
                System.out.println("Non è stato possibile modificare la moto.");
            }
        break;
        }
        }    
    while(menù != 7);
    }

private static void visualizzaElencoAttrezzi(ArrayList<Attrezzo> elencoAttrezzi) 
{
    System.out.println("N°\tCodice\tDescrizione\t\t\tQuantità\tPrezzo");
    for (int i = 0; i < elencoAttrezzi.size(); i++) {
      System.out.print(i + 1);
      System.out.print("\t" + elencoAttrezzi.get(i).getCodice());
      System.out.print("\t" + elencoAttrezzi.get(i).getBatteria());
      System.out.print("\t" + elencoAttrezzi.get(i).getCorrente());
      System.out.print("\t\t" + elencoAttrezzi.get(i).getManuale());
      System.out.print("\t\t" + elencoAttrezzi.get(i).getNome());
      System.out.print("\t\t" + elencoAttrezzi.get(i).getPrezzo());
    }
}

