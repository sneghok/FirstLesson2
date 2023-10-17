package Students;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group extends ObjectWithData {
    String groupName;
    List<Student> studentsInGroup = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }
}
