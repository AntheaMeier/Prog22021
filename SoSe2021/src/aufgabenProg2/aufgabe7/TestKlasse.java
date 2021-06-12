package aufgabenProg2.aufgabe7;

public class TestKlasse {

	public static void main(String[] args) 
	{
		final int NR_OF_STUDENTS = 5;
        Slack slack = new Slack();

        Student[] students = new Student[NR_OF_STUDENTS]; // Array mit 5 Stundenten
        Character c = 'A';
        for(int index=0; index < students.length; index++)
        {
            students[index] = new Student(c.toString()); //weist dem ersten Student den Buchstaben A als name zu.
            c++; // der nächste wird dan B usw.
            students[index].setPublisher(slack);
        }
        slack.publishNews();

        System.out.println();
        students[1].removePublisher(slack);
        students[3].removePublisher(slack);
        System.out.println();
        slack.publishNews();

        System.out.println();
        students[1].setPublisher(slack);
        students[2].removePublisher(slack);
        students[4].removePublisher(slack); 
        System.out.println();
        slack.publishNews();

        System.out.println();
        students[0].removePublisher(slack);
        students[1].removePublisher(slack);
        students[3].setPublisher(slack);
        System.out.println();
        slack.publishNews();
    }
}
