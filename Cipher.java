
public class Cipher {
	int value = 2;
	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
	String input = "security";
	String key = "hola";
	
	
	public int findIndex(char x){
		int a = 0;
		for(int i = 0; i < alphabet.length; i++){
			if(x == alphabet[i]){
				a = i;
				break;
			}
		}
		return a;
	}
	
	public void encryptCeasar(){
		String temp = "";
		for(int i = 0; i < input.length(); i++){
			int x = findIndex(input.charAt(i));
			temp = temp + alphabet[(x+value)%alphabet.length];
		}
		input = temp;
	}
	
	public void decryptCeasar(){
		String temp = "";
		for(int i = 0; i < input.length(); i++){
			int x = findIndex(input.charAt(i));
			temp = temp + alphabet[(x+(alphabet.length-value))%alphabet.length];
		}
		input = temp;
	}
	
	public void vigenere(){
		String temp = "";
		int index = 0;
		for(int i = 0; i < input.length(); i++){
			int x = findIndex(input.charAt(i));
			int y = findIndex(key.charAt(index%key.length()));
			temp = temp + alphabet[(x + y)%alphabet.length];
			index++;
		}
		input = temp;
	}
	
	public void devigenere(){
		String temp = "";
		int index = 0;
		for(int i = 0; i < input.length(); i++){
			int x = findIndex(input.charAt(i));
			int y = findIndex(key.charAt(index%key.length()));
			temp = temp + alphabet[(x + (alphabet.length - y) )%alphabet.length];
			index++;
		}
		input = temp;
	}

	public static void main(String[] args) {
		Cipher a = new Cipher();
		a.encryptCeasar();
		System.out.println(a.input);
		a.decryptCeasar();
		System.out.println(a.input);
		a.vigenere();
		System.out.println(a.input);
		a.devigenere();
		System.out.println(a.input);
	}

}
