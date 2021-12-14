package tpoo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {
    private double limiteDaConta;
    
    public ContaCorrente(int numero, double saldo, Cliente dono, double limiteDaConta) {
        super(numero, saldo, dono);
        this.limiteDaConta = limiteDaConta;
    }
    
    @Override
    public boolean saca(double valor) {
        if (valor <= limiteDaConta) {
            super.saca(valor);
            return true;
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de saque não pode superar o limite da conta!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }
    
    @Override
    public void remunera() {
        double valor = this.getSaldo() * 0.01;
        this.deposita(valor);
    }
    
    public double getLimite() { return this.limiteDaConta; }
}
