/* Soot - a J*va Optimization Framework
 * Copyright (C) 1999 Patrick Lam, Patrick Pominville and Raja Vallee-Rai
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

/*
 * Modified by the Sable Research Group and others 1997-1999.
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */

package soot.baf.internal;

import soot.ArrayType;
import soot.UnitPrinter;
import soot.baf.InstSwitch;
import soot.baf.NewMultiArrayInst;
import soot.util.Switch;

public class BNewMultiArrayInst extends AbstractInst implements NewMultiArrayInst {
  int dimensionCount;

  ArrayType baseType;

  public BNewMultiArrayInst(ArrayType opType, int dimensionCount) {
    this.dimensionCount = dimensionCount;
    baseType = opType;
  }

  @Override
  public int getInCount() {
    return dimensionCount;
  }

  @Override
  public int getOutCount() {
    return 1;
  }

  @Override
  public int getInMachineCount() {
    return dimensionCount;
  }

  @Override
  public int getOutMachineCount() {
    return 1;
  }

  @Override
  public Object clone() {
    return new BNewMultiArrayInst(getBaseType(), getDimensionCount());
  }

  @Override
  public final String getName() {
    return "newmultiarray";
  }

  @Override
  final String getParameters() {
    return " " + dimensionCount;
  }

  @Override
  protected void getParameters(UnitPrinter up) {
    up.literal(" ");
    up.literal(new Integer(dimensionCount).toString());
  }

  @Override
  public ArrayType getBaseType() {
    return baseType;
  }

  @Override
  public void setBaseType(ArrayType type) {
    baseType = type;
  }

  @Override
  public int getDimensionCount() {
    return dimensionCount;
  }

  @Override
  public void setDimensionCount(int x) {
    x = dimensionCount;
  }

  @Override
  public void apply(Switch sw) {
    ((InstSwitch) sw).caseNewMultiArrayInst(this);
  }

  @Override
  public boolean containsNewExpr() {
    return true;
  }
}
