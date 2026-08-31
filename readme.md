# vision

Data visualization.

## binary-tree-naive

A visualization of binary trees with constant offsets for the children. This is the naive thing you write in ten lines of code, before you realize the subtrees will immediately overlap.

## binary-tree-horizontal

An algorithm that maps out a binary tree without overlapping nodes. There are many ways to approach this. This solution builds the map via breadth first, and when an overlap is found, steps away the conflicting nodes horizontally until they all occupy unique locations. You cannot only step one node over. This needs to be recursive and hop different subbraches of the tree.
