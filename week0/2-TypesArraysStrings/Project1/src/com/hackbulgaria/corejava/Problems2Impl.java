package com.hackbulgaria.corejava;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
    	return number % 2 != 0;
    }

    @Override
    public boolean isPrime(int number) {
    	double maxDiv = Math.sqrt(number);
		boolean result = true;
		for (int i = 2; i <= maxDiv; i++){
			if (number % i == 0) { 
				return false;
			}
		}
		return result;
    }

    @Override
    public int min(int... array) {
    	int min = 0;
		for	(int i = 0 ; i < array.length ; i++){
			int temp = array[i];
			if (temp < min)
				min = temp;
		}
		return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
    	Arrays.sort(array);
		return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
    	float sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		return sum / array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= upperBound; i++) {
			double maxDev = Math.sqrt(i);
			boolean result = true;
			for (int j = 2; j <= maxDev; j++){
				if (i % j == 0) { 
					result = false;
					break;
				}
			}
			if (result)
				list.add(i);
		}
		int max = (int)Math.sqrt(upperBound);
		int notPrimeNumInUpperBound = 0;
		for (int i = 2; i <= max; i++) {
			for (int j = max; j >= 2 ; j--) {
				notPrimeNumInUpperBound = (int)Math.pow(i, j);
				if (notPrimeNumInUpperBound <= upperBound)
					break;
			}
			if (!list.contains(notPrimeNumInUpperBound)) {
				list.remove((Object)i);
				list.add(notPrimeNumInUpperBound);
			}
		}
		long smallestMultple = 1;
		for (Integer num : list) {
			smallestMultple *= num;
		}
		return smallestMultple;
    }

    @Override
    public long getLargestPalindrome(long N) {
    	N--;
    	StringBuilder oldNum = new StringBuilder(Long.toString(N));
		StringBuilder newNum = new StringBuilder(Long.toString(N)).reverse();
		
		if (oldNum.toString().equals(newNum.toString())) {
			return Long.parseLong(oldNum.toString());
		}
		else
			return getLargestPalindrome(N);
    }

    @Override
    public int[] histogram(short[][] image) {
    	int[] arr = new int[256];
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				arr[image[i][j]]++;
			}
		}
		return arr;
    }

    // Factorial
    public long fac (long n) {
		if (n == 1)
			return 1;
		else 
			return n*fac(n-1);
	}
    
    @Override
    public long doubleFac(int n) {    	
    		return fac(fac(n));
    }

    @Override
    public long kthFac(int k, int n) {
    	if (n <= 1)
			return 1;
		else
			return n*kthFac(k, n-k);
    }

    @Override
    public int getOddOccurrence(int[] array) {
    	Arrays.sort(array);
		int currentNum = array[0];
		int i = 0;
		
		while (array[i] == array[i+1]) {
			int count = 1;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j])
					count++;
				else { 
					currentNum = array[i];
					i = j;
					break;
				}
			}
			if (count % 2 != 0)
				break;
		}
		
		return currentNum;
    }

    @Override
    public long pow(int a, int b) {
		if (b == 0)
			return 1;
		else if (b == 1)
			return a;
		else if (b % 2 == 0) {
			return pow(a*a, b/2);
		}
		else if (b % 2 != 0) {
			return a * pow(a*a, (b - 1)/2);
		}
		else
			return b;
	}

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
    	long sum = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 0; i < a.length; i++)
			sum += a[i]*b[i];
		
		return sum;
    }

    @Override
    public int maxSpan(int[] array) {
    	int start = 0;
		int end = 0;
		int max = 0;
		
		for (int i = 0; i < array.length-1; i++) {
			start = i;
			for (int j = i; j < array.length; j++) {
				if (array[i] == array[j])
					end = j;
			}
			if (end - start + 1> max)
				max = end - start + 1;
		}
		return max;
    }

    @Override
    public boolean canBalance(int[] array) {
    	int sumLeft = 0;
		int sumRight = 0;
		
		for (int i = 0; i < array.length - 1; i++) {
			sumLeft += array[i];
			
			for (int j = i + 1; j < array.length; j++) {
				sumRight = array[j];
			}
			
			if (sumLeft == sumRight)
				return true;
		}
		return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
    	int i = 0;
		int j = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		int[][] newMatrix = new int[newWidth][newHeight];
		boolean flag = true;
		int smallerMatrixRow = original.length / newHeight;
		int smallerMatrixCol = original.length / newWidth;
		int biggerMatrixRow = newHeight / original.length;
		int biggerMatrixCol = newWidth / original.length;
		
		if (newWidth > original.length) {
			for (int row = 0; row < original.length; row++) {
				for (int col = 0; col < original.length; col++) {
					queue.add(original[row][col]);
				}
			}
			
			for (int k = 0; k < original.length * original.length; k++) {
				for (int newRow = biggerMatrixRow; newRow != 0; newRow--, i++)  {
					for(int newCol = biggerMatrixCol; newCol != 0; newCol--, j++) {
						newMatrix[i][j] = queue.peek().intValue();
					}
					j = j - biggerMatrixCol;
				}
			
				queue.poll();
				if ((j + biggerMatrixRow) == newWidth) {
					j = 0;
				}
				else if (flag) {
					i = i - biggerMatrixCol;
					j += biggerMatrixRow;
				}	
			}
			return newMatrix;
		}
		
		for (int k = 0; k < newWidth * newHeight; k++) {
			int sum = 0;
			for (int row = smallerMatrixRow; row != 0; row-- ,i++) {
				for (int col = smallerMatrixCol; col != 0; col--, j++) {
					sum += original[i][j];
				}
				j = j - smallerMatrixCol;
			}
			
			queue.add(sum / (smallerMatrixCol * smallerMatrixRow));
			
			if ((j + smallerMatrixRow) == original.length) 
				flag = false;
			if (flag) {
				i = i - smallerMatrixCol;
				j += smallerMatrixRow;
			}
			else {
				flag = true;
				j = 0;
			}
		}
		
		for (int row = 0; row < newWidth; row++) {
			for (int col = 0; col < newHeight; col++) {
				newMatrix[row][col] = queue.poll();
			}
		}
		return newMatrix;
    }

    @Override
    public String reverseMe(String argument) {
    	return new StringBuilder(argument).reverse().toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
    	char[] arr = input.toCharArray();
		StringBuilder strBuild = new StringBuilder();
		int j = k;
		
		for (int i = 0; i < arr.length; i++) {
			while (k != 0) {
				strBuild.append(arr[i]);
				k--;
			}
			k = j;
		}
		
		return strBuild.toString();
    }

    @Override
    public String reverseEveryWord(String arg) {
    	String[] words = arg.split(" ");
    	String newStr = " ";
    	
    	for (int i = 0; i < words.length; i++) {
    		newStr += words[i].replace(words[i], new StringBuilder(words[i]).reverse().toString()) + " ";
    	}
    	return newStr.trim();
    }

    @Override
    public boolean isPalindrome(String argument) {
    	String[] arr = argument.split("");
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i].equals(arr[arr.length - 1 -i]))
				continue;
			else 
				return false;
		}
		return true;
    }

    @Override
    public boolean isPalindrome(int number) {
    	String str = Integer.toString(number);
		String[] arr = str.split("");
		
		for (int i = 0; i <= arr.length / 2; i++) { 
			if (arr[i].equals(arr[arr.length - 1 - i]))
				continue;
			else
				return false;
		}
		return true;
    }

    @Override
    public int getPalindromeLength(String input) {
    	String[] arr = input.split("");
		int count = 0;
		
		for (int i = arr.length / 2 - 1, j = arr.length / 2 + 1; i >= 0 || j < arr.length; i--, j++) {
			if (arr[i].equals(arr[j])) {
				count++;
			}
			else 
				break;
		}
		return count;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
    	return haystack.split(needle, -1).length - 1;
    }

    @Override
    public String decodeURL(String input) {
    	return input.replaceAll("%20", " ").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
    	String[] str = input.replaceAll("[^-?0-9]+|(?=-)"," ").trim().split("\\s+");
		int sum = 0;
		for (String s : str) {
			sum += Integer.parseInt(s);
		}
		return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
    	char[] aArr = A.toCharArray();
		char[] bArr = B.toCharArray();
		
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		
		for (int i = 0; i < aArr.length; i++) {
			if (!(aArr[i] == bArr[i]))
				return false;
		}
		return true;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
    	String[] aArr = string.split("");
		Arrays.sort(aArr);
		String sortedA = Arrays.toString(aArr);
		String temp;
		
		for (int i = 0; i <= string2.length() - string.length(); i++) {
			temp = string2.substring(i, i + string.length());
			String[] bArr = temp.split("");
			Arrays.sort(bArr);
			temp = Arrays.toString(bArr);
			
			if (sortedA.equals(temp)) {
				return true;
			}
		}
		
		return false;
    }
    
    //25. Convert to Greyscale
    public void convertToGreyScale(String path) {
		BufferedImage img = null;
		File file = null;
		String dirName;
		String fileName;
		
		//open image
		try {
			file = new File(path);
			img = ImageIO.read(file);
		}catch(IOException e) {
			System.out.println(e);
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		//convert to greyscale
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int pixel = img.getRGB(x, y);
				
				int alpha = (pixel >> 24) & 0xff;
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				int average = (red + green + blue) / 3;
				
				pixel = (alpha << 24) | (average << 16) | (average << 8) | average;
			
				img.setRGB(x, y, pixel);
			}
		}
		
		//write image the new image in same directory with different name
		try {
			dirName = file.getParent();
			fileName = file.getName();
			fileName = "\\Greyscale" + fileName;
			dirName = dirName + fileName;
			file = new File(dirName);
			ImageIO.write(img, "jpg", file);
			System.out.println("File is saved in: " + file.getParent());
			System.out.println("Output file name is: " + file.getName());
		}catch (IOException e) {
			System.out.println(e);
		}
	}

}
