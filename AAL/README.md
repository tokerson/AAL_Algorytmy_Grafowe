
1. You can run this using program, in order to do so run terminal and use this command

		$java program.GraphGenerator <Number_of_Nodes> | java program.Main
	
   Replace <Number_of_Nodes> with number of nodes you want to be used when creating your program.Graph .

2. Alternatively, you can run 

		$java program.GraphGenerator <Number_of_Nodes> > in.txt
	
   This will create or overwrite file in.txt. This file will contain all the data about your program.Graph.
   
   Next you have to run
   
		$java program.Main < in.txt > out.txt
	
   And you will see the result stored in out.txt file. You can ommit '> out.txt' part. 
   
   Then you will get your output visible in the console.

3. In order to visualize your graph go into Python folder, then run 

		$python visualizer.py

   Your graph will appear in graph.gv.pdf file and should open automatically.

