package stack;

public class Data {
	private int intData;

	public Data() {
		super();
		this.intData=0;
	}

	public Data(int intData) {
		super();
		this.intData = intData;
	}

	public int getIntData() {
		return intData;
	}

	public void setIntData(int intData) {
		this.intData = intData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intData;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (intData != other.intData)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [intData=" + intData + "]";
	}
}
