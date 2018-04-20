package ir.tree.nodes

import ir.transformer.Transformer
import org.objectweb.asm.Label
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.LabelNode

class UndoneNode(val insnList: List<AbstractInsnNode>) : TreeNode {
    override fun transform(transformer: Transformer): TreeNode {
        return transformer.visitUndoneNode(insnList)
    }

    override fun label(): Label {
        if (insnList.isNotEmpty() && insnList[0] is LabelNode) {
            return (insnList[0] as LabelNode).label
        }

        return Label()
    }
}