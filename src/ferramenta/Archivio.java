package ferramenta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melil
 */
public class Archivio {
private ArrayList<Attrezzo> archivio;
    
public Archivio()
    {
    archivio=leggiDaFile();
    }
private ArrayList<Attrezzo> leggiDaFile()
    {
    ArrayList<Attrezzo> attrezzi;
    attrezzi = new ArrayList();    
        try {
            
            
            FileReader fileReader;
            fileReader = new FileReader("Archivio.csv");
            
            BufferedReader in;
            in = new BufferedReader(fileReader);
            
            String riga;
            String campi[];
            try {
                riga = in.readLine();
                while((riga = in.readLine()) != null)
                {
                    campi = riga.split(",");
                    String codice = campi[0];
                    boolean batteria= Boolean.parseBoolean(campi [1]);
                    boolean corrente = Boolean.parseBoolean(campi[2]);
                    boolean manuale = Boolean.parseBoolean(campi[3]);
                    String nome = campi[4];
                    int prezzo = Integer.parseInt(campi[5]);
                    
                    Attrezzo attrezzo = new Attrezzo(codice, batteria, corrente, manuale, nome, prezzo);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        }
    return attrezzi;
    }
@Override
public String toString()
    {
    String stringa="";
    
    for (int i=0; i<archivio.size(); i++)
        {
        Attrezzo attrezzo;
        attrezzo = archivio.get(i);
        stringa += attrezzo.toString();
        stringa += "\r\n";
        }
    return stringa;
    }

public ArrayList<Attrezzo> elencoAttrezzi()
    {
    return archivio;
    }

private Attrezzo cercaAttrezzo(String codice)
    {
    for(int i=0; i<archivio.size(); i++)
        {
        if(archivio.get(i).getCodice().equals(codice))
            {
            return archivio.get(i);
            }
        }
    return null;
    }

public boolean elimina(String codice)
    {
    Attrezzo attrezzo;
    attrezzo = Archivio.this.cercaAttrezzo(codice);
    
    if (attrezzo != null)
        {
        archivio.remove(attrezzo);
        salvaSuFile();
        return true;
        }
    return false;
    }

public void salvaSuFile()
    {
        try {
            FileWriter out;
            out = new FileWriter("Archivio.csv");
            String sArchivio;
            sArchivio = toString();
            
            out.write(sArchivio);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

public boolean aggiungi(Attrezzo attrezzo)
    {
    if(Archivio.this.cercaAttrezzo(attrezzo.getCodice()) != null)
        {
        return false;
        }
    archivio.add(attrezzo);
    salvaSuFile();
    return true;
    }

public boolean modificaAttrezzo(String codice, boolean batteria, boolean corrente, boolean manuale, String nome, int prezzo)
    {
    Attrezzo attrezzo;
    attrezzo = Archivio.this.cercaAttrezzo(codice);
    if (attrezzo != null)
        {
        attrezzo.setBatteria(batteria);
        attrezzo.setCorrente(corrente);
        attrezzo.setManuale(manuale);
        attrezzo.setNome(nome);
        attrezzo.setPrezzo(prezzo);
        
        salvaSuFile();
        return true;
        }
    else
        {
        return false;
        }
    }

public ArrayList<Attrezzo> cercaArticolo(int prezzoMinimo, int prezzoMassimo)
    {
    ArrayList<Attrezzo> attrezziTrovati = new ArrayList(0);
    
    for (int i=0; i<archivio.size(); i++)
        {
        if (archivio.get(i).getPrezzo() <= prezzoMinimo && archivio.get(i).getPrezzo() <= prezzoMassimo )
            {
            
            attrezziTrovati.add(archivio.get(i));
            }
        
        }
    return attrezziTrovati;
    }

public ArrayList<Attrezzo> cercaAttrezzoPerNome(String nome)
    {
    ArrayList<Attrezzo> attrezziTrovati;
    attrezziTrovati = new ArrayList(0);
    
    String nomeDaCercareMinuscolo = nome.toLowerCase();
    
    for(int i=0; i <archivio.size() ; i++)
        {
        String nomeMaiuscolo = archivio.get(i).getNome().toLowerCase();
        
        if(nomeMaiuscolo.contains(nomeDaCercareMinuscolo))
            {
            attrezziTrovati.add(archivio.get(i));
            }
        }
    return attrezziTrovati;
    }

}
