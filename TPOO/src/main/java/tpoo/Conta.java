package tpoo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class Conta implements ContaI{
    private int numero;
    private double saldo;
    private Cliente dono;
    
    public Conta(int numero, double saldo, Cliente dono) {
        this.numero = numero;
        this.saldo = saldo;
        this.dono = dono;
    }
    
    @Override
    public boolean deposita(double valor) {
        if (valor < 0) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de depósito não pode ser negativo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        this.saldo += valor;
        return true;
    }

    @Override
    public boolean saca(double valor) {
        if (valor < 0) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de saque não pode ser negativo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        this.saldo -= valor;
        return true;
    }

    @Override
    public Cliente getDono() { return this.dono; }

    @Override
    public int getNumero() { return this.numero; }

    @Override
    public double getSaldo() { return this.saldo; }
    
    public void setSaldo(double valor) { this.saldo = valor; }

    @Override
    public abstract void remunera();
}
