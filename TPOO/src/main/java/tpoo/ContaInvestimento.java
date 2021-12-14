package tpoo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContaInvestimento extends Conta {
    private double depositoMinimo;
    private double montanteMinimo;
    
    public ContaInvestimento(int numero, double saldo, Cliente dono, double depositoMinimo, double montanteMinimo) {
        super(numero, saldo, dono);
        this.depositoMinimo = depositoMinimo;
        this.montanteMinimo = montanteMinimo;
    }
    
    @Override
    public boolean deposita(double valor) {
        if (valor >= depositoMinimo) {
            super.deposita(valor);
            return true;
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de depósito não pode ser menor que o depósito mínimo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean saca(double valor) {
        double saldoTeste = this.getSaldo();
        saldoTeste -= valor;
        
        if (saldoTeste >= montanteMinimo) {
            super.saca(valor);
            return true;
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de saque não pode tornar o saldo menor que o montante mínimo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    @Override
    public void remunera() {
        double valor = this.getSaldo() * 0.02;
        this.deposita(valor);
    }
    
    public double getDepositoMinimo() { return this.depositoMinimo; }
    public double getMontanteMinimo() { return this.montanteMinimo; }
}
