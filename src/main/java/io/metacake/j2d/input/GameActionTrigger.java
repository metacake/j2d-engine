package io.metacake.j2d.input;

import io.metacake.core.input.ActionTrigger;

public abstract class GameActionTrigger<T> implements ActionTrigger<T> {
    private long timestamp = 0;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}