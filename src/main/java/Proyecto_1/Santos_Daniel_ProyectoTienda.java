/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Proyecto_1;

/**
 *
 * @author Hp
 */

import java.util.Scanner;

public class Santos_Daniel_ProyectoTienda {
    
    
    static double Caja = 0.00;
    static double Limite_Caja = 20000.00;
    static int Codigo_producto = 0;
    static int NumeroVentas = 0;
    static int NumeroCompras = 0;
    static double TotalVentas = 0.00;
    static double TotalCompras = 0.00;
    static double MaxVentaGanancia = 0.00;
    static double MaxCompraGasto = 0.00;
    static double CantidadCompra = 0;
    static int CantidadAzucarVendida = 0;
    static int CantidadAvenaVendida = 0;
    static int CantidadTrigoVendida = 0;
    static int CantidadMaizVendida = 0;
    static boolean CajaCerrada = false;
    static boolean CajaAbierta = false;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        
        int Opcion;
        
        //Produtos a vender y comprar
        String ProductoAzucar = "Azucar";
        double PrecioAzucar_venta = 30.0;
        double PrecioAzucar_compra = 25.0;
        int CantidadAzucar = 0;
        
        String ProductoAvena = "Avena";
        double PrecioAvena_venta = 25.0;
        double PrecioAvena_compraB = 20.0;
        double PrecioAvena_compraC = 22.0;
        int CantidadAvena = 0;
        
        String ProductoTrigo = "Trigo";
        double PrecioTrigo_venta = 32.0;
        double PrecioTrigo_compra = 30.0;
        int CantidadTrigo = 0;
        
        String ProductoMaiz = "Maiz";
        double PrecioMaiz_venta = 20.0;
        double PrecioMaiz_compra = 18.0;
        int CantidadMaiz = 0;
            
