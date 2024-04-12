package models;

import java.util.Objects;

public class Position {
    int positionId;

    String positionName;

    public Position() {

    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionId, positionName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionId == position.positionId && Objects.equals(positionName, position.positionName);
    }
}