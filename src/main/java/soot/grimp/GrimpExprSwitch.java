/* Soot - a J*va Optimization Framework
 * Copyright (C) 1999 Patrick Lam
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

package soot.grimp;

import soot.jimple.AddExpr;
import soot.jimple.AndExpr;
import soot.jimple.CastExpr;
import soot.jimple.CmpExpr;
import soot.jimple.CmpgExpr;
import soot.jimple.CmplExpr;
import soot.jimple.DivExpr;
import soot.jimple.EqExpr;
import soot.jimple.ExprSwitch;
import soot.jimple.GeExpr;
import soot.jimple.GtExpr;
import soot.jimple.InstanceOfExpr;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.LeExpr;
import soot.jimple.LengthExpr;
import soot.jimple.LtExpr;
import soot.jimple.MulExpr;
import soot.jimple.NeExpr;
import soot.jimple.NegExpr;
import soot.jimple.NewArrayExpr;
import soot.jimple.NewExpr;
import soot.jimple.NewMultiArrayExpr;
import soot.jimple.OrExpr;
import soot.jimple.RemExpr;
import soot.jimple.ShlExpr;
import soot.jimple.ShrExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.SubExpr;
import soot.jimple.UshrExpr;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.XorExpr;

public interface GrimpExprSwitch extends ExprSwitch {
  @Override
  void caseAddExpr(AddExpr v);

  @Override
  void caseAndExpr(AndExpr v);

  @Override
  void caseCmpExpr(CmpExpr v);

  @Override
  void caseCmpgExpr(CmpgExpr v);

  @Override
  void caseCmplExpr(CmplExpr v);

  @Override
  void caseDivExpr(DivExpr v);

  @Override
  void caseEqExpr(EqExpr v);

  @Override
  void caseNeExpr(NeExpr v);

  @Override
  void caseGeExpr(GeExpr v);

  @Override
  void caseGtExpr(GtExpr v);

  @Override
  void caseLeExpr(LeExpr v);

  @Override
  void caseLtExpr(LtExpr v);

  @Override
  void caseMulExpr(MulExpr v);

  @Override
  void caseOrExpr(OrExpr v);

  @Override
  void caseRemExpr(RemExpr v);

  @Override
  void caseShlExpr(ShlExpr v);

  @Override
  void caseShrExpr(ShrExpr v);

  @Override
  void caseUshrExpr(UshrExpr v);

  @Override
  void caseSubExpr(SubExpr v);

  @Override
  void caseXorExpr(XorExpr v);

  @Override
  void caseInterfaceInvokeExpr(InterfaceInvokeExpr v);

  @Override
  void caseSpecialInvokeExpr(SpecialInvokeExpr v);

  @Override
  void caseStaticInvokeExpr(StaticInvokeExpr v);

  @Override
  void caseVirtualInvokeExpr(VirtualInvokeExpr v);

  void caseNewInvokeExpr(NewInvokeExpr v);

  @Override
  void caseCastExpr(CastExpr v);

  @Override
  void caseInstanceOfExpr(InstanceOfExpr v);

  @Override
  void caseNewArrayExpr(NewArrayExpr v);

  @Override
  void caseNewMultiArrayExpr(NewMultiArrayExpr v);

  @Override
  void caseNewExpr(NewExpr v);

  @Override
  void caseLengthExpr(LengthExpr v);

  @Override
  void caseNegExpr(NegExpr v);

  @Override
  void defaultCase(Object obj);
}
