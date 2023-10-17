package Students;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class ObjectWithData {
    private UUID id;

    protected ObjectWithData() {
        setId(UUID.randomUUID());
    }
}
