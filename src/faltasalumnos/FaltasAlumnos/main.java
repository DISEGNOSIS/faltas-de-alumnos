/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faltasalumnos.FaltasAlumnos;

/**
 *
 * @author Guada
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    String[] alumnos = {"Alberti", "Azcuénaga", "Belgrano", "Castelli", "Larrea", "Matheu", "Moreno", "Paso", "Saavedra"};    
    
    char [][] tablaPresentismo = {
        {'P', 'P', 'P', 'P', 'P', 'P', 'T', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'T'},
        {'A', 'P', 'P', 'P', 'P', 'P', 'A', 'P', 'P', 'P', 'T', 'P', 'P', 'P', 'A', 'P'},
        {'T', 'P', 'A', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'A', 'P', 'P'},
        {'P', 'P', 'T', 'T', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'},
        {'T', 'P', 'P', 'P', 'P', 'A', 'P', 'P', 'A', 'P', 'P', 'A', 'P', 'P', 'P', 'A'},
        {'P', 'P', 'P', 'P', 'T', 'T', 'P', 'P', 'P', 'P', 'A', 'P', 'P', 'P', 'P', 'A'},
        {'P', 'P', 'A', 'P', 'P', 'P', 'T', 'T', 'A', 'P', 'P', 'A', 'P', 'A', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'A', 'A', 'T', 'P', 'P', 'P', 'P', 'A', 'A', 'P', 'P', 'A'},
        {'P', 'P', 'A', 'P', 'A', 'T', 'P', 'P', 'A', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}
        };
    
        int cantidadDeAlumnosQuePuedenRendir = cantidadDeAlumnosQuePuedenRendir(tablaPresentismo);
        System.out.println("La cantidad de alumnos que pueden rendir el exámen es: " + cantidadDeAlumnosQuePuedenRendir);
        
        System.out.println("Los alumnos que pueden rendir el exámen son:");
        imprimirAlumnosHabilitados(alumnos, tablaPresentismo);
        
        System.out.println("Los alumnos que no pueden rendir el exámen son:");
        imprimirAlumnosInhabilitados(alumnos, tablaPresentismo);
      
        presentismoAlumno(alumnos, tablaPresentismo);
        
        int totalLlegadasTarde = totalLlegadasTarde(tablaPresentismo);
        System.out.println("El total de llegadas tarde es de: " + totalLlegadasTarde);
        
        int totalAusentes = totalAusentes(tablaPresentismo);
        System.out.println("El total de faltas es de: " + totalAusentes);
        
        presentismoClase(tablaPresentismo);
    }
    

    public static int totalAusentes (char[][] matriz){
        int totalAusentes = 0;
        int totalTarde = 0;
        int longitud = matriz.length;
        int columnas;
        
        for (int i = 0; i < longitud; i++){
            
            columnas = matriz[i].length;
            for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] == 'T'){
                    totalTarde ++;
                    }
                    else if (matriz[i][j] == 'A'){
                        totalAusentes++;
                    }
            }
        }
        
            totalAusentes = totalAusentes + (totalTarde/2);
        
        
        return totalAusentes;
    }
    
    public static int totalLlegadasTarde (char[][] matriz){
        int totalLlegadasTarde = 0;
        int longitud = matriz.length;
        int columnas;
        
        for (int i = 0; i < longitud; i++){
            
            columnas = matriz[i].length;
            for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] == 'T'){
                    totalLlegadasTarde++;
                    }            
            }
        }
        
        return totalLlegadasTarde;
    }
    
    public static void presentismoClase (char[][] matriz){
        int longitud = matriz.length;
        for (int i = 0; i < longitud; i++){
            System.out.println("La tabla de asistencias de la clase " + (i+1) + " es:");
            imprimirAsistenciasClases(i, matriz);
        }
    }
    
    
    public static void presentismoAlumno (String[] alumnos, char[][] matriz){
        int longitud = alumnos.length;
        String nombre;
        for (int i = 0; i < longitud; i++){     
            nombre = alumnos[i];
            double porcentajeDeAsistencia = porcentajeDeAsistencia(i, matriz);
            System.out.println("El alumno " + nombre + " tiene " + porcentajeDeAsistencia + "% de asistencia.");
        }
    }
    
     public static void imprimirAsistenciasClases(int i, char[][] matriz) {
        int filas = matriz.length;
        
        for (int j = 0; j < filas; j++) {
                if (j == 0) {
                    System.out.print("[" + matriz[j][i] + ", ");
                } else if (j == filas-1) {
                    System.out.println(matriz[j][i] + "]");
                } else {
                    System.out.print(matriz[j][i] + ", ");
                }
        }

    }
     
     
    public static double porcentajeDeAsistencia (int i, char[][] matriz){
         
        double presente = 0;
        double ausente = 0;
        int columnas = matriz[i].length;

        for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == 'P'){
                presente++;
                }
                else if (matriz[i][j] == 'A'){
                    ausente++;
                }
                else if (matriz[i][j] == 'T'){
                    presente = presente + 0.5;
                    ausente = ausente + 0.5;
              }

            }
       
        double porcentajeDeAsistencia = (presente * 100) / columnas;     
        //System.out.println(porcentajeDeAsistencia);
        
        return porcentajeDeAsistencia;
        
    }
    
    public static void imprimirAlumnosHabilitados (String [] alumnos, char[][] matriz){
        int longitud = alumnos.length;
        String nombre;
        for (int i = 0; i < longitud; i++){
            nombre = alumnos[i];
            double porcentajeDeAsistencia = porcentajeDeAsistencia(i, matriz);
            if (porcentajeDeAsistencia >= 75){
                System.out.println(nombre);
            }

        }
    }
    
    public static void imprimirAlumnosInhabilitados (String [] alumnos, char[][] matriz){
        int longitud = alumnos.length;
        String nombre;
        for (int i = 0; i < longitud; i++){
            nombre = alumnos[i];
            double porcentajeDeAsistencia = porcentajeDeAsistencia(i, matriz);
            if (porcentajeDeAsistencia < 75){
                System.out.println(nombre);
            }

        }
    }
    
    public static int cantidadDeAlumnosQuePuedenRendir (char[][] matriz){
        
        int cantidadDeAlumnosQuePuedenRendir = 0;
        int longitud = matriz.length;
        for (int i = 0; i < longitud; i++){
            double porcentajeDeAsistencia = porcentajeDeAsistencia(i, matriz);

            if (porcentajeDeAsistencia >= 75){
                cantidadDeAlumnosQuePuedenRendir++;
            }  
        }
      return cantidadDeAlumnosQuePuedenRendir;
    
   }
    
   

}
