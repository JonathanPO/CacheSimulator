import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Simulator {
	public static int num_lines_mem;
	public static int map_type;
	public static int map_policy;
	public static Cache cache = new Cache();
	
	public static void main(String[] args) throws IOException {
		readFile();
		readCommand();
	}
	
	public static void readFile() throws NumberFormatException, IOException{
		File file = new File("src/config.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		
		//READING THE FILE AND WRITING IN THE PROPER LOCATIONS
		cache.setBlock_size(Integer.parseInt(bufferedReader.readLine()));
		cache.setLine_num(Integer.parseInt(bufferedReader.readLine()));
		
		num_lines_mem = Integer.parseInt(bufferedReader.readLine());
		map_type = Integer.parseInt(bufferedReader.readLine());
		
		cache.setNum_conj(Integer.parseInt(bufferedReader.readLine()));
		
		map_policy = Integer.parseInt(bufferedReader.readLine());
	}
	
	public static void readCommand(){
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		
		if(command.equals("read")){
			System.out.println("Digite o endereço a ser lido: ");
			int adr = scanner.nextInt();
			read(adr);
		}
		
		if(command.equals("write")){
			System.out.println("Digite o endereço a ser escrito: ");
			int adr = scanner.nextInt();
			System.out.println("Digite o valor a ser escrito: ");
			int value = scanner.nextInt();
			write(adr, value);
		}
		
		if(command.equals("show")){
			show();
		} else{
			System.out.println("COMANDO INVÁLIDO");
		}
	}
	
	public static String read(int adr){
		//DIRETO
		if(map_type == 1){
			int value = adr/cache.getBlock_size();
			int line = value;
			
			if(line > cache.getLine_num()){
				line = line % cache.getBlock_size();
			}
			
			if((cache.getLines().get(line)) == value){
				return "HIT";
			} else{
				cache.getLines().add(line, value);
			}
		}
		
		//TOTALMENTE ASSOCIATIVO
		if(map_type == 2){
			
		}
		//PARCIALMENTE ASSOCIATIVO
		if(map_type == 3){
			
		}
		
		return "MISS";
	}
	
	public static String write(int adr, int value){
		//DIRETO
		if(map_type == 1){
			int line = adr/cache.getBlock_size();
			
			if(line > cache.getLine_num()){
				line = line % cache.getBlock_size();
			}
			
			if((cache.getLines().get(line)) == value){
				return "HIT";
			} else{
				cache.getLines().add(line, value);
			}
		}
		
		//TOTALMENTE ASSOCIATIVO
				
		//PARCIALMENTE ASSOCIATIVO
		
		return "MISS";
	}
	
	public static void substitute(int adr, int value){
		//RANDOM
		
		//FIFO
		
		//LFU
		
		//LRU
	}
	
	public static void show(){
		System.out.println(cache.showCache());
	}
}
