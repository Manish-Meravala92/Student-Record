package studentdata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class StudentExamResult {
	private static Scanner scanner;
	int iNoOfSubjects = StudentConstants.NO_OF_SUBJECTS;

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {
		char option;
		scanner = new Scanner(System.in);
		ArrayList<Record> alRecord = new ArrayList<Record>();
		StudentExamResult examResult = new StudentExamResult();
		do {
			alRecord = examResult.enterStudentData(alRecord);
			System.out.println("Do you want to continue?(y/n)");
			option = scanner.next().charAt(0);
		} while (option == 'y' || option == 'Y');

		System.out.println("Before sorting:");
		for (int i = 0; i < alRecord.size(); i++)
			System.out.println(alRecord.get(i));

		Collections.sort(alRecord, new Record());

		System.out.println("After sorting:");
		for (int i = 0; i < alRecord.size(); i++)
			System.out.println(alRecord.get(i));

	}

	public ArrayList<Record> enterStudentData(ArrayList<Record> alRecord) {
		try {
			int iTempMarks;
			int iTotalMarks = 0;
			String status = "PASSED!!!";
			double percent = 0.0;
			ArrayList<Integer> alMarksOfEachSubjects = new ArrayList<Integer>();
			System.out.println("Enter the First name of student:");
			String sFirstName = scanner.next();
			System.out.println("Enter the Last name of student:");
			String sLastName = scanner.next();
			System.out.println("Enter the marks of students:");
			for (int iSubjectCnt = 0; iSubjectCnt < iNoOfSubjects; iSubjectCnt++) {
				iTempMarks = this.validate(scanner.nextInt());
				alMarksOfEachSubjects.add(iTempMarks);
				iTotalMarks += iTempMarks;
				if (iTempMarks < 40) {
					status = "FAIL";
				}
			}
			percent = (iTotalMarks / iNoOfSubjects);
			Record objRecord = new Record<Object>(sFirstName, sLastName, alMarksOfEachSubjects, iTotalMarks, percent);
			alRecord.add(objRecord);
			System.out.println(status);
			System.out.println(objRecord);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return alRecord;
	}

	public int validate(int iMarks) {
		try {
			while (iMarks < 0 || iMarks > 100) {
				System.out.println("Invalid!!!Re-enter marks");
				iMarks = scanner.nextInt();
				if (iMarks >= 0 && iMarks <= 100) {
					return iMarks;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return iMarks;
	}
}