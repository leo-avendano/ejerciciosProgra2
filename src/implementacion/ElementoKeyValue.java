package implementacion;

public class ElementoKeyValue {
	String key;
	int value;
	
	public ElementoKeyValue(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public void setValue(int x) {
		this.value = x;
	}
	
	public void setKey(String s) {
		this.key = s;
	}
}
