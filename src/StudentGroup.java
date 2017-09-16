import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		int i=0;
		if(students == null)
			throw new IllegalArgumentException();
		for(Student s:students){
		  this.students[i++]=s; 
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		if(student==null)
			throw new IllegalArgumentException();
		students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
        students[0]=student;
        
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
         students[students.length+1]=new Student(student);
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		if(student==null)
			throw new IllegalArgumentException();
		students[students.length+1]=new Student(student);
		for(int i=students.length;i>index;i--)
			students[i]=students[i-1];
		students[index]=student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>(Arrays.asList(students));
		l.remove(students[index]);
		students=l.toArray(students);
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>(Arrays.asList(students));
		l.remove(student);
		students=l.toArray(students);
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>(Arrays.asList(students));
		for(int i=index;i<students.length;i++){
		l.remove(students[index]);
		}
		students=l.toArray(students);
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>(Arrays.asList(students));
		int i=0;
		for(i=0;i<students.length;i++){
		  if(students[i].equals(student)){
			  break;
		  }
		}
		for(int j=i;j<students.length;i++){
			l.remove(students[j]);
			}
		students=l.toArray(students);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>students.length)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>(Arrays.asList(students));
		for(int i=0;i<index;i++){
			l.remove(students[i]);
		}
		students=l.toArray(students);
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>(Arrays.asList(students));
		int i=0;
		for(i=0;i<students.length;i++){
		  if(students[i].equals(student)){
			 break;
		  }
		  else{
			  l.remove(students[i]);
		  }
		}
	
	    students=l.toArray(students);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int i, j;
		int n=students.length;
		   for (i = 0; i < n-1; i++){   
		       for (j = 0; j < n-i-1; j++){ 
		           if (students[i].compareTo(students[j])>0)
		           {
		        	   Student temp=students[i];
		        	   students[i]=students[j];
		        	   students[j]=temp;
		           }
		       }
		   }     
		       
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>();
		for(int i=0;i<students.length;i++){
			if(students[i].getBirthDate()==date){
				l.add(students[i]);
			}
		}
		
		Student s[] = null;
		return l.toArray(s);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null || lastDate==null)
			throw new IllegalArgumentException();
		List<Student> l=new ArrayList<Student>();
		for(int i=0;i<students.length;i++){
			if(students[i].getBirthDate().compareTo(firstDate)>0&&students[i].getBirthDate().compareTo(firstDate)<0){
				l.add(students[i]);
			}
		}
		
		Student s[] = null;
		return l.toArray(s);
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
	    
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		int sum=0;
		for(int i=0;i<students.length;i++){
			sum+=students[i].getAvgMark();
		}
		sum=sum/students.length;
		List<Student> l=new ArrayList<Student>();
		for(Student s:students){
			if(s.getAvgMark()>sum){
				l.add(s);
			}
		}
		Student s[]=null;
		return l.toArray(s);
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		int i,flag=0;
		for(i=0;i<students.length;i++){
			if(students[i].equals(student)){
				flag=1;
				break;
			}
		}
	   if(flag==0)
		   throw new IllegalArgumentException();
	return students[i+1];
	}
}
