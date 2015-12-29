File format for Distance Vector inputs:

First row contains the number of nodes (N).
Second row contains the number of edges (E).
Following rows contain directed edges in the following format:
From_node To_node Edge_weight

---------------------------------
Example:
3
3
0 1 1
1 2 1
2 0 1
---------------------------------
[This input corresponds to a directed 3-cycle with unit weights]

Your program should print out at least the following information:
Distance vector for every node with [destination] [next hop] [distance].

---------------------------------
Example:
Node 0
1 1 1
2 1 2 

Node 1
0 2 2
2 2 1

Node 2
0 0 1
1 0 2
---------------------------------

OPTIONAL:
Print solution to a file.