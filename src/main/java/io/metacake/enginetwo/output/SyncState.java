package io.metacake.enginetwo.output;

import io.metacake.core.output.RenderingInstruction;

import java.util.Collections;
import java.util.List;

/**
 * @author florence
 * @author rpless
 */
class SyncState {
    private volatile List<RenderingInstruction> s = Collections.emptyList();

    public void setState(List<RenderingInstruction> s) {
        this.s = s;
    }

    public List<RenderingInstruction> getState() {
        return s;
    }
}