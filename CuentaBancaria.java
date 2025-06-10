
package com.mycompany.bank_europe.cuentas;

public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected int saldo;

    public CuentaBancaria(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0; 
    }

    public CuentaBancaria(int numeroCuenta, int saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("Monto inválido. Debe ser mayor que cero.");
        }
    }

    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= monto;
        }
    }

    public abstract double calcularInteres(); 
}

