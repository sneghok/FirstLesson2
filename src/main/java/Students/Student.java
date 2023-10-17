package Students;

import lombok.Data;

import java.util.Random;

@Data
public class Student extends ObjectWithData {
    String studentName;
    int numberOfTasksCompleted;

    public Student(String studentName) {
        this.studentName = studentName;
        numberOfTasksCompleted = 0;
    }

    public void completeTask() {
        Random random = new Random();
        int result = random.nextInt(12);
        if (result > 5) {
            numberOfTasksCompleted++;
        }
    }
}
