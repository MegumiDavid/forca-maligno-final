package org.example;

public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        for (int i=0; i<this.letrasJaDigitadas.length(); i++)
        {
            if (this.letrasJaDigitadas.charAt(i) == letra)
                return true;
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
        if (isJaDigitada(letra))
            throw new Exception ("letra invalida");

        this.letrasJaDigitadas = this.letrasJaDigitadas + letra;
    }

    @Override
    public String toString ()
    {
        String str = "";
        for (int i=0; i<this.letrasJaDigitadas.length(); i++)
        {
            str = str + this.letrasJaDigitadas.charAt(i);
            if (i != (this.letrasJaDigitadas.length() - 1))
                str = str +  ", ";
        }
        return str;
    }

    public boolean equals (Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        if(this.letrasJaDigitadas != ((ControladorDeLetrasJaDigitadas) obj).letrasJaDigitadas) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 672;

        if (this.letrasJaDigitadas!=null)
            ret = 7*ret + this.letrasJaDigitadas.hashCode();

        if (ret<0) ret=-ret;

        return ret;
    }


    public ControladorDeLetrasJaDigitadas(
            ControladorDeLetrasJaDigitadas c)
            throws Exception // construtor de cópia
    {
        if (c == null)
            throw new Exception ("modelo ausente");
        this.letrasJaDigitadas = c.letrasJaDigitadas;
    }

    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas ret = null;
        try
        {
            ret = new ControladorDeLetrasJaDigitadas (this);
        }
        catch (Exception erro){ }

        return ret;
    }
}
