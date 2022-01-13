
public class Vignere {
	static char[] todo = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static void main(String[] args) {
		String texto = args[0];
		String palabra = args[1];
		int tipo = Integer.parseInt(args[2]);
		printTabla();
		int index = 0;
		for(char caracter : texto.toCharArray()) {
			System.out.print(caracter);
		}
		System.out.println();
		String lastFormated = "";
		String lineaAbajo = "";
		int space = texto.split(" ")[0].length();
		for(char caracter : texto.replaceAll("\\s+","").toCharArray()) {
			char cosas = getLetra(Character.toLowerCase(palabra.toCharArray()[index%(palabra.length())]),Character.toLowerCase(caracter));
			lineaAbajo+=getLetra(Character.toLowerCase(palabra.toCharArray()[index%(palabra.length())]),Character.toLowerCase(caracter));
			System.out.print(palabra.toCharArray()[index%(palabra.length())]);
			if(caracter!=' ') {
				index++;
				lastFormated+=cosas;
			}
			if(0==(index%(space))) {
				lineaAbajo+=" ";
				System.out.print(" ");
				}

			if(0==(index%(palabra.length()))) {
				if(tipo==1) {
					palabra = lastFormated;		
					lastFormated = "";
				}

			}
			
		}
		System.out.println();
		System.out.println(lineaAbajo);
		

	
	}
	private static char getLetra(char key, char cifrado) {
		int offset = ((int)key)-97;
		//System.out.println(offset);
		int num = getIndex(todo, cifrado);
		if(num!=-1) {
			//System.out.println("Para letra cirada "+cifrado+" -> "+num+" "+todo[num]);
			//System.out.println();
			//System.out.println("Tenemos key "+key+" con offset "+offset+" index final "+((todo.length-offset)+num)%todo.length);
			return todo[((todo.length-offset)+num)%todo.length];
			
		}
		return ' ';
		
	}
	
	private static int getIndex(char[] filaComun2, char d) {
		boolean encontrado = false;
		int ret = -1;
		//System.out.println("Buscando a "+d+" en "+filaComun2);
		for(int x = 0; x < filaComun2.length && !encontrado; x++) {
			if(filaComun2[x]==d) {
				encontrado = true;
				ret = x;
			}
			
		}
		//System.out.println("Esta en "+ret);
		return ret;
	}
	
	private static void printTabla() {
		System.out.print("\t| ");
		for(char carac : todo) {
			System.out.print(carac+"\t");
		}
		System.out.println();
		for(char carac : todo) {
			System.out.print("_\t");
		}
		System.out.println();
		int offset = 0;
		for(char carac : todo) {
			System.out.print(carac+"\t| ");
			for(int x = 0; x < todo.length;x++) {
				int num = (x+offset)%todo.length;
				System.out.print(todo[num]+"\t");
			}
			offset++;
			System.out.println();
		}
		System.out.println();
		
	}
}
