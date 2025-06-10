package com.mycompany.bank_europe.cuentas;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public double calcularInteres() {
        return saldo * 0.01; // 1% de inters
    }
}
