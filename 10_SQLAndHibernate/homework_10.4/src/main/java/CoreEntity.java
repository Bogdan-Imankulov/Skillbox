import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public abstract class CoreEntity {
    @Getter
    @Setter
    protected int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreEntity that = (CoreEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
