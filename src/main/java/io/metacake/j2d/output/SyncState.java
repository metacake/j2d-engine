package io.metacake.j2d.output;

import io.metacake.core.output.RenderingInstruction;

import java.util.Collection;
import java.util.Collections;

/**
 * @author florence
 * @author rpless
 */
class SyncState {
    private volatile Collection<RenderingInstruction> s = Collections.emptyList();

    public void setState(Collection<RenderingInstruction> s) {
        this.s = s;
    }

    public Collection<RenderingInstruction> getState() {
        return s;
    }
}