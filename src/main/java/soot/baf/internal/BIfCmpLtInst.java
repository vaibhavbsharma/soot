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

import soot.AbstractJasminClass;
import soot.Type;
import soot.Unit;
import soot.baf.Baf;
import soot.baf.IfCmpLtInst;
import soot.baf.InstSwitch;
import soot.util.Switch;

public class BIfCmpLtInst extends AbstractOpTypeBranchInst implements IfCmpLtInst {
  public BIfCmpLtInst(Type opType, Unit target) {
    super(opType, Baf.v().newInstBox(target));
  }

  @Override
  public int getInCount() {
    return 2;
  }

  @Override
  public Object clone() {
    return new BIfCmpLtInst(getOpType(), getTarget());
  }

  @Override
  public int getInMachineCount() {
    return 2 * AbstractJasminClass.sizeOfType(getOpType());
  }

  @Override
  public int getOutCount() {
    return 0;
  }

  @Override
  public int getOutMachineCount() {
    return 0;
  }

  @Override
  public String getName() {
    return "ifcmplt";
  }

  @Override
  public void apply(Switch sw) {
    ((InstSwitch) sw).caseIfCmpLtInst(this);
  }
}