        do {    
            System.out.println("\r                                                                                                                                                                          ");
            System.out.println("**** Menu Principal ****");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");
            System.out.println("\r                                                                                                                                                                          ");
            System.out.print("Bienvenido al menu principal, por favor ingrese el numero de una de las opciones para proseguir: ");
            Opcion = scanner.nextInt();
            System.out.println("\r                                                                                                                ");
            
            switch(Opcion) {
                case 1:
                    //Parte de Abrir Caja
                    if (CajaCerrada) {
                        System.out.println("Caja reabierta con: Lps. " + Caja);
                        CajaCerrada = false;
                    } else if (Caja <= 0) {
                        System.out.println("Ingrese la cantidad de dinero que quiere sumar a la caja");
                        double DineroCaja = scanner.nextDouble();

                        if (DineroCaja <= 0) {
                            System.out.println("La cantidad a ingresar en la caja tiene que ser mayor a 0, por favor vuelva a introducir la cantidad de dinero que quiere sumarle a la caja ");
                        } else if (DineroCaja + Caja > Limite_Caja) {
                            System.out.println("Esta cantidad excede el limite impuesto a la caja, el limite es de: Lps. " + Limite_Caja);
                        } else {
                            Caja += DineroCaja;
                            Caja = Math.round(Caja * 100.0) / 100.0;
                            System.out.println("Caja abierta con Lps. " + String.format("%.2f", Caja));
                            CajaAbierta = true;
                        }
                    } else {
                        System.out.println("La caja ya esta abierta con: Lps. " + String.format("%.2f", Caja));
                    }
                    
                    
                    break;
                    
                case 2:
                    //Parte de Ventas
                    if (!CajaAbierta) {
                        System.out.println("No se puede hacer Ventas sin abrir la caja!");
                    } else if (CajaCerrada) {
                        System.out.println("No se puede hacer ninguna venta si la caja esta cerrada!");
                        break;
                    } else if (CantidadAzucar <= 0 && CantidadAvena <= 0 && CantidadTrigo <= 0 && CantidadMaiz <= 0) {
                        System.out.println("Tiene que hacer una Compra a algun proveedor para poder hacer una Venta!");
                        break;
                    } else {
                        boolean OtraVenta = true;
                        boolean ClienteValido = false;
                        String Tipo_cliente = "";
                            
                        while(!ClienteValido) {
                            System.out.print("Ingrese el tipo de cliente que es (A, B, C): ");
                            Tipo_cliente = scanner.next().toUpperCase();

                            switch(Tipo_cliente) {
                                case "A":
                                    System.out.println("Cliente de tipo A: puede comprar cualquier producto.");
                                    ClienteValido = true;
                                    break;
                                case "B":
                                    System.out.println("Cliente de tipo B: puede comprar productos con codigos 1, 2, y 3.");
                                    ClienteValido = true;
                                    break;
                                case "C":
                                    System.out.println("Cliente de tipo C: puede comprar solo el producto con codigo 4.");
                                    ClienteValido = true;
                                    break;
                                default:
                                    System.out.println("Tipo de cliente no identificado, por favor vuelva a escribirlo.");
                                    break;
                            }
                        }
                            

                        int TotalCantidadAzucar = 0;
                        int TotalCantidadAvena = 0;
                        int TotalCantidadTrigo = 0;
                        int TotalCantidadMaiz = 0;
                        double TotalVentaCliente = 0;
                        double GananciaVentaCliente = 0;

                        while (OtraVenta) {
                            Codigo_producto = 0;
                            boolean CodigoValido = false;

                            System.out.println("----------------------------------");
                            System.out.println("|       Tabla de Productos       |");
                            System.out.println("----------------------------------");
                            System.out.println("| 1. Azucar           Lps. 30.00 |");
                            System.out.println("----------------------------------");
                            System.out.println("| 2. Avena            Lps. 25.00 |");
                            System.out.println("----------------------------------");
                            System.out.println("| 3. Trigo            Lps. 32.00 |");
                            System.out.println("----------------------------------");
                            System.out.println("| 4. Maiz             Lps. 20.00 |");
                            System.out.println("----------------------------------");

                            int CantidadCompra = 0;
                            
                            while (!CodigoValido) {
                                System.out.print("Ingrese el codigo del producto que quiere vender (1, 2, 3, 4): ");
                                Codigo_producto = scanner.nextInt();
                                
                                if (Codigo_producto < 1 || Codigo_producto > 4) {
                                    System.out.println("Codigo de producto no valido. Por favor ingrese un codigo valido.");
                                    continue;
                                }

                                if ((Tipo_cliente.equals("A")) || (Tipo_cliente.equals("B") && (Codigo_producto == 1 || Codigo_producto == 2 || Codigo_producto == 3)) || (Tipo_cliente.equals("C") && Codigo_producto == 4)) {
                                    
                                    System.out.print("Ingrese la cantidad de kilogramos del producto que desea vender: ");
                                    CantidadCompra = scanner.nextInt();

                                    while (CantidadCompra <= 0) {
                                        System.out.println("La cantidad tiene que ser mayor a 0, por favor ingrese una cantidad mayor a 0.");
                                        CantidadCompra = scanner.nextInt();
                                    }
                                    CodigoValido = true;
                                } else {
                                    System.out.println("Codigo de producto no valido. Por favor ingrese un codigo valido.");
                                }
                            }

                            //Aqui se acumulan las ventas y las ganancias de ellas
                            switch (Codigo_producto) {
                                case 1:  // Azucar
                                    if (CantidadCompra <= CantidadAzucar) {
                                        CantidadAzucar -= CantidadCompra;
                                        TotalCantidadAzucar += CantidadCompra;
                                        TotalVentaCliente += PrecioAzucar_venta * CantidadCompra;
                                        GananciaVentaCliente += (PrecioAzucar_venta - PrecioAzucar_compra) * CantidadCompra;
                                    } else {
                                        System.out.println("No hay suficiente cantidad de Azucar.");
                                    }
                                    break;
                                case 2:  // Avena
                                    if (CantidadCompra <= CantidadAvena) {
                                        CantidadAvena -= CantidadCompra;
                                        TotalCantidadAvena += CantidadCompra;
                                        TotalVentaCliente += PrecioAvena_venta * CantidadCompra;
                                        if (Tipo_cliente.equals("B")) {
                                            GananciaVentaCliente += (PrecioAvena_venta - PrecioAvena_compraB) * CantidadCompra;
                                        } else if (Tipo_cliente.equals("C")) {
                                            GananciaVentaCliente += (PrecioAvena_venta - PrecioAvena_compraC) * CantidadCompra;
                                        }
                                    } else {
                                        System.out.println("No hay suficiente cantidad de Avena.");
                                    }
                                    break;
                                case 3:  // Trigo
                                    if (CantidadCompra <= CantidadTrigo) {
                                        CantidadTrigo -= CantidadCompra;
                                        TotalCantidadTrigo += CantidadCompra;
                                        TotalVentaCliente += PrecioTrigo_venta * CantidadCompra;
                                        GananciaVentaCliente += (PrecioTrigo_venta - PrecioTrigo_compra) * CantidadCompra;
                                    } else {
                                        System.out.println("No hay suficiente cantidad de Trigo.");
                                    }
                                    break;
                                case 4:  // Maíz
                                    if (CantidadCompra <= CantidadMaiz) {
                                        CantidadMaiz -= CantidadCompra;
                                        TotalCantidadMaiz += CantidadCompra;
                                        TotalVentaCliente += PrecioMaiz_venta * CantidadCompra;
                                        GananciaVentaCliente += (PrecioMaiz_venta - PrecioMaiz_compra) * CantidadCompra;
                                    } else {
                                        System.out.println("No hay suficiente cantidad de Maiz.");
                                    }
                                    break;
                                default:
                                    System.out.println("Codigo de producto no valido.");
                                    continue;
                            }

                            System.out.print("Quiere hacer otra venta? (si/no): ");
                            String sino = scanner.next().toLowerCase();
                            if (sino.equals("no")) {
                                OtraVenta = false;
                            }
                        }

                        //Parte pa calcular el descuento, el impuesto y el total para pagar
                        double Descuento = 0;

                        if (TotalVentaCliente >= 5000) {
                            Descuento = TotalVentaCliente * 0.10;
                        } else if (TotalVentaCliente >= 1000) {
                            Descuento = TotalVentaCliente * 0.05;
                        }

                        double Impuesto = (TotalVentaCliente - Descuento) * 0.07;
                        double TotalPagar = (TotalVentaCliente - Descuento) + Impuesto;

                        if (TotalPagar > 0) {
                            Caja += TotalPagar;
                            Caja = Math.round(Caja * 100.0) / 100.0; //Lo uso para poder redondear los decimales del dinero en la caja a dos digitos, ej: Caja: Lps. 100.58294 -> 100.58.
                            TotalVentas += TotalVentaCliente;
                            NumeroVentas++;
                            CantidadAzucarVendida += TotalCantidadAzucar;
                            CantidadAvenaVendida += TotalCantidadAvena;
                            CantidadTrigoVendida += TotalCantidadTrigo;
                            CantidadMaizVendida += TotalCantidadMaiz;

                            if (GananciaVentaCliente > MaxVentaGanancia) {
                                MaxVentaGanancia = GananciaVentaCliente;
                            }
                        }

                        //Parte de facturacion de Ventas
                        System.out.println("\r                                                                                                                  ");
                        System.out.println("Venta realizada con exito");
                        System.out.println("Detalle de productos vendidos: ");
                        System.out.println("\r                                                                                                                  ");

                        if (TotalCantidadAzucar > 0) {
                            System.out.println("Azucar: " + TotalCantidadAzucar + " Kg");
                        }
                        if (TotalCantidadAvena > 0) {
                            System.out.println("Avena: " + TotalCantidadAvena + " Kg");
                        }
                        if (TotalCantidadTrigo > 0) {
                            System.out.println("Trigo: " + TotalCantidadTrigo + " Kg");
                        }
                        if (TotalCantidadMaiz > 0) {
                            System.out.println("Maiz: " + TotalCantidadMaiz + " Kg");
                        }

                        System.out.println("Subtotal: Lps. " + String.format("%.2f", TotalVentaCliente));
                        System.out.println("Descuento: Lps. " + String.format("%.2f", Descuento));
                        System.out.println("Impuesto: Lps. " + String.format("%.2f", Impuesto));
                        System.out.println("Total de a pagar: Lps. " + String.format("%.2f", TotalPagar));
                        System.out.println("Dinero en caja: Lps. " + String.format("%.2f", Caja));
                        System.out.println("\r                                                                                                                  ");

                    }
                    
                    break;
                    
                case 3:
                    //Parte de Compras
                    if (CajaCerrada) {
                        System.out.println("No se puede hacer niguna compra si la caja esta cerrada!");
                        break;
                    }
                    
                    if (!CajaAbierta) {
                        System.out.println("No se puede hacer Compras sin abrir la caja!");
                    } else {
                        
                        String Tipo_proveedor = "";
                        boolean ProveedorValido = false;
                        boolean CompraValida = false;
                        
                        System.out.println("\r                                                                                                                                                              ");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("|                          Lista de Proveedores                         |");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("| Proveedor A: Provee productos con el codigo 1(Azucar) y el 4(Maiz)    |");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("| Proveedor B: Provee productos con el codigo 2(Avena) y el 3(Trigo)    |");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("| Proveedor C: Provee solamente productos con el codigo 2(Avena)        |");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("\r                                                                                                                                                              ");
                        
                        while(!ProveedorValido) {
                            System.out.println("Ingrese el proveedor al que desea comprarle (A, B, C): ");
                            Tipo_proveedor = scanner.next().toUpperCase();

                            

                            switch(Tipo_proveedor) {
                                case "A":
                                    System.out.println("\r                                                                                                                                                      ");
                                    System.out.println("----------------------------------");
                                    System.out.println("|       Tabla de Productos       |");
                                    System.out.println("----------------------------------");
                                    System.out.println("| 1. Azucar           Lps. 25.00 |");
                                    System.out.println("----------------------------------");
                                    System.out.println("| 4. Maiz             Lps. 18.00 |");
                                    System.out.println("----------------------------------");
                                    System.out.println("\r                                                                                                                                                      ");
                                    System.out.println("Ha decidico comprar del Proveedor A, arriba esta la lista de productos que puede comprar.");
                                    ProveedorValido = true;
                                    break;

                                case "B":
                                    System.out.println("\r                                                                                                                                                      ");
                                    System.out.println("----------------------------------");
                                    System.out.println("|       Tabla de Productos       |");
                                    System.out.println("----------------------------------");
                                    System.out.println("| 2. Avena            Lps. 20.00 |");
                                    System.out.println("----------------------------------");
                                    System.out.println("| 3. Trigo            Lps. 30.00 |");
                                    System.out.println("----------------------------------");
                                    System.out.println("\r                                                                                                                                                      ");
                                    System.out.println("Ha decidico comprar del Proveedor B, arriba esta la lista de productos que puede comprar.");
                                    ProveedorValido = true;
                                    break; 

                                case "C":
                                    System.out.println("\r                                                                                                                                                      ");
                                    System.out.println("----------------------------------");
                                    System.out.println("|       Tabla de Productos       |");
                                    System.out.println("----------------------------------");
                                    System.out.println("| 2. Avena            Lps. 22.00 |");
                                    System.out.println("----------------------------------");
                                    System.out.println("\r                                                                                                                                                      ");
                                    System.out.println("Ha decidico comprar del Proveedor C, arriba esta la lista de productos que puede comprar.");
                                    ProveedorValido = true;
                                    break; 

                                default:
                                    System.out.println("Opcion invalida, por favor ingrese un proveedor existente (A, B, C)");
                            }
                        }
                        

                        double PrecioAvena = 0;
                        int CantidadCompra = 0;
                        
                        //Como el precio de avena para comprar son dos diferentes, ahi decido cual es el precio que voy a estar usando con el ifelse.
                        if (Tipo_proveedor.equals("B")) {
                            PrecioAvena = PrecioAvena_compraB;
                        } else if (Tipo_proveedor.equals("C")) {
                            PrecioAvena = PrecioAvena_compraC;

                        }

                        while(!CompraValida) {
                            System.out.println("Ingrese el codigo del producto que quiere comprar: ");
                            Codigo_producto = scanner.nextInt();

                            if (Tipo_proveedor.equals("A") && (Codigo_producto == 1 || Codigo_producto == 4) || Tipo_proveedor.equals("B") && (Codigo_producto == 2 || Codigo_producto == 3) || Tipo_proveedor.equals("C") && Codigo_producto == 2) {
                                CompraValida = true;
                                
                                System.out.println("Ingrese la cantidad de kilogramos que desea comprar.");
                                CantidadCompra = scanner.nextInt();
                                
                                while(CantidadCompra <= 0) {
                                    System.out.println("La cantidad de kilogramos tiene que ser mayor a 0, por favor ingrese una cantidad mayor a 0.");
                                    CantidadCompra = scanner.nextInt();
                                } 
                            } else {
                                System.out.println("Codigo de producto no valido, por favor ingrese un codigo de producto que sea valido.");
                            }
                        }

                        double TotalCompra = 0;

                        switch(Codigo_producto) {
                            case 1: //Validar compra para el Azucar
                                CantidadAzucar += CantidadCompra;
                                TotalCompra = PrecioAzucar_compra * CantidadCompra;
                                
                                break;

                            case 2: //Validar compra para la Avena
                                CantidadAvena += CantidadCompra;
                                TotalCompra = PrecioAvena * CantidadCompra;
                                break;

                            case 3: //Validar compra para el Trigo
                                CantidadTrigo += CantidadCompra;
                                TotalCompra = PrecioTrigo_compra * CantidadCompra;
                                break;

                            case 4: //Validar compra para el Maiz
                                CantidadMaiz += CantidadCompra;
                                TotalCompra = PrecioMaiz_compra * CantidadCompra;
                                break;

                            default:
                                System.out.println("Codigo de producto no valido, por favor ingrese un codigo de producto que sea valido.");
                        }

                        if (TotalCompra > Caja) {
                            System.out.println("No se puede pagar compra.");
                            break;
                        }
                        
                        if (TotalCompra > 0) {
                            Caja -= TotalCompra;
                            Caja = Math.round(Caja * 100.0) / 100.0; //Lo uso para poder redondear los decimales del dinero en la caja a dos digitos, ej: Caja: Lps. 100.58294 -> 100.58.
                            TotalCompras += TotalCompra;
                            NumeroCompras++;
                            
                            double GastosCompras = 0.00;
                            
                            if (Codigo_producto == 1) {
                                GastosCompras = PrecioAzucar_compra * CantidadCompra;
                            } else if (Codigo_producto == 2) {
                                if (Tipo_proveedor.equals("B")) {
                                    GastosCompras = PrecioAvena_compraB * CantidadCompra;
                                } else if (Tipo_proveedor.equals("C")) {
                                    GastosCompras = PrecioAvena_compraC * CantidadCompra;
                                }
                            } else if (Codigo_producto == 3) {
                                GastosCompras = PrecioTrigo_compra * CantidadCompra;
                            } else if (Codigo_producto == 4) {
                                GastosCompras = PrecioMaiz_compra * CantidadCompra;
                            }
                            
                            if (GastosCompras > MaxCompraGasto) {
                                MaxCompraGasto = GastosCompras;
                            }
                            
                            System.out.println("\r                                                                                                                          ");
                            System.out.println("Compra realizada con exito");
                            System.out.println("Producto: " + (Codigo_producto == 1 ? ProductoAzucar : Codigo_producto == 2 ? ProductoAvena : Codigo_producto == 3 ? ProductoTrigo : Codigo_producto == 4 ? ProductoMaiz : "holaaa"));
                            System.out.println("Cantidad comprada: " + CantidadCompra + " Kg");
                            System.out.println("Total de la compra: Lps. " + String.format("%.2f", TotalCompra));
                            System.out.println("Dinero en la caja: " + Caja);
                        }
                    }
                    
                    break;
                    
                case 4:
                    //Parte de Reportes
                    if (!CajaAbierta) {
                        System.out.println("No se puede generar Reportes sin haber abierto la caja!");
                    } else {
                        System.out.println("**** Dinero en la Caja ****");
                        System.out.println("Cantidad de dinero actual en la caja: Lps. " + Caja);
                        System.out.println("\r                                                                                                                                              ");
                        System.out.println("**** Numero de Ventas y Compras ****");
                        System.out.println("Numero de ventas realizadas: " + NumeroVentas);
                        System.out.println("Numero de compras realizadas: " + NumeroCompras);
                        System.out.println("\r                                                                                                                                              ");
                        System.out.println("**** Total de Ventas y Compras ****");
                        System.out.println("Total de Ventas realidazas: Lps. " + TotalVentas);
                        System.out.println("Total de Compras realidazas: Lps. " + TotalCompras);
                        
                        System.out.println("\r                                                                                                                                              ");
                        
                        System.out.println("**** Volumen total de Ventas y Compras ****");
                        //if que funciona solamente cuando se haya hecho una venta/compra correctamente, y muestra el volumen total de compras y ventas, pero si no ha hecho nada, va a mostrar que no hay volumen para mostrar
                        if (NumeroVentas > 0 || NumeroCompras > 0) {
                            System.out.println("Volumen total de Ventas y Compras: Lps. " + String.format("%.2f", (TotalVentas + TotalCompras)));
                        } else {
                            System.out.println("Volumen total de Ventas y Compras: ---");
                        }
                        
                        System.out.println("\r                                                                                                                                              ");
                        
                        System.out.println("**** Ganancia Neta de Ventas/Compras ****");
                        //if que funciona solamente cuando se haya hecho una venta/compra correctamente, y muestra el volumen total de compras y ventas, pero si no ha hecho nada, va a mostrar que no hay volumen para mostrar
                        if (NumeroCompras > 0 || NumeroVentas > 0) {
                            System.out.println("Ganancia Neta: Lps. " + String.format("%.2f", (TotalVentas - TotalCompras)));
                        } else {
                            System.out.println("Ganancia Neta: ---");
                        }
                        
                        System.out.println("\r                                                                                                                                              ");
                        
                        System.out.println("**** Promedio de Ventas y Compras ****");
                        //if para el promedio de las ventas, y si no se ha hecho ninguna venta, no se va a mostrar nada
                        if (NumeroVentas > 0) {
                            System.out.println("Promedio de ventas realizadas: Lps. " + (TotalVentas / NumeroVentas));
                        } else {
                            System.out.println("Promedio de ventas realizadas: ---");
                        }
                        
                        //if para el promedio de las compras, y si no se ha hecho ninguna compra, no se va a mostrar nada
                        if (NumeroCompras > 0) {
                            System.out.println("Promedio de compras realizadas: Lps. " + (TotalCompras / NumeroCompras));
                        } else {
                            System.out.println("Promedio de compras realizadas: ---");
                        }
 
                        System.out.println("\r                                                                                                                                              ");
                        System.out.println("**** Venta con mayor ganancia ****");
                        System.out.println("La venta con mayor ganancia fue: Lps. " + String.format("%.2f", MaxVentaGanancia));
                        
                        System.out.println("\r                                                                                                                                              ");
                        System.out.println("**** Compra con mayor gasto ****");
                        System.out.println("La compra con mas gasto fue: Lps. " + String.format("%.2f", MaxCompraGasto));
                        System.out.println("\r                                                                                                                                              ");
                        
                        //Aqui encuentro el producto estrella y la cantidad de unidades vendidas
                        String ProductoEstrella = "No se ha hecho nada para decidir el producto estrella!";
                        int MaxVendidas = 0;
                        
                        if (CantidadAzucarVendida > MaxVendidas) {
                            ProductoEstrella = ProductoAzucar;
                            MaxVendidas = CantidadAzucarVendida;
                        }
                        if (CantidadAvenaVendida > MaxVendidas) {
                            ProductoEstrella = ProductoAvena;
                            MaxVendidas = CantidadAvenaVendida;
                        }
                        if (CantidadTrigoVendida > MaxVendidas) {
                            ProductoEstrella = ProductoTrigo;
                            MaxVendidas = CantidadTrigoVendida;
                        }
                        if (CantidadMaizVendida > MaxVendidas) {
                            ProductoEstrella = ProductoMaiz;
                            MaxVendidas = CantidadMaizVendida;
                        }
                        
                        System.out.println("**** Producto Estrella ****");
                        //if para decidir el producto estrella, y si no se ha comprado nada, se dice que no se ha comprado nada para decidir cual es el producto estrella
                        if (CantidadAzucarVendida == 0 && CantidadAvenaVendida == 0 && CantidadTrigoVendida == 0 && CantidadMaizVendida == 0) {
                            System.out.println("No ha vendido nada para decidir el producto estrella!");
                        } else {
                            System.out.println("El producto estrella fue: " + ProductoEstrella + " con " + MaxVendidas + " unidades vendidas!"); //producto estrella
                        }
                    }
                    
                    break;
                    
                case 5:
                    //Parte de Cierre de caja
                    if (CajaCerrada) {
                        System.out.println("La caja esta actualmente cerrada, no puede cerrarse dos veces!");
                        break;
                    } else if (!CajaAbierta) {
                        System.out.println("No se puede cerrar la caja si no se ha abierto la caja!");
                    } else {
                        CajaCerrada = true;
                        
                        System.out.println("\r                                                                                                                          ");
                        System.out.println("Cerrando la caja...");
                        System.out.println("El dia ha terminado");
                        System.out.println("\r                                                                                                                          ");
                        System.out.println("Ingrese el porcentaje de dinero que quiere enviar al banco (0-60): ");
                        double Porcentaje = scanner.nextDouble();
                        
                        while (Porcentaje < 0 || Porcentaje > 60) {
                            System.out.println("Porcentaje no permitido. tiene que ser un numero entre 0 y 60");
                            Porcentaje = scanner.nextInt();
                        }
                        
                        double DineroalBanco = Caja * (Porcentaje / 100.0);
                        double DineroenCaja = Caja - DineroalBanco;
                        
                        System.out.println("\r                                                                                                                          ");
                        System.out.println("**** Cierre de Caja ****");
                        System.out.println("Dinero total en la caja antes del cierre: " + String.format("%.2f", Caja));
                        System.out.println("Dinero transferido al Banco (" + Porcentaje + "%): Lps. " + String.format("%.2f", DineroalBanco));
                        System.out.println("Dinero restante en la Caja: Lps. " + String.format("%.2f", DineroenCaja));
                        
                        Caja = DineroenCaja;
                        Caja = Math.round(Caja * 100.0) / 100.0; //Lo uso para poder redondear los decimales del dinero en la caja a dos digitos, ej: Caja: Lps. 100.58294 -> 100.58.
                        
                        NumeroVentas = 0;
                        NumeroCompras = 0;
                        TotalVentas = 0.00;
                        TotalCompras = 0.00;
                        MaxVentaGanancia = 0.00;
                        MaxCompraGasto = 0.00;
                        CantidadAzucarVendida = 0;
                        CantidadAvenaVendida = 0;
                        CantidadTrigoVendida = 0;
                        CantidadMaizVendida = 0;
                        
                        System.out.println("\r                                                                                                                           ");
                        System.out.println("El cierre de Caja ha sido realizado. El dia ha terminado exitosamente.");
                        CajaAbierta = false;
                    }
                    
                    
                    break;
                    
                case 6:
                    //Parte de Salir del sistema
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Esa opcion no es valida, por favor ingrese una opcion valida.");
            }
            
        } while (Opcion != 6);
    }
}