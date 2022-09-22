package org.example;

public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if (qtd < 0)
            throw new Exception ("quantidade invalidade");

        this.texto = new char[qtd];
        for (int i = 0; i<qtd; i++)
            this.texto[i] = '_';

    }

    public void revele (int posicao, char letra) throws Exception
    {
        if (posicao < 0 || posicao >= this.texto.length)
            throw new Exception ("posicao invalida");

        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for (int i = 0; i<this.texto.length; i++)
        {
            if (this.texto[i] == '_')
                return true;
        }
        return false;
    }

    @Override
    public String toString ()
    {
        String str = "";
        for (int i = 0; i<this.texto.length; i++)
        {
            str = str + this.texto[i];
            str = str + ' ';
        }
        return str;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        for (int i = 0 ; i<this.texto.length; i++)
            if(this.texto[i] != ((Tracinhos) obj).texto[i]) return false;
        return true;
    }


    public int hashCode ()
    {
        int ret = 222;

        for (int i= 0; i<this.texto.length; i++)
            ret = 7*ret + Character.valueOf(this.texto[i]).hashCode();

        if (ret<0) ret=-ret;

        return ret;
    }


    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        if (t == null)
            throw new Exception ("modelo ausente");

        this.texto = new char[t.texto.length];
        System.arraycopy(t.texto, 0, this.texto, 0, this.texto.length);

    }

    public Object clone ()
    {
        Tracinhos ret = null;
        try
        {
            ret = new Tracinhos (this);
        }
        catch (Exception erro)
        { }
        return ret;
    }

}
