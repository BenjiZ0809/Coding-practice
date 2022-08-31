
public class MoreStrings {

	public static void main(String[] args) {
		String s1 = "Welcome to Java";
		String s2 = new String("Programming is fun");
		String s3 = "Java Java Java";
		
		System.out.println(s1.replace("e", "2"));
		System.out.println(s3.replaceFirst("Java", "Ben"));
		System.out.println(s3.replaceAll("Java","Ben"));
		
		System.out.println("Java is fun".matches("Java.*"));
		
		System.out.println("646-658-4425".matches("[0-9]{3}-[0-9]{3}-[0-9]{4}"));
		
		char[] chars = s2.toCharArray();
		for(int i=0; i<chars.length; i++) {
			System.out.println(chars[i]);
		}
 		
		String s4 = 55+"";
		System.out.println(s4);
		
		
	}

}
