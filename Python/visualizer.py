from graphviz import Digraph

graph = Digraph(comment='Graph')
file = open("/home/tokarz/Documents/Projects/AAL_Algorytmy_Grafowe/AAL/out/production/AAL_Algorytmy_Grafowe/in.txt","r")

for line in file:
    numbers = line.split()
    if len(numbers) == 2:
        graph.edge(numbers[0],numbers[1])

file.close()

graph.render('graph.gv', view=True)