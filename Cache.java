import java.util.ArrayList;
import java.util.List;

public class Cache {
	private int block_size;
	private int line_num;
	private int num_conj;
	private List<Integer> lines;
	
	public Cache(){
		lines = new ArrayList<Integer>();
	}

	public int getBlock_size() {
		return block_size;
	}

	public void setBlock_size(int block_size) {
		this.block_size = block_size;
	}

	public int getLine_num() {
		return line_num;
	}

	public void setLine_num(int line_num) {
		this.line_num = line_num;
	}

	public int getNum_conj() {
		return num_conj;
	}

	public void setNum_conj(int num_conj) {
		this.num_conj = num_conj;
	}

	public List<Integer> getLines() {
		return lines;
	}

	public void setLines(List<Integer> lines) {
		this.lines = lines;
	}
	
	public String showCache(){
		String cache = "";
		int i=0;
		
		for(Integer line : this.lines){
			cache += i + " - " + line + "\n";
			i++;
		}
		
		return cache;
	}
}
