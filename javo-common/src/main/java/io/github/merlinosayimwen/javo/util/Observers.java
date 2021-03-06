// Copyright 2019 Merlin Osayimwen. All rights reserved.
// Use of this source code is governed by a MIT-style
// license that can be found in the LICENSE file.

package io.github.merlinosayimwen.javo.util;

import java.util.Observable;
import java.util.Observer;

public final class Observers {
  private Observers() {}

  public static Observer fromRunnable(Runnable action) {
    return new RunnableDelegatingObserver(action);
  }

  private static class RunnableDelegatingObserver implements Observer {
    private final Runnable action;

    private RunnableDelegatingObserver(Runnable action) {
      this.action = action;
    }

    @Override
    public void update(Observable entity, Object attribute) {
      this.action.run();
    }
  }
}
