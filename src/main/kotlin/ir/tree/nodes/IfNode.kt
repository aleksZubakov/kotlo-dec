package ir.tree.nodes

import ir.transformer.Transformer
import org.objectweb.asm.Label

class IfNode(val condition: TreeNode, val body: TreeNode,
             val elseBody: TreeNode?): TreeNode {

    override fun transform(transformer: Transformer): TreeNode {
        return transformer.visitIfNode(condition, body, elseBody)
    }

    override fun label(): Label {
        return condition.label()
    }
}