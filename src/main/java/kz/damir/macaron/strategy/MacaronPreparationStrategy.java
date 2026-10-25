package kz.damir.macaron.strategy;

import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.model.PreparationResult;

/** Common algorithm contract for interchangeable macaron recipes. */
public interface MacaronPreparationStrategy {
    PreparationResult prepare(MacaronOrder order);
}
