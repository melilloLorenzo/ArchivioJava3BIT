package ferramenta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melil
 */
public class Attrezzo {
    private String codice;
    private boolean batteria;
    private boolean corrente;
    private boolean manuale;
    private String nome;
    private int prezzo; // ho messo int così da non inserire numeri con la vircgola nel csv
    
public Attrezzo(String codice, boolean batteria, boolean corrente, boolean manuale, String nome, int prezzo)
    {
    this.codice=codice;
    this.batteria=batteria;
    this.corrente=corrente;
    this.manuale=manuale;
    this.nome=nome;
    this.prezzo=prezzo;
    }
public String getCodice()
    {
    return codice;
    }

public boolean getBatteria()
    {
    return batteria;
    }

public boolean getCorrente()
    {
    return corrente;
    }

public boolean getManuale()
    {
    return manuale;
    }

public String getNome()
    {
    return nome;
    }
public int getPrezzo()
    {
    return prezzo;
    }

public void setCodice(String codice)
    {
    this.codice=codice;
    }

public void setBatteria(boolean batteria)
    {
    this.batteria=batteria;
    }

public void setCorrente(boolean corrente)
    {
    this.corrente=corrente;
    }

public void setManuale(boolean manuale)
    {
    this.manuale=manuale;
    }

public void setNome(String nome)
    {
    this.nome=nome;
    }

public void setPrezzo(int prezzo)
    {
    this.prezzo=prezzo;
    }

@Override
public String toString()
    {
    String s;
    s=codice;
    s +=",";
    s +=Boolean.toString(batteria);
    s +=",";
    s +=Boolean.toString(corrente);
    s +=",";
    s +=Boolean.toString(manuale);
    s +=nome;
    s +=Integer.toString(prezzo);
    return s;
    }
}
