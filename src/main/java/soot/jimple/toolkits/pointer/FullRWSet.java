/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Ondrej Lhotak
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.jimple.toolkits.pointer;

import java.util.Set;

import soot.PointsToSet;
import soot.SootField;

public class FullRWSet extends RWSet {

  @Override
  public int size() {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public boolean getCallsNative() {
    return true;
  }

  @Override
  public boolean setCallsNative() {
    throw new RuntimeException("Unsupported");
  }

  /** Returns an iterator over any globals read/written. */
  @Override
  public Set getGlobals() {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public Set getFields() {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public PointsToSet getBaseForField(Object f) {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public boolean hasNonEmptyIntersection(RWSet other) {
    return other != null;
  }
  /** Adds the RWSet other into this set. */
  @Override
  public boolean union(RWSet other) {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public boolean addGlobal(SootField global) {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public boolean addFieldRef(PointsToSet otherBase, Object field) {
    throw new RuntimeException("Unsupported");
  }

  @Override
  public boolean isEquivTo(RWSet other) {
    return other instanceof FullRWSet;
  }
}
