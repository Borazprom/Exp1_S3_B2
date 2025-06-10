
package com.mycompany.bank_europe;

import java.util.Scanner;
import com.mycompany.bank_europe.cliente.Cliente;
import com.mycompany.bank_europe.cuentas.*;

public class Bank_Europe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        int opcion;
        do {
            System.out.println("\n--- Menú Bank Europe ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Rut: ");
                    String rut = sc.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    String apPaterno = sc.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    String apMaterno = sc.nextLine();
                    System.out.print("Ingrese domicilio: ");
                    String domicilio = sc.nextLine();
                    System.out.print("Ingrese comuna: ");
                    String comuna = sc.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Ingrese número de cuenta: ");
                    int numeroCuenta = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Seleccione tipo de cuenta (1. Corriente, 2. Ahorro, 3. Digital): ");
                    int tipo = sc.nextInt();

                    CuentaBancaria cuenta = switch (tipo) {
                        case 1 -> new CuentaCorriente(numeroCuenta);
                        case 2 -> new CuentaAhorros(numeroCuenta);
                        case 3 -> new CuentaDigital(numeroCuenta);
                        default -> null;
                    };

                    if (cuenta != null) {
                        cliente = new Cliente(rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, cuenta);
                        System.out.println("¡Cliente registrado exitosamente!");
                    } else {
                        System.out.println("Tipo de cuenta inválido.");
                    }
                    break;
                case 2:
                    if (cliente != null) cliente.mostrarInformacionCliente();
                    else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 3:
                    if (cliente != null) {
                        System.out.print("Ingrese monto a depositar: ");
                        int deposito = sc.nextInt();
                        cliente.getCuenta().depositar(deposito);
                        System.out.println("¡Depósito realizado exitosamente!");
                        System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
                    } else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 4:
                    if (cliente != null) {
                        System.out.print("Ingrese monto a girar: ");
                        int giro = sc.nextInt();
                        cliente.getCuenta().girar(giro);
                        System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
                    } else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 5:
                    if (cliente != null)
                        System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
                    else System.out.println("Debe registrar un cliente primero.");
                    break;
                case 6:
                    System.out.println("¡Gracias por usar Bank Europe!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
