import networkx as nx
import matplotlib.pyplot as plt
from graphviz import Digraph

# file = open("/home/tokarz/Documents/Projects/AAL_Algorytmy_Grafowe/AAL/out/production/AAL_Algorytmy_Grafowe/in.txt","r")
# g = nx.Graph()

# for line in file:
#     numbers = [int(num) for num in line.split()]
#     if len(numbers) == 2:
#         g.add_edge(numbers[0],numbers[1])


# file.close()

# print nx.info(g)

# nx.draw(g,with_labels = True)

# plt.savefig("graph.png")

sfdp = Digraph(comment='Graph')
file = open("/home/tokarz/Documents/Projects/AAL_Algorytmy_Grafowe/AAL/out/production/AAL_Algorytmy_Grafowe/in.txt","r")

for line in file:
    numbers = line.split()
    if len(numbers) == 2:
        sfdp.edge(numbers[0],numbers[1])

file.close()

sfdp.render('graph.gv', view=True)