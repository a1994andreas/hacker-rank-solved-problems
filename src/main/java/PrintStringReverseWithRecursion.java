public class PrintStringReverseWithRecursion {
	public static void main(String[] args) {
		System.out.println(printReverse("test"));
	}

	public static String printReverse(String str){
		if(str.length() ==0)
			return str;
		return str.charAt(str.length()-1)+ printReverse(str.substring(0,str.length()-1)) ;
	}
}
