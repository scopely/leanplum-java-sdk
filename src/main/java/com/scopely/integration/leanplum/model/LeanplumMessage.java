package com.scopely.integration.leanplum.model;

public class LeanplumMessage {
    private long id;
    private String name;
    private boolean active;
    private float created;
    private float finished;
    private String messageType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getCreated() {
        return created;
    }

    public void setCreated(float created) {
        this.created = created;
    }

    public float getFinished() {
        return finished;
    }

    public void setFinished(float finished) {
        this.finished = finished;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeanplumMessage that = (LeanplumMessage) o;

        if (id != that.id) return false;
        if (active != that.active) return false;
        if (Float.compare(that.created, created) != 0) return false;
        if (Float.compare(that.finished, finished) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(messageType != null ? !messageType.equals(that.messageType) : that.messageType != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (created != +0.0f ? Float.floatToIntBits(created) : 0);
        result = 31 * result + (finished != +0.0f ? Float.floatToIntBits(finished) : 0);
        result = 31 * result + (messageType != null ? messageType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LeanplumMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", created=" + created +
                ", finished=" + finished +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
