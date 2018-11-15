from graphviz import Digraph
import sys

graph = Digraph(comment='Graph')
file = open(sys.argv[1], "r")

for line in file:
    numbers = line.split()
    if len(numbers) == 2:
        graph.edge(numbers[0], numbers[1])

file.close()

graph.render('graph.gv', view=True)
