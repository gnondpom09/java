package interfaces;

import java.util.List;


public interface DAOCRUD <Analogique>{
	public boolean create(Analogique c); 
	public boolean delete(Object key); 
	public boolean update(Analogique c);

	public Analogique read(Object key);
	public List<Analogique> readAll();
}
