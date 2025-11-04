/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Testeador {

    /**
     * Parsea una cadena de fecha con formato "dd-MM-yyyy" a un objeto LocalDate.
     * Muestra el resultado o un mensaje de error si el parseo falla.
     *
     * @param fechaString La cadena de fecha a parsear.
     * @return El objeto LocalDate resultante, o null si hay un error.
     */
    public static LocalDate testearYGenerarFecha(String fechaString) {
        // Definir el formato esperado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = null;

        try {
            // Intentar parsear la cadena
            localDate = LocalDate.parse(fechaString, formatter);
            System.out.println("TEST OK: Fecha parseada correctamente -> " + localDate);
        } catch (DateTimeParseException e) {
            // Capturar la excepción si el formato no es válido
            System.out.println("TEST ERROR: No se pudo parsear la fecha \"" + fechaString + "\".");
            System.out.println("Causa: " + e.getMessage());
        }
        
        return localDate;
    }

//    public static void main(String[] args) {
//        // Ejemplo de uso con una fecha válida
//        String fechaValida = "15-08-2024";
//        LocalDate fecha1 = testearYGenerarFecha(fechaValida);
//        System.out.println("--------------------------------------------------");
//
//        // Ejemplo de uso con una fecha inválida (formato incorrecto)
//        String fechaInvalida = "2024/08/15";
//        LocalDate fecha2 = testearYGenerarFecha(fechaInvalida);
//        System.out.println("--------------------------------------------------");
//        
//        // Ejemplo de uso con una fecha inválida (valores incorrectos, día 32)
//        String fechaInvalidaValores = "32-01-2024";
//        LocalDate fecha3 = testearYGenerarFecha(fechaInvalidaValores);
//    }
}
