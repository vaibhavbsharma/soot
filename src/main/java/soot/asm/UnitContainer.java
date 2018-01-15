/* Soot - a J*va Optimization Framework
 * Copyright (C) 1997-2014 Raja Vallee-Rai and others
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

package soot.asm;

import soot.Unit;
import soot.UnitBox;
import soot.UnitPrinter;
import soot.ValueBox;
import soot.tagkit.Host;
import soot.tagkit.Tag;
import soot.util.Switch;

import java.util.List;

/**
 * A psuedo unit containing different units.
 *
 * @author Aaloan Miftah
 */
@SuppressWarnings("serial")
class UnitContainer implements Unit {

  final Unit[] units;

  UnitContainer(Unit... units) {
    this.units = units;
  }

  /**
   * Searches the depth of the UnitContainer until the actual first Unit represented is found.
   *
   * @return
   */
  Unit getFirstUnit() {
    Unit ret = units[0];
    while (ret instanceof UnitContainer) {
      ret = ((UnitContainer) ret).units[0];
    }
    return ret;
  }

  @Override
  public Object clone() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void apply(Switch sw) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Tag> getTags() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Tag getTag(String aName) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addTag(Tag t) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void removeTag(String name) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean hasTag(String aName) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void removeAllTags() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addAllTagsOf(Host h) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<ValueBox> getUseBoxes() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<ValueBox> getDefBoxes() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<UnitBox> getUnitBoxes() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<UnitBox> getBoxesPointingToThis() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addBoxPointingToThis(UnitBox b) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void removeBoxPointingToThis(UnitBox b) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void clearUnitBoxes() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<ValueBox> getUseAndDefBoxes() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean fallsThrough() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean branches() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void toString(UnitPrinter up) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void redirectJumpsToThisTo(Unit newLocation) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int getJavaSourceStartLineNumber() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int getJavaSourceStartColumnNumber() {
    throw new UnsupportedOperationException();
  }
}
