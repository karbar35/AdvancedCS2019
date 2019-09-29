import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BinaryConversion {
	public static final int LONG = 64;  //-9223372036854775808  9223372036854775807
    public static final int INT = 32;
    public static final int SHORT = 16;
    public static final int BYTE = 8;
    
	public static final int POSITIVE = 0;
	public static final int NEGATIVE = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println("Enter a number value. For negative values, use -");
		while (flag == false) {
			try {
				Scanner s = new Scanner(System.in);
				// long temp = s.nextLong();
				String input = s.nextLine();
				System.out.println("You chose " + input);
				flag = true;
				// System.out.println(input + " in binary is: " +
				// makeBinary(input));
				// makeBinary(input);
			} catch (InputMismatchException e) {
				System.out.println("Please enter a NUMBER with no other characters.");
			}
		}
	}

	public static void makeBinary(String sinput, int type) {
		int bitSize = 0;		
		
		if(type == BinaryConversionFrontEnd.FLOAT_TYPE) /* the input is a decimal, so use IEEE */{
			float input = Float.parseFloat(sinput); // input will be used to refer to the user input from here on
			if(input == 0) {
				System.out.println(0);
				return;
			}
			if (input <= 255 && input >= -256) {
				bitSize = BYTE;
			} else if (input <= 65535 && input >= -65536) {
				bitSize = SHORT;
			} else if (input <= Math.pow(2, 31) - 1 && input >= -Math.pow(2, 31)) {
				bitSize = INT;
			} else if (input <= Math.pow(2, 63) - 1 && input >= -Math.pow(2, 63)) {
				bitSize = LONG;
			} else {
				System.out.println("That number is too big.");
				return;
			}
			int[] leftDec = new int[bitSize];
			int[] rightDec = new int[100];
			int sign = POSITIVE; 
			if(input < 0) {
				// check sign of input
				sign = NEGATIVE;
				input = input * -1;
			}
			
			// converts left of decimal to binary in leftDec[]
			for (int i = 0; i < bitSize; i++) {
				if (input >= Math.pow(2, (bitSize - 1) - i)) {
					leftDec[i] = 1;
					input = (float) (input - Math.pow(2, (bitSize - 1) - i));
				}
			}
			// finds number of binary digits on left
			int leftDigits = leftDec.length;
			for(int i = 0; i < leftDec.length; i++) {
				if(leftDec[i] == 0) {
					leftDigits--;
				} else {
					break;
				}
			}
			input = -Float.parseFloat(sinput) + (long)Float.parseFloat(sinput); /* cuts off integer portion of input */
			// int rightDigits = 23 - leftDigits;
			for(int i = 0; i < rightDec.length; i++) {
				if(input >= Math.pow(2, -(i+1))) {
					rightDec[i] = 1;
					input = (float) (input - Math.pow(2, -(i+1)));
				}
			}
			
			/*
			 * Code below determines the exponent
			 */
			int exponent = 127;
			if(Arrays.toString(leftDec).contains("1")) {
				exponent = 127 + leftDigits - 1;
			} else {
				int count = 0;
				for(int i = 0; i < rightDec.length; i++) {
					if(rightDec[i] == 0) {
						count++;
					} else {
						break;
					}
				}
				exponent = 127 - count - 1;
			}
			int [] exponentArray = new int[8];
			for (int i = 0; i < 8; i++) {
				if (exponent >= Math.pow(2, 7 - i)) {
					exponentArray[i] = 1;
					exponent = (int) (exponent - Math.pow(2, 7 - i));
				}
			}
			
			/*
			 * Code below prints the number in binary IEEE format
			 */
			// System.out.println(leftDigits + " " + rightDigits);
			System.out.println(sinput + " in Binary IEEE 754 Format is:");
			System.out.print(sign);
			for(int e : exponentArray) {
				System.out.print(e);
			}
			int toMantissa = 0;
			for(int i = (bitSize-leftDigits); i < bitSize; i++) {
				System.out.print(leftDec[i]);
				toMantissa++;
			}
			for(int i = toMantissa; i < 23; i++) {
				System.out.print(rightDec[i]);
			}
			System.out.println("");
			
		} else /* the input is not a decimal, so use 2s complement/normal binary bytes */{
			
			long input = Long.parseLong(sinput); // input will be used to refer to the user input from here on
			
			if (input <= 255 && input >= -256) {
				bitSize = BYTE;
			} else if (input <= 65535 && input >= -65536) {
				bitSize = SHORT;
			} else if (input <= Math.pow(2, 31) - 1 && input >= -Math.pow(2, 31)) {
				bitSize = INT;
			} else if (input <= Math.pow(2, 63) - 1 && input >= -Math.pow(2, 63)) {
				bitSize = LONG;
			} else {
				System.out.println("That number is too big.");
				return;
			}
			int[] resultArray = new int[bitSize];
			
			int sign = POSITIVE;
			if(input < 0) {
				// check sign of input
				sign = NEGATIVE;
			}
			
			if(sign == POSITIVE) {
				for (int i = 0; i < bitSize; i++) {
					if (input >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						input = (long) (input - Math.pow(2, (bitSize - 1) - i));
					} else {
						resultArray[i] = 0;
					}
				}
				
				System.out.println(sinput + " in binary is:");
				for (int i : resultArray) {
					System.out.print(i);
				}
				System.out.println("");
				
			} else /* sign == NEGATIVE */ {
				input = input * -1;
				// make input into binary normally, but with flipped digits
				for (int i = 0; i < bitSize; i++) {
					if (input >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 0;
						input = (long) (input - Math.pow(2, (bitSize - 1) - i));
					} else {
						resultArray[i] = 1;
					}
				}
				// add 1
				for(int i = bitSize-1; i >= 0; i--) {
					if(resultArray[i] == 0) {
						resultArray[i] = 1;
						break;
					} else {
						resultArray[i] = 0;
					}
				}
				
				System.out.println(sinput + " in binary is:");
				for (int i : resultArray) {
					System.out.print(i);
				}
				System.out.println("");
			}
			
		}
		/* END OF NEW CODE */
		
		/*
		int[] resultArray = new int[bitSize];
		int[] decimals = new int[100];
		if (linput >= 0 || dinput >= 0) { // positive inputs
			int sign = 0;
			if (!isADecimal) { // if there is no decimal

				for (int i = 0; i < bitSize; i++) {
					if (linput >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						linput = (long) (linput - Math.pow(2, (bitSize - 1) - i));
					}
				}

				for (int i : resultArray) {
					System.out.print(i);
				}
				System.out.println("");
			} else { // if there is a decimal portion
				double rightDec = dinput - (int) dinput;
				// converting the left of the decimal
				for (int i = 0; i < bitSize; i++) {
					if (dinput >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						dinput = dinput - Math.pow(2, (bitSize - 1) - i);
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
					
			linput = linput * -1;
			if (!isADecimal) { // if there is no decimal
				// turns positive version of input into binary
				// 2's Complement Conversion:
				
				for (int i = 0; i < bitSize; i++) {
					if (linput >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						linput = (long) (linput - Math.pow(2, (bitSize - 1) - i));
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
				double rightDec = dinput - (int) dinput;
				// converting the left of the decimal
				for (int i = 0; i < bitSize; i++) {
					if (dinput >= Math.pow(2, (bitSize - 1) - i)) {
						resultArray[i] = 1;
						dinput = dinput - Math.pow(2, (bitSize - 1) - i);
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
			}*/
		}

	}


