package s1t3n3exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	private static Scanner input = new Scanner(System.in);

	public static void escribir(Object o) {
		System.out.println(o);
	}

	public static Byte leerByte(String mensaje) {
		byte result = 0;
		boolean repetir;
		do {
			repetir = false;

			try {
				System.out.println(mensaje);
				result = input.nextByte();

			} catch (InputMismatchException e) {
				System.err.println("Error de formato ");
				input.nextLine();
				repetir = true;

			}

		} while (repetir);

		return result;

	}

	public static Integer leerInt(String mensaje) {
		int result = 0;
		boolean repetir;
		do {
			repetir = false;

			try {
				System.out.println(mensaje);
				result = input.nextInt();

			} catch (InputMismatchException e) {
				System.err.println("Error de formato ");
				input.nextLine();
				repetir = true;

			}

		} while (repetir);
		return result;
	}

	public static Float leerFloat(String mensaje) {
		float result = 0;
		boolean repetir;

		do {
			repetir = false;
			try {
				System.out.println(mensaje);
				result = input.nextFloat();

			} catch (InputMismatchException e) {
				System.err.println("Error de formato ");
				input.nextLine();
				repetir = true;

			}

		} while (repetir);
		return result;
	}

	public static Double leerDouble(String mensaje) {

		double result = 0;
		boolean repetir;
		do {
			repetir = false;
			try {
				System.out.println(mensaje);
				result = input.nextDouble();

			} catch (InputMismatchException e) {
				System.err.println(" Error de formato ");
				input.nextLine();
				repetir = true;
			}

		} while (repetir);
		return result;

	}

	public static Character leerChar(String mensaje) {
		char result = 0;
		boolean repetir;
		do {
			repetir = false;
			try {
				System.out.println(mensaje);
				result = input.next().charAt(0);

			} catch (Exception e) {
				System.err.println("Error de formato ");
				input.nextLine();
				repetir = true;
			}

		} while (repetir);
		return result;
	}

	public static String leerString(String mensaje) {
		String result = null;
		boolean repetir;
		do {
			repetir = false;
			try {
				System.out.println(mensaje);
				result = input.nextLine();

			} catch (Exception e) {
				System.err.println("Error de formato ");
				input.nextLine();
				repetir = true;

			}

		} while (repetir);
		return result;
	}

	public static Boolean leerSiNo(String mensaje) {
		char SiNo = 0;
		boolean result = false;
		boolean salir = false;
		while (!salir) {
			System.out.println(mensaje);
			try {
				SiNo = input.next().charAt(0);
				if (SiNo == 's' || SiNo == 'S' || SiNo == 'n' || SiNo == 'N') {
					salir = true;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.err.println("Error de formato ");

			}
			input.nextLine();
		}
		if (SiNo == 's' || SiNo == 'S') {
			result = true;
		}

		return result;

	}

	public static void vaciarBuffer() {

		input.nextLine();
	}

	public static String leerDni(String mensaje) {

		String dni = null;
		boolean repetir = false;

		final String LETRA = "TRWAGMYFPDXBNJZSQVHLCKE";
		final int TAMANYO = 9;

		int posicionLetra;
		String numero;
		int num = 0;
		int resto;

		do {

			System.out.println(mensaje);
			dni = input.nextLine();

			try {
				posicionLetra = dni.length() - 1;
				dni = dni.toUpperCase();
				numero = dni.replaceAll("[A-Z]", "");
				num = Integer.parseInt(numero);
				resto = num % 23;

				if (dni.length() == TAMANYO && (dni.charAt(posicionLetra) == LETRA.charAt(resto))) {

					repetir = false;

				} else {
					throw new ErrorDni();
				}

			} catch (ErrorDni | NumberFormatException e) {
				repetir = true;

				System.err.println(e.getMessage());

			}

		} while (repetir);

		return dni;
	}
}
