import java.util.Date;

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
	private static final Exception IllegalArgumentException=null;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students){
		// Add your implementation here
		if(students==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>students.length-1)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null ||(index<0 || index>students.length-1))
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Student []stud=new Student[students.length+1];
		stud[0]=student;
		for(int i=0;i<students.length;i++)
		{
			stud[i+1]=students[i];
		}
		students=stud;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Student []stud=new Student[students.length+1];
		stud[stud.length-1]=student;
		for(int i=0;i<students.length;i++)
		{
			stud[i]=students[i];
		}
		students=stud;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null ||(index<0 || index>students.length-1))
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Student []stud=new Student[students.length+1];
		int i;
		for(i=0;i<index;i++)
		{
			stud[i]=students[i];
		}
		stud[i]=student;
		while(i<students.length) {
			stud[i+1]=students[i];
			i++;
		}
		students=stud;
		
		
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>students.length-1)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Student []stud=new Student[students.length-1];
		int i;
		for(i=0;i<index;i++)
		{
			stud[i]=students[i];
		}
		for(i=index+1;i<students.length;i++)
		{
			stud[i-1]=students[i];
		}
		students=stud;
		
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int flag=0,i;
		Student [] stud=new Student[students.length-1];
		for(i=0;i<students.length;i++)
		{
			if(student==students[i])
			{
				flag=1;
				break;
			}
			else
				stud[i]=students[i];
		}
		if(flag==0)
			try {
				throw IllegalArgumentException("Student not exist");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
		{
			i++;
			while(i<students.length)
			{
				stud[i-1]=students[i];
				i++;
			}
			students=stud;
		}
	}

	private Exception IllegalArgumentException(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		return null;
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>students.length-1)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Student [] stud=new Student[index+1];
		for(int i=0;i<=index;i++)
			stud[i]=students[i];
		students=stud;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int count=0;
		while(student!=students[count])
			count++;
		Student [] stud=new Student[count+1];
		for(int i=0;i<count+1;i++)
			stud[i]=students[i];
		students=stud;
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>students.length-1)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Student [] stud=new Student[students.length-index];
		int temp=0;
		for(int i=index;i<students.length;i++)
		{
			stud[temp]=students[i];
			temp=temp+1;
		}
		students=stud;
	}

	@Override
	public void removeToElement(Student student) {
		if(student==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int index=0;
		while(students[index]!=student)
			index++;
		index++;
		int temp=0;
		Student [] stud=new Student[students.length-index];
		for(int i=index;i<students.length;i++)
		{
			stud[temp]=students[i];
			temp=temp+1;
		}
		students=stud;
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++)
			for(int j=0;j<students.length-i-1;j++)
			{
				if(students[j].getBirthDate().compareTo(students[j+1].getBirthDate())>0)
				{
					Student temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
				}
			}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if(date==null)
			try {
				throw IllegalArgumentException;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int count=0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().compareTo(date)<=0)
				count++;
		Student []stud=new Student[count];
		int index=0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().compareTo(date)<=0) {
				stud[index]=students[i];
				index++;
			}
		return stud;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
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
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
