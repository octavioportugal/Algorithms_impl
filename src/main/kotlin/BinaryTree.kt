// TreeNode class representing a node in a binary tree
class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// Function to invert a binary tree
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        root?.let {
            val right = invertTree(it.right)  // Recursively invert the right subtree
            val left = invertTree(it.left)    // Recursively invert the left subtree

            it.right = left  // Swap the left and right children
            it.left = right

            return it         // Return the current (inverted) node
        } ?: return null       // Base case: if the node is null, return null
    }
}

// Function to print the left and right children of a given TreeNode
fun printChildren(node: TreeNode?) {
    node?.let {
        val leftChild = it.left    // Get the left child
        val rightChild = it.right  // Get the right child

        println("Node value: ${it.value}")
        println("Left child: ${leftChild?.value ?: "null"}")
        println("Right child: ${rightChild?.value ?: "null"}")
    }
}

// Example usage
fun main() {
    val root = TreeNode(1)   // Root node with value 1
    root.left = TreeNode(2)  // Left child with value 2
    root.right = TreeNode(3) // Right child with value 3
    root.left?.left = TreeNode(4)   // Left child of node 2
    root.left?.right = TreeNode(5)  // Right child of node 2
    root.right?.left = TreeNode(6)  // Left child of node 3
    root.right?.right = TreeNode(7) // Right child of node 3

    println("Before inversion:")
    printChildren(root)

    // Invert the tree
    val solution = Solution()
    solution.invertTree(root)

    println("\nAfter inversion:")
    printChildren(root)
}
