package studentdata;
import java.util.ArrayList;
import java.util.Comparator;

public class Record<T> implements Comparator<T> {
	private String Fname;
	private String Lname;
	private ArrayList<Integer> alMarksOfEachSubjects;
	private int total;
	private double percent;

	public Record(String Fname, String Lname, ArrayList<Integer> alMarksOfEachSubjects, int total, double percent) {
		this.Fname = Fname;
		this.Lname = Lname;
		this.alMarksOfEachSubjects = alMarksOfEachSubjects;
		this.total = total;
		this.percent = percent;
	}

	public Record() {
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public ArrayList<Integer> getAlSub() {
		return alMarksOfEachSubjects;
	}

	public void setAlSub(ArrayList<Integer> alMarksOfEachSubjects) {
		this.alMarksOfEachSubjects = alMarksOfEachSubjects;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "Record [Fname=" + Fname + ", Lname=" + Lname + ", Subjects=" + alMarksOfEachSubjects.toString()
				+ ", total=" + total + ", percent=" + percent + "]";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compare(T o1, T o2) {
		Record r1 = (Record) o1;
		Record r2 = (Record) o2;
		return (r1.Fname).compareTo(r2.Fname);
	}

}
