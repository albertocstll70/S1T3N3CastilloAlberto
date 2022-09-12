package s1t3n3exercici1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

public class MainExercici1 {

	public static void main(String[] args) {

		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		ArrayList<Persona> listPersona = new ArrayList<Persona>();
	

		boolean sortir = false;
		do {
			switch (menu()) {
			case 1:
				introducirPersona(datos, listPersona);
				break;
			case 2:
				nombreAZ(listPersona);
				break;
			case 3:
				nombreZA(listPersona);
				break;
			case 4:
				apellidoAZ(listPersona);
				break;
			case 5:
				apellidoZA(listPersona);
				break;
			case 6:
				dni1_9(listPersona);
				break;
			case 7:
				dni9_1(listPersona);
				break;
			case 0:
				Entrada.escribir("Gracias por utilizar la aplicación");
				sortir = true;
				break;

			default:
				System.err.println("ERROR");
				break;
			}
		} while (!sortir);

	}

//Menu
	public static byte menu() {

		byte opcio;

		final byte MINIMO = 0;
		final byte MAXIMO = 7;

		do {
			Entrada.escribir("\nMENú PRINCIPAL");
			Entrada.escribir("1.- Introducir persona. ");
			Entrada.escribir("2.- Mostrar a las personas ordenadas por nombre (A-Z).");
			Entrada.escribir("3.- Mostrar a las personas ordenadas por nombre (Z-A).");
			Entrada.escribir("4.- Mostrar a las personas ordenadas por apellidos (A-Z).");
			Entrada.escribir("5.- Mostrar a las personas ordenadas por apellidos (Z-A).");
			Entrada.escribir("6.- Mostrar a las personas ordenadas por DNI (1-9).");
			Entrada.escribir("7.- Mostrar a las personas ordenadas por DNI (9-1). ");
			Entrada.escribir("0.- Salir de la aplicacion ");

			opcio = Entrada.leerByte("Introduce una opción");
			Entrada.vaciarBuffer();

			if (opcio < MINIMO || opcio > MAXIMO) {
				Entrada.escribir("Escoje una opción valida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;

	}

	public static void leerArchivoCSV(ArrayList<ArrayList<String>> datos) {
		String separador = ",";

		Path path = Paths.get(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "s1t3n3exercici1" + File.separator + "personas.csv");

		try (BufferedReader entrada = Files.newBufferedReader(path)) {
			String linea;

			while ((linea = entrada.readLine()) != null) {
				String[] datoLinea = linea.split(separador);
				ArrayList<String> contenidoLinea = new ArrayList<String>();
				for (String dato : datoLinea) {
					contenidoLinea.add(dato);
				}
				datos.add(contenidoLinea);

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}

	public static void introducirPersona(ArrayList<ArrayList<String>> datos, ArrayList<Persona> listPersona) {
		leerArchivoCSV(datos);

		for (ArrayList<String> dato : datos) {

			if (buscarPersona(listPersona, dato.get(2)) == null) {
				Persona persona = new Persona(dato.get(0), dato.get(1), dato.get(2));
				listPersona.add(persona);
			}
		}

	}

	public static Persona buscarPersona(ArrayList<Persona> listPersona, String dni) {

		Persona persona = null;
		int size = listPersona.size();
		boolean encontrado = false;
		int i = 0;

		while (i < size && !encontrado) {
			if (listPersona.get(i).getDni().equalsIgnoreCase(dni)) {
				encontrado = true;
				persona = listPersona.get(i);
			}

			i++;

		}

		return persona;
	}

	public static void nombreZA(ArrayList<Persona> listPersona) {

		listPersona.sort(
				Comparator.comparing(Persona::getNombre, (n1, n2) -> n2.compareTo(n1)));

		for (Persona p : listPersona) {
			System.out.println(p);

		}

	}

	public static void nombreAZ(ArrayList<Persona> listPersona) {

		listPersona.sort(
				Comparator.comparing(Persona::getNombre));
		for (Persona p : listPersona) {
			System.out.println(p);

		}

	}

	public static void apellidoAZ(ArrayList<Persona> listPersona) {

		listPersona.sort(
				Comparator.comparing(Persona::getApellido));
		for (Persona p : listPersona) {
			System.out.println(p);

		}

	}

	public static void apellidoZA(ArrayList<Persona> listPersona) {

		listPersona.sort(
				Comparator.comparing(Persona::getApellido, (n1, n2) -> n2.compareTo(n1)));

		for (Persona p : listPersona) {
			System.out.println(p);
		}

	}

	public static void dni1_9(ArrayList<Persona> listPersona) {

		listPersona.sort(
				Comparator.comparing(Persona::getDni));
		for (Persona p : listPersona) {
			System.out.println(p);

		}

	}

	public static void dni9_1(ArrayList<Persona> listPersona) {

		listPersona.sort(
				Comparator.comparing(Persona::getDni, (n1, n2) -> n2.compareTo(n1)));

		for (Persona p : listPersona) {
			System.out.println(p);

		}

	}

}
