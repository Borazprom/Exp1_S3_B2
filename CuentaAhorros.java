
package com.mycompany.bank_europe.cuentas;


public class CuentaAhorros extends CuentaBancaria {
    public CuentaAhorros(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public double calcularInteres() {
        return saldo * 0.03;     // 3% de interes
    }
}

