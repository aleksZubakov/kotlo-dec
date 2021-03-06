package ir.tree.visitors

import ir.tree.nodes.IRNode
import ir.tree.nodes.Locals
import ir.tree.nodes.op.Expression
import ir.tree.nodes.op.OperatorType

interface VisitorInterface<out T> {
    fun visitIfNode(condition: IRNode, body: IRNode, elseBody: IRNode): T

    fun visitBasicBlock(regions: List<IRNode>): T

    fun visitWhileNode(condition: IRNode, body: IRNode): T

    fun visitAssignmentLocal(lvalue: Locals.Local, rvalue: Expression): T

    fun visitIntConstant(value: Int): T

    fun visitLongConstant(value: Long): T

    fun visitLocalAccess(localRef: Locals.Local): T

    fun visitDoubleConstant(value: Double): T

    fun visitFloatConstant(value: Float): T

    fun visitIncrement(local: Locals.Local, value: Int): T

    fun visitObjConstant(value: Any?): T

    fun visitNumberCompare(left: Expression, right: Expression): T

    fun visitBinaryOp(left: Expression, op: OperatorType, right: Expression): T

    fun visitNegativeOp(ins: Expression): T

    fun visitReturn(op: Expression): T
}