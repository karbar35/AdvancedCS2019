import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println("Enter a number value. For negative values, use -");
		while (flag == false) {
			try {
				Scanner s = new Scanner(System.in);
				// long temp = s.nextLong();
				double input = s.nextDouble();
				System.out.println("You chose " + input);
				flag = true;
				// System.out.println(input + " in binary is: " +
				// makeBinary(input));
				makeBinary(input);
			} catch (InputMismatchException e) {
				System.out.println("Please enter a NUMBER with no other characters.");
			}
		}
	}

	public static void makeBinary(double input) {
		int bitSize = 0;

		// check for size of number in bytes.
		if (input <= 255 && input >= -256) {
			bitSize = 8;
		} else if (input <= 65535 && input >= -65536) {
			bitSize = 16;
		} else if (input <= Math.pow(2, 32) - 1 && input >= -Math.pow(2, 32)) {
			bitSize = 32;
		} else if (input <= Math.pow(2, 63) - 1 && input >= -Math.pow(2, 63)) {
			bitSize = 64;
		} else {
			System.out.println("That number is too big.");
		}

		int[] resultArray = new int[bitSize];
		int[] decimals = new int[100];
		if (input >= 0) { // positive inputs
			int sign = 0;
			if ((int) input == input) { // if there is no decimal

				for (int i = 0; i < bitSize; i++) {
					if (input >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						input = input - Math.pow(2, (bitSize - 1) - i);
					}
				}

				for (int i : resultArray) {
					System.out.print(i);
				}
				System.out.println("");
			} else { // if there is a decimal portion
				double rightDec = input - (int) input;
				// converting the left of the decimal
				for (int i = 0; i < bitSize; i++) {
					if (input >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						input = input - Math.pow(2, (bitSize - 1) - i);
					}
				}

				// converting the right of the decimal
				int j = 0;
				while (rightDec != 0) {
					rightDec *= 2;
					decimals[j] = (int) rightDec;
					rightDec = rightDec - (int) rightDec;
					j++;
				}
				System.out.println("Binary representation with decimal point:");
				for(int i : resultArray) {
					System.out.print(i);
				}
				System.out.print(".");
				int decToPrint = decimals.length-1;
				for(int i = decimals.length-1; i >= 0; i--) {
					if(decimals[i] == 0) {
						decToPrint--;
					} else {
						break;
					}
				}
				
				for(int i = 0; i <= decToPrint; i++) {
					System.out.print(decimals[i]);
				}
				System.out.println("");
				System.out.println("IEEE 754 Format:");
				// making the positive binary decimal into IEEE 754 Format:
				int exponent = 127;
				int resultDigits = resultArray.length;
				for(int i = 0; i < resultArray.length; i++) {
					if(resultArray[i] == 0) {
						resultDigits--;
					} else {
						break;
					}
				}
				if(Arrays.toString(resultArray).contains("1")) {
					exponent = 127 + resultDigits - 1;
				} else {
					int count = 0;
					for(int i = 0; i < decimals.length; i++) {
						if(decimals[i] == 0) {
							count++;
						} else {
							break;
						}
					}
					exponent = 127 - count - 1;
				}
				
				// converting exponent into binary:
				int [] exponentArray = new int[8];
				for (int i = 0; i < 8; i++) {
					if (exponent >= Math.pow(2, (8 - 1) - i)) {
						exponentArray[i] = 1;
						exponent = (int) (exponent - Math.pow(2, (8 - 1) - i));
					}
				}
				// IEEE 754 format prep:
				int resultArrayStart = 0;
				int decimalArrayStart = 0;
				int extraSpaces = 0;
				for(int i = 0; i < resultArray.length; i++) {
					if(resultArray[i] == 0) {
						resultArrayStart++;
					} else {
						resultArrayStart++;
						break;
					}
				}
				if(resultArrayStart == resultArray.length) {
					for(int i = 0; i < decimals.length; i++) {
						if(decimals[i] == 0) {
							decimalArrayStart++;
							extraSpaces++;
						} else {
							decimalArrayStart++;
							extraSpaces++;
							break;
						}
					}
				}
				
				// printing in IEEE 754 format
				System.out.print(sign +  " ");
				for(int e : exponentArray) {
					System.out.print(e);
				}
				System.out.print(" ");
				for(int i = resultArrayStart; i < resultArray.length; i++) {
					System.out.print(resultArray[i]);
				}
				System.out.print(" ");
				for(int i = decimalArrayStart; i < (23+extraSpaces-(resultArray.length-resultArrayStart)); i++) {
					System.out.print(decimals[i]);
				}
				System.out.println("");
			}
			
			
		} else { // negative inputs
					// turns positive version of input into binary
			input = input * -1;
			if ((int) input == input) { // if there is no decimal

				for (int i = 0; i < bitSize; i++) {
					if (input >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						input = input - Math.pow(2, (bitSize - 1) - i);
					}
				}

				// flips all the digits of the binary version of input
				for (int i = 0; i < resultArray.length; i++) {
					resultArray[i] = -(resultArray[i]) + 1;
				}

				// adds 1 to the flipped version of binary input
				for (int i = resultArray.length - 1; i >= 0; i--) {
					if (resultArray[i] == 1) {
						resultArray[i] = 0;
					} else {
						resultArray[i] = 1;
						break;
					}
				}

				for (int i : resultArray) {
					System.out.print(i);
				}
				System.out.println("");
			} else { // if there is a decimal portion
				int sign = 1;
				double rightDec = input - (int) input;
				// converting the left of the decimal
				for (int i = 0; i < bitSize; i++) {
					if (input >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						input = input - Math.pow(2, (bitSize - 1) - i);
					}
				}

				// converting the right of the decimal
				int j = 0;
				while (rightDec != 0) {
					rightDec *= 2;
					decimals[j] = (int) rightDec;
					rightDec = rightDec - (int) rightDec;
					j++;
				}
				System.out.println("Binary representation with decimal point:");
				for(int i : resultArray) {
					System.out.print(i);
				}
				System.out.print(".");
				int decToPrint = decimals.length-1;
				for(int i = decimals.length-1; i >= 0; i--) {
					if(decimals[i] == 0) {
						decToPrint--;
					} else {
						break;
					}
				}
				
				for(int i = 0; i <= decToPrint; i++) {
					System.out.print(decimals[i]);
				}
				System.out.println("");
				System.out.println("IEEE 754 Format:");
				// making the positive binary decimal into IEEE 754 Format:
				int exponent = 127;
				int resultDigits = resultArray.length;
				for(int i = 0; i < resultArray.length; i++) {
					if(resultArray[i] == 0) {
						resultDigits--;
					} else {
						break;
					}
				}
				if(Arrays.toString(resultArray).contains("1")) {
					exponent = 127 + resultDigits - 1;
				} else {
					int count = 0;
					for(int i = 0; i < decimals.length; i++) {
						if(decimals[i] == 0) {
							count++;
						} else {
							break;
						}
					}
					exponent = 127 - count - 1;
				}
				
				// converting exponent into binary:
				int [] exponentArray = new int[8];
				for (int i = 0; i < 8; i++) {
					if (exponent >= Math.pow(2, (8 - 1) - i)) {
						exponentArray[i] = 1;
						exponent = (int) (exponent - Math.pow(2, (8 - 1) - i));
					}
				}
				
				// printing IEEE 754 format:
				int resultArrayStart = 0;
				int decimalArrayStart = 0;
				int extraSpaces = 0;
				for(int i = 0; i < resultArray.length; i++) {
					if(resultArray[i] == 0) {
						resultArrayStart++;
					} else {
						resultArrayStart++;
						break;
					}
				}
				if(resultArrayStart == resultArray.length) {
					for(int i = 0; i < decimals.length; i++) {
						if(decimals[i] == 0) {
							decimalArrayStart++;
							extraSpaces++;
						} else {
							decimalArrayStart++;
							extraSpaces++;
							break;
						}
					}
				}

				System.out.print(sign +  " ");
				for(int e : exponentArray) {
					System.out.print(e);
				}
				System.out.print(" ");
				for(int i = resultArrayStart; i < resultArray.length; i++) {
					System.out.print(resultArray[i]);
				}
				System.out.print(" ");
				for(int i = decimalArrayStart; i < (23+extraSpaces-(resultArray.length-resultArrayStart)); i++) {
					System.out.print(decimals[i]);
				}
				System.out.println("");
			}
			}
		}

	}


