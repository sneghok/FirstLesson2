package Students;

import java.util.ArrayList;
import java.util.List;

import static Students.DbCollectionNames.*;

public class Main {
    public static void main(String[] args) {
        DataBaseImpl.getInstance();
        List<Student> listOfStudents = createStudents();
        System.out.println(DataBaseImpl.INSTANCE.getAllEntities(STUDENTS_DB_COLLECTION));

        createGroups();
        System.out.println(DataBaseImpl.INSTANCE.getAllEntities(GROUPS_DB_COLLECTION));

        createTasks();
        System.out.println(DataBaseImpl.INSTANCE.getAllEntities(TASKS_DB_COLLECTION));

        evaluateStudents(listOfStudents);

        assignStudentsToGroups(listOfStudents);
        System.out.println(DataBaseImpl.INSTANCE.getAllEntities(GROUPS_DB_COLLECTION));
    }

    public static List<Student> createStudents() {
        List<Student> listOfStudents = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Student stud = new Student("Student" + i);
            listOfStudents.add(stud);
            DataBaseImpl.INSTANCE.saveNewEntity(STUDENTS_DB_COLLECTION, stud);
        }
        return listOfStudents;
    }

    public static void createGroups() {
        DataBaseImpl.INSTANCE.saveNewEntity(GROUPS_DB_COLLECTION, new Group("75-100%"));
        DataBaseImpl.INSTANCE.saveNewEntity(GROUPS_DB_COLLECTION, new Group("50-74%"));
        DataBaseImpl.INSTANCE.saveNewEntity(GROUPS_DB_COLLECTION, new Group("25-49%"));
    }

    public static void createTasks() {
        for (int i = 1; i <= 10; i++) {
            DataBaseImpl.INSTANCE.saveNewEntity(TASKS_DB_COLLECTION, new Task());
        }
    }

    public static List<Student> evaluateStudents(List<Student> listOfStudents) {
        int numberOfTasks = DataBaseImpl.INSTANCE.getAllEntities(TASKS_DB_COLLECTION).size();
        for (Student student : listOfStudents) {
            for (int i = 0; i < numberOfTasks; i++) {
                student.completeTask();
            }
        }
        DataBaseImpl.INSTANCE.updateMany(STUDENTS_DB_COLLECTION, new ArrayList<>(listOfStudents));
        return listOfStudents;
    }

    public static void assignStudentsToGroups(List<Student> listOfStudents) {
        for (Student stud : listOfStudents) {
            assignStudentToGroup(stud);
        }
    }

    public static void assignStudentToGroup(Student student) {
        int numberOfTasks = DataBaseImpl.INSTANCE.getAllEntities(TASKS_DB_COLLECTION).size();
        double successRate = student.getNumberOfTasksCompleted() * 100.0 / numberOfTasks;
        Group groupForStudent;
        if (successRate >= 75) {
            groupForStudent = DataBaseImpl.INSTANCE.getGroupByName("75-100%");
        } else if (successRate >= 50) {
            groupForStudent = DataBaseImpl.INSTANCE.getGroupByName("50-74%");
        } else if (successRate >= 25) {
            groupForStudent = DataBaseImpl.INSTANCE.getGroupByName("25-49%");
        } else {
            DataBaseImpl.INSTANCE.deleteEntity(STUDENTS_DB_COLLECTION, student);
            System.out.println("Goodbye, " + student.getStudentName());
            return;
        }
        groupForStudent.getStudentsInGroup().add(student);
        DataBaseImpl.INSTANCE.updateEntity(GROUPS_DB_COLLECTION, groupForStudent);
    }
}
