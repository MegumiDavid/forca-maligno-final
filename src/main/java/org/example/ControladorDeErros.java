package org.example;

public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax < 0)
            throw new Exception ("quantidade invalidade");
        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr == this.qtdMax)
            throw new Exception ("quantidade de erro invalido");
        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr == this.qtdMax)
            return true;

        return false;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        if(this.qtdMax != ((ControladorDeErros) obj).qtdMax) return false;
        if(this.qtdErr != ((ControladorDeErros) obj).qtdErr) return false;
        return true;
    }


    @Override
    public int hashCode ()
    {
        int ret = 635;

        ret = 7*ret + Integer.valueOf(this.qtdMax).hashCode();
        ret = 7*ret + Integer.valueOf(this.qtdErr).hashCode();

        if (ret<0) ret=-ret;

        return ret;
    }


    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        if (c == null)
            throw new Exception ("modelo ausente");

        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    public Object clone ()
    {
        ControladorDeErros ret = null;
        try
        {
            ret = new ControladorDeErros (this);
        }
        catch (Exception erro){ }
        return ret;
    }
}
